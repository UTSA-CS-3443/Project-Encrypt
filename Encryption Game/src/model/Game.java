package model;

import model.EncryptPlayer;
import model.EncryptTool;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game {
	private Bank wordBank;			// Word bank of string values without encryption
	private Bank encryptedBank; // Word bank of string values with encryption
	private int wordIndex;				// Index of current word
	private int int_score;				// Score determined by choosing to grade attempt
	private EncryptPlayer player;		// Current player
	private String str_currentSentence; 	// Current word
	private char choice;
	
	public Game(String strp_playerName, int gameLevel) {
		wordBank = new WordBank(gameLevel);
		encryptedBank = new EncryptedBank(gameLevel);
		wordIndex = 0;
		int_score = 0;
		player = new EncryptPlayer(strp_playerName);
		str_currentSentence = encryptedBank.getWord(wordIndex);
		choice = ' ';
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
	
	public int getIndex() {
		return this.wordIndex;
	}
	
	/**
	 * Method that runs the game. Runs a while loop that breaks when the player selects the quit option 'Q' when prompted.
	 * Prints out a menu (could probably be put in a method) as well as calls selected methods when the player makes a choice.
	 * This method is responsible for closing the scanner at the end of the game, so take care when attempting to access the 
	 * scanner once this method has run.
	 */
	public void runGame(char choice) {
		if (wordIndex < 3) {
			switch(choice){
				case 'B': // Substitution
					break;
				case 'H': // Shift
					break;
				case 'G': // Grade
					scoreSentence(str_currentSentence);
					wordIndex++;
					if (wordIndex <= 2)
						setSentence( encryptedBank.getWord(wordIndex));
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
		if (wordBank.getWord(wordIndex).length() < strp_attemptSentence.length()){
			int_length = str_currentSentence.length();
		}else if (wordBank.getWord(wordIndex).length() > strp_attemptSentence.length()){
			int_length = strp_attemptSentence.length();
		}else{
			int_length = wordBank.getWord(wordIndex).length();
		}
		for(int i = 0; i < int_length; i++){
			if(strp_attemptSentence.charAt(i) == wordBank.getWord(wordIndex).charAt(i)){
				int_score +=5;
			}
		}
		System.out.println("You scored " + int_score + " points!");
		System.out.println("Actual Word: " + wordBank.getWord(wordIndex) + "\n Your Word: " + strp_attemptSentence);
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
