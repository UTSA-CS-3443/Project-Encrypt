package controller;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Scores;

public class HighScoreController implements EventHandler<ActionEvent>{


	private Scores scores;
	private int level;
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
		this.scores = new Scores();
	}
	/**
	 * This method sets the level for which all scores will be displayed
	 * @param level level for which all scores will be displayed
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Loads top four scores for the specified level. 
	 * If no score has been recorded for a particular rank (Score 2, Score 3, etc.), score is denoted with a "-"
	 * @param level level for which all scores will be displayed
	 */
	public void setupScores(int level) {
		this.scores.setLevel(this.level);
		this.scores.readScores();
		this.scores.getTopScores();
		if (scores.getScore(0) != 0) 
			score1.setText("" + scores.getScore(0));
		else
			score1.setText("-");
		if (scores.getScore(1) != 0) 
			score2.setText("" + scores.getScore(1));
		else
			score2.setText("-");
		if (scores.getScore(2) != 0) 
			score3.setText("" + scores.getScore(2));
		else
			score3.setText("-");
		if (scores.getScore(3) != 0) 
			score4.setText("" + scores.getScore(3));
		else
			score4.setText("-");
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Back to Main Menu")) {
			this.scores.backToMainMenu(newStage);
		}
		if (b.getText().equals("Back to Scores Menu")) {
			this.scores.backToScoresMenu(newStage);
		}
	}
}
