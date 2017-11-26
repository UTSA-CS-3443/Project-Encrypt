package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Game;

public class GameController implements EventHandler<ActionEvent>{

	@FXML
	private Label currentWord;
	
	//@FXML 
	//private Label shiftWord;
	@FXML
	private Label prompt;
	private Game game;
	
	public GameController() {
		super();
		this.game = new Game("Player 1");
	}

	public void handle(ActionEvent event) {
		
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		
		if (b.getText().equals("START")) {
			this.currentWord.setText( this.game.getSentence() );
			this.prompt.setText( "Choose a Substitution, Check Your Answer, \nor Quit to Main Menu" );
		}
		
		if (b.getText().equals("Substitution")) {
			this.currentWord.setText(this.game.getSubSentence());
			this.prompt.setText("Substituting!\nWhich letter would you like to replace?");
		}
		
		if (b.getText().equals("Shift")) {
			this.currentWord.setText(this.game.getShiftSentence());
			this.prompt.setText("Shifting!\nHow many letters would you like to shift the word?");
		}
		
		if (b.getText().equals("Check Answer")) {
			this.game.setChoice('G');
		}
		
		if (b.getText().equals("Quit to Main Menu")) {
			this.game.setChoice('Q');
		}
		
		this.game.runGame();
		
		this.currentWord.setText( this.game.getSentence() );
		
		this.currentWord.setText( this.game.getShiftSentence() );
		
		// If user chose to return to the main menu
		if (b.getText().equals("Back to Main Menu")) {
			Stage newStage = (Stage) b.getScene().getWindow();
			this.game.backToMainMenu(newStage);
		}
	}
}
