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
	private int[] randomScores1;
	private int[] randomScores2;
	private int[] randomScores3;
	private int[] randomScores4;
	@FXML
	private Button showScores;
	
	public ScoresController() {
		super();
		this.scores = new Scores();
//		randomScores1 = new int[4];
//		
//		
//		
//		this.scores = new Scores();
//		this.scores.randomScore(randomScores1);
//		this.scores.rankScore(randomScores1);
//		this.scores.readScores(randomScores1);
//	
//		
//		randomScores2 = new int[4];
//		this.scores = new Scores();
//		this.scores.randomScore(randomScores2);
//		this.scores.rankScore(randomScores2);
//		this.scores.readScores(randomScores2);
//	
//		
//		randomScores3 = new int[4];
//		this.scores = new Scores();
//		this.scores.randomScore(randomScores3);
//		this.scores.rankScore(randomScores3);
//		this.scores.readScores(randomScores3);
//		
//		
//		randomScores4 = new int[4];
//		this.scores = new Scores();
//		this.scores.randomScore(randomScores4);
//		this.scores.rankScore(randomScores4);
//		this.scores.readScores(randomScores4);
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
//		if (b.getText().equals("Level 1 Scores"))
//		{
//			this.scores.LoadScore(newStage, randomScores1);
//		}
//		if(b.getText().equals("Level 2 Scores"))
//		{
//			this.scores.LoadScore(newStage, randomScores2);
//		}
//		if(b.getText().equals("Level 3 Scores"))
//		{
//			this.scores.LoadScore(newStage, randomScores3);
//		}
//		if(b.getText().equals("Level 4 Scores"))
//		{
//			this.scores.LoadScore(newStage, randomScores4);
//		}
		if (b.getText().equals("Level 1 Scores"))
		{
			this.scores.LoadScore(newStage, 1);
		}
		if(b.getText().equals("Level 2 Scores"))
		{
			this.scores.LoadScore(newStage, 2);
		}
		if(b.getText().equals("Level 3 Scores"))
		{
			this.scores.LoadScore(newStage, 3);
		}
		if(b.getText().equals("Level 4 Scores"))
		{
			this.scores.LoadScore(newStage, 4);
		}
	}
}
