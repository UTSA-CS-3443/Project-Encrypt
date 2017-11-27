package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import model.EncryptPlayer;
import model.EncryptTool;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game {
	
	private String[] wordBank;			// Word bank of string values without encryption
	private String[] encryptedWordBank;	// Word bank of string values with encryption
	private String[] strarr_sentences;	// Words used by specific game
	private String[] strarr_codes; 		// Encrypted words used by specific game
	private int int_level;				// Index of current word
	private int int_score;				// Score determined by choosing to grade attempt
	private EncryptPlayer player;		// Current player
	private String str_currentSentence; 	// Current word
	private String str_mutatedSentence; 	// Current word after mutation, used to update str_currentSentence
	private char choice;
	
	public Game(String strp_playerName) {
//		wordBank = new String[] {	"interface",		"application", 		"method", 		"strings", 		"synchronized", 
//									"thread", 		"java", 				"encryption", 	"abstract", 		"class",
//									"exception",		"collection",		"generics",		"dependency",	"integer"		};
//
//		encryptedWordBank = new String[] {	"iqtgrvahg", 	"awwlyfatyon", 		"vgchnd",		"rsqhmfr",  		"flapuebavmrq",
//											"uisfbe",		"jxvx",				"rapelcgvba",	"pqhigpri",		"sbqii",
//											"fvafnrgml",		"lxuunlcrxw",		"trarevpf",		"qrcraqrapl",	"ejpacan"		};

		wordBank = new String[] {	"class",		"application", 		"java"};

		// To test sbqii, shift by 10. Other two test strings can be solved by simple substitutions.
		encryptedWordBank = new String[] {	"sbqii", 	"awwlyfatyon",		"jxvx"}; 
		
		
		strarr_sentences = new String[10];
		strarr_codes = new String[10];

		selectWords();

		int_level = 0;
		int_score = 0;
		player = new EncryptPlayer(strp_playerName);
		str_currentSentence = strarr_codes[int_level];
		choice = ' ';
	}
	
	/**
	 * This method stores a specified amount of unique words from wordBank and encryptedWordBank
	 * and stores them in strarr_sentences and strarr_codes respectively.
	 */
	public void selectWords() {
		
		ArrayList<Integer> wordIndeces = new ArrayList<Integer>();
		Random random = new Random();
		
		/* Store (3) words and encryptedWords */
		for (int i = 0; i < 3; i++) {
			int index = random.nextInt(wordBank.length);
			/* Validate words to ensure duplicates are not allowed within the same game */
			while (wordIndeces.contains(index)) {
				index = random.nextInt(wordBank.length);
			}
			wordIndeces.add(index);
			/* Store unencrypted words in strarr_sentences and encrypted words in strarr_codes */
			strarr_sentences[i] = wordBank[ index ];
			strarr_codes[i] = encryptedWordBank[ index ];
			/* For testing purposes, display which words are selected */
			System.out.println( "Original Word: " + strarr_sentences[i] );
			System.out.println( "Encrypted:     " + strarr_codes[i]);
		}
	}
	
	public String getSentence() {
		return this.str_currentSentence;
	}
	public void setSentence(String sentence) {
		this.str_currentSentence = sentence;
	}
	public char getChoice() {
		return this.choice;
	}
	public void setChoice(char choice) {
		this.choice = choice;
	}
	
	/**
	 * Method that runs the game. Runs a while loop that breaks when the player selects the quit option 'Q' when prompted.
	 * Prints out a menu (could probably be put in a method) as well as calls selected methods when the player makes a choice.
	 * This method is responsible for closing the scanner at the end of the game, so take care when attempting to access the 
	 * scanner once this method has run.
	 */
	public void runGame(char choice) {
		if (strarr_codes[int_level] != null) {
			switch(choice){
				case 'B': // Substitution
					break;
				case 'H': // Shift
					break;
				case 'G': // Grade
					scoreSentence(str_currentSentence);
					int_level++;
					setSentence( strarr_codes[int_level] );
					int_score = 0;
					break;
				case 'Q': // Quit
					System.out.println("Game over. Goodbye!");
					break;
				default: // Start game
					break;
			}
		}
		else 
			System.out.println("No more words to decrypt. Game over.");
	}
	
	/**
	 * Provides the interface information for the shift sentence option when selected by the player. Calls the EncryptTool class to actually do the work.
	 * Take note that this actually shifts backwards instead of forwards. Also note that this method will only shift by a maximum of 25 characters at a time.
	 * @return Mutated string that has been shifted by the EncryptTool.
	 */
	public String shiftSentence(String shiftValue){
		// int int_shift = (shiftValue.charAt(0) - '0') % 26;
		int int_shift = (Integer.parseInt(shiftValue)) % 26;
		String str_mutatedSentence = EncryptTool.shiftTool(-int_shift, str_currentSentence);
		setSentence(str_mutatedSentence);
		return str_mutatedSentence;
	}
	
	/**
	 * Provides the interface information for the substitution option when selected by the player. Calls the EncryptTool class to actually do the work.
	 * @return Mutated string that has been substituted by the EncryptTool.
	 */
	public String substituteLetter(char replacedLetter, char replacementLetter){
		String str_mutatedSentence = EncryptTool.substitutionTool(replacedLetter, replacementLetter, str_currentSentence);
		setSentence(str_mutatedSentence);
		return str_mutatedSentence;
	}

	/**
	 * Scores the current sentences as modified by the player, giving 5 points per matched character. The method then adds the points gained to the 
	 * player object's score.
	 * @param strp_attemptSentence Current sentence that has been modified by the player.
	 */
	public void scoreSentence(String strp_attemptSentence){
		int int_length;
		if(strarr_sentences[int_level].length() < strp_attemptSentence.length()){
			int_length = str_currentSentence.length();
		}else if(strarr_sentences[int_level].length() > strp_attemptSentence.length()){
			int_length = strp_attemptSentence.length();
		}else{
			int_length = strarr_sentences[int_level].length();
		}
		
		for(int i = 0; i < int_length; i++){
			if(strp_attemptSentence.charAt(i) == strarr_sentences[int_level].charAt(i)){
				int_score +=5;
			}
		}
		System.out.println("You scored " + int_score + " points!");
		System.out.println("Actual Sentence: " + strarr_sentences[int_level] + "\n Your Sentence: " + strp_attemptSentence);
		player.changeScore(int_score);
	}


	public void backToMainMenu(Stage primaryStage) {
		/* If user chooses to return to main menu */
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encrypt: Main Menu");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
