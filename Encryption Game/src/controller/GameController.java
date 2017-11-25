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
	@FXML
	private Label output;
	private Game game;
	
	public GameController() {
		super();
		this.game = new Game("Player 1");
	}

	public void handle(ActionEvent event) {
		
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		
		// Display current state of encrypted word
		this.currentWord.setText( this.game.getSentence() );
		
		if (b.getText().equals("START")) {
			this.game.runGame();
		}
		
		if (b.getText().equals("Substitution")) {
			
		}
		
		if (b.getText().equals("Shift")) {
			
		}
		
		if (b.getText().equals("Check Answer")) {
			
		}
		
		// If user chose to return to the main menu
		if (b.getText().equals("Back to Main Menu")) {
			Stage newStage = (Stage) b.getScene().getWindow();
			this.game.backToMainMenu(newStage);
		}
	}
}
