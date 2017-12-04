package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Scores;
import model.Game;

public class HighScoreController implements EventHandler<ActionEvent>{

	private Scores scores;
	@FXML
	private Label playerScore;
	@FXML
	private Label playerName;
	@FXML
	private TextField playerInput;
	private String player;
	
	public HighScoreController()
	{
		super();
		this.scores = new Scores();
	}
	
	public void handle(ActionEvent event)
	{
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		Stage newStage = (Stage) b.getScene().getWindow();
		Game game = new Game(player, 1);
		
		
		if (b.getText().equals("Back To Main Menu")) {
			this.scores.backToMainMenu(newStage);
		}
		if (b.getText().equals("SUBMIT"))
		{
			this.playerName.setText(playerInput.getText());
			this.playerScore.setText("" + game.getScore());
		}
		
	}
}
