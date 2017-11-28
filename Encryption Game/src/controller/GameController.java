package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Game;

public class GameController implements EventHandler<ActionEvent>{

	@FXML
	private Label currentWord;			// Label to display current state of encryption
	@FXML								
	private Label prompt;				// Label to display messages/instructions to the user
	@FXML
	private TextField input;				// TextField for receiving user input
	private Game game;					// Game instance
	private char choice;					// Single character indicating menu choice
	private boolean start;
	private boolean acceptingInput;		// Indicates that program is ready to accept input
	private boolean subPart1;			// Indicates that program is ready to accept letter to be replaced
	private boolean subPart2;			// Indicates that program is ready to accept replacement letter
	private char replacementLetter;		// Letter in currentWord to be replaced
	private char replacedLetter;			// Letter to replace replacementLetter in currentWord
	private int level;					// Game level selected by user
	
	public GameController() {
		super();
		// this.game = new Game("Player 1", level);	
		this.start = false;
		this.acceptingInput = false;
		this.subPart1 = false;
		this.subPart2 = false;
		this.choice = ' ';
	}
	
	public void setLevel(int level) {
		// this.level = level;
		this.game = new Game("Player 1", level);
	}
	
	public void setChoice(char choice) {
		this.choice = choice;
	}
	public char getChoice() {
		return this.choice;
	}

	public void handle(ActionEvent event) {
		
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		
		/* User has entered input at the program's request and clicked on 'Submit' */
		while (this.acceptingInput && b.getText().equals("Submit")) { 
			/* User has entered letter to be replaced */
			if (getChoice() == 'B' && subPart1) {
				replacedLetter = input.getText().charAt(0);
				this.prompt.setText("Substituting!\nEnter a letter to replace " + replacedLetter + " with:");
				this.subPart2 = true;
				this.subPart1 = false;
				this.input.setText("");
				break;
			}
			/* User has entered replacement letter */
			if (getChoice() == 'B' && subPart2) {
				replacementLetter = input.getText().charAt(0);
				this.game.substituteLetter(replacedLetter, replacementLetter);
				this.prompt.setText("Substitute, Shift, Check Your Answer, \nor Quit to Main Menu");
				this.currentWord.setText(this.game.getSentence());
				this.subPart1 = false;
				this.input.setText("");
				break;
			}
			/* User has entered shift value */
			if (getChoice() == 'H') {
				this.game.shiftSentence(this.input.getText());
				this.currentWord.setText(this.game.getSentence());
				this.prompt.setText("Substitute, Shift, Check Your Answer, \nor Quit to Main Menu");
				this.input.setText("");
				break;
			}
		}
		/* User has chosen to start the current game */
		if (b.getText().equals("START")) {
			this.start = true;
			this.currentWord.setText( this.game.getSentence() );
			this.prompt.setText( "Substitute, Shift, Check Your Answer, \nor Quit to Main Menu" );
		}
		/* Only allow substitutions, shifts, and answer checks after user has chosen to start the game */
		if (start) {
			/* User has chosen to substitute */
			if (b.getText().equals("Substitution")) {
				setChoice('B');
				this.currentWord.setText(this.game.getSentence());
				this.prompt.setText("Substituting!\nEnter a letter (a-z) to replace:");
				this.subPart1 = true;
				this.acceptingInput = true;
			}
			/* User has chosen to shift */
			if (b.getText().equals("Shift")) {
				setChoice('H');
				this.currentWord.setText(this.game.getSentence());
				this.prompt.setText("Shifting!\nEnter a shift value (0-26) below");
				this.acceptingInput = true;
			}
			/* User has chosen to check answer */
			if (b.getText().equals("Check Answer")) {
				this.game.setChoice('G');
				this.game.runGame('G');
				this.currentWord.setText( this.game.getSentence() );
			}
		}
		/* User has chosen to return to the main menu */
		if (b.getText().equals("Quit to Main Menu")) {
			setChoice('Q');
			this.game.setChoice('Q');
			Stage newStage = (Stage) b.getScene().getWindow();
			this.game.backToMainMenu(newStage);
		}	
	}
}
