package controller;

import javafx.event.ActionEvent;
import controller.ScoresController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Scores;

public class HighScoreController implements EventHandler<ActionEvent>{


	private Scores scores;
	private int[] highScores;
	@FXML
	private Label playerScore;
	@FXML
	private Label playerName;
	@FXML
	private TextField playerInput;
	@FXML
	private Label score1;
	@FXML
	private Label score2;
	@FXML
	private Label score3;
	@FXML
	private Label score4;
	
	public HighScoreController()
	{
		super();
		scores = new Scores();
		highScores = new int[4];
		for(int i = 0; i < 4; i++)
		{
			highScores[i] = scores.getScore(i);
		}
		
	}
	
	public void initialize()
	{
		score1.setText("" + highScores[3]);
		score2.setText("" + highScores[2]);
		score3.setText("" + highScores[1]);
		score4.setText("" + highScores[0]);
		playerScore.setText("");
	}
	
	public void readScores(int[] a)
	{
		for(int i = 0; i < 4; i++)
		{
			highScores[i] = a[i];
		}
	}
	public void handle(ActionEvent event)
	{
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Back To Main Menu")) {
			this.scores.backToMainMenu(newStage);
		}
		if (b.getText().equals("SUBMIT"))
		{
			this.playerName.setText(playerInput.getText());
		}
		
	}
}
