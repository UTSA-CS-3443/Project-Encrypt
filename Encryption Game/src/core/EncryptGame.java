package core;
import java.util.*;

/**
 * Workhorse class of the project, is responsible for running the game and keeping track of everything from scoring to actual interaction.
 * Currently only interacts with the console, though with a bit of work could easily be adapted to work with a GUI.
 * @author Connor Guerra
 *
 */
public class EncryptGame {
	
	// @Richie
	private String[] wordBank;
	private String[] encryptedWordBank;
	
	private String[] strarr_sentences, strarr_codes;
	private int int_level, int_score;
	private EncryptPlayer player;
	private String str_currentSentence;
	private Scanner scan;
	
	/**
	 * Constructor of the Encrypt Game, currently takes in a parameter for the player's name. Initializes all variables needed to run the game,
	 * as well as currently has several hard-coded values to aid testing.
	 * @param strp_playerName Name of the player, should definitely find a better way to do this.
	 */
	public EncryptGame(String strp_playerName){
		/**
		 * @Richie
		 * Added wordBank and encryptedWordBank. Each string in encyptedWordBank is associated with the string in wordBank that 
		 * has the same index.
		 */
		wordBank = new String[] {"Interface", "Application", "Method"};
		encryptedWordBank = new String[] {"Iqtgrvahg", "Awwlyfatyon", "Vgchnd"};
		
		strarr_sentences = new String[10];
		strarr_codes = new String[10];
		int_level = 0;
		int_score = 0;
		player = new EncryptPlayer(strp_playerName);
		str_currentSentence = strarr_codes[int_level];
		scan = new Scanner(System.in);
	}
	/**
	 * @Richie
	 * This method stores a specified amount of unique words from wordBank and encryptedWordBank
	 * and stores them in strarr_sentences and strarr_codes respectively.
	 */
	public void selectWords() {
		
		ArrayList<Integer> wordIndeces = new ArrayList<Integer>();
		Random random = new Random();
		
		/* Store (3) words and encryptedWords */
		for (int i = 0; i < 3; i++) {
			int index = random.nextInt(3);
			/* Validate words to ensure duplicates are not allowed within the same game */
			while (wordIndeces.contains(index)) {
				index = random.nextInt(3);
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
	
	/**
	 * Method that runs the game. Runs a while loop that breaks when the player selects the quit option 'Q' when prompted.
	 * Prints out a menu (could probably be put in a method) as well as calls selected methods when the player makes a choice.
	 * This method is responsible for closing the scanner at the end of the game, so take care when attempting to access the 
	 * scanner once this method has run.
	 */
	public void runGame(){
		selectWords();
		char chr_choice = ' ';
		System.out.println("Welcome to the Encryption Project!");
		str_currentSentence = strarr_codes[int_level];
		/* Run game until user chooses to quit or until no more encrypted words remain */
		while(chr_choice != 'q' && chr_choice != 'Q' && strarr_codes[int_level] != null){
			System.out.println("Current word: " + str_currentSentence);
			System.out.println("Please press \'B\' for Su(b)stitution.");
			System.out.println("Please press \'H\' to S(h)ift the letters.");
			System.out.println("Please press \'G\' to (G)rade your sentence and move on.");
			System.out.println("Please press \'Q\' to (Q)uit.");
			System.out.print("Please enter a choice:");
			chr_choice = scan.next().charAt(0);
			
			switch(chr_choice){
				case 'b':
				case 'B':
					str_currentSentence = substituteLetter();
					break;
				case 'h':
				case 'H':
					str_currentSentence = shiftSentence();
					break;
				case 'g':
				case 'G':
					scoreSentence(str_currentSentence);
					// TODO: Need to add ability to check if it is about to go out of bounds, as well as maybe set up a reset method.
					// @Richie: Fixed by adding condition in main while loop
					int_level++;
					str_currentSentence = strarr_codes[int_level];
					int_score = 0;
					break;
				case 'q':
				case 'Q':
					// Exit print statement moved to execute after while loop is exited
					// System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Sorry, I didn\'t understand that! Please enter a valid command.");
					break;
		
		
			}
		}
		System.out.println("Game over. Goodbye!");
		scan.close();
	}

	/**
	 * Provides the interface information for the shift sentence option when selected by the player. Calls the EncryptTool class to actually do the work.
	 * Take note that this actually shifts backwards instead of forwards. Also note that this method will only shift by a maximum of 25 characters at a time.
	 * @return Mutated string that has been shifted by the EncryptTool.
	 */
	public String shiftSentence(){
		System.out.println("Shifting!");
		System.out.println("How many letters would you like to shift the word?");
		System.out.print("Shift distance: ");
		int int_shift = scan.nextInt() % 26;
		String str_mutatedSentence = EncryptTool.shiftTool(-int_shift, str_currentSentence);
		System.out.println("Current Sentence is now: " + str_mutatedSentence);
		return str_mutatedSentence;
	}
	
	/**
	 * Provides the interface information for the substitution option when selected by the player. Calls the EncryptTool class to actually do the work.
	 * @return Mutated string that has been substituted by the EncryptTool.
	 */
	public String substituteLetter(){
		System.out.println("Substituting!!");
		System.out.println("Which letter would you like to replace?");
		System.out.print("Replaced Letter:");
		char chr_replacedLetter = scan.next().charAt(0);
		System.out.println("What do you want to replace that letter with?");
		System.out.print("Replacement Letter:");
		char chr_replacementLetter = scan.next().charAt(0);
		String str_mutatedSentence = EncryptTool.substitutionTool(chr_replacedLetter, chr_replacementLetter, str_currentSentence);
		System.out.println("Current Sentence is now: " + str_mutatedSentence);
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
}
