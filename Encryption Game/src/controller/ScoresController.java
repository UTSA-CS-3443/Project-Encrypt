package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Scores;

public class ScoresController implements EventHandler<ActionEvent>{

	private Scores scores;
	@FXML
	private Label score1;
	@FXML
	private Label score2;
	@FXML
	private Label score3;
	@FXML
	private Label score4;
	@FXML
	private Button showScores;
	
	public ScoresController() {
		super();
		this.scores = new Scores();
	}
	
	public void setupScores() {
		this.scores.readScores();
		this.scores.getTopScores();		
		this.score1.setText( "" + this.scores.getScore(0) );
		this.score2.setText( "" + this.scores.getScore(1) );
		this.score3.setText( "" + this.scores.getScore(2) );
		this.score4.setText( "" + this.scores.getScore(3) );
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		System.out.println(event.toString());
		
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Back to Main Menu")) {
			this.scores.backToMainMenu(newStage);
		}
		if (b.getText().equals("Score 1"))
		{
			this.scores.LoadScore(newStage);
		}
		if(b.getText().equals("Score 2"))
		{
			this.scores.LoadScore(newStage);
		}
		if(b.getText().equals("Score 3"))
		{
			this.scores.LoadScore(newStage);
		}
		if(b.getText().equals("Score 4"))
		{
			this.scores.LoadScore(newStage);
		}
	}
}
