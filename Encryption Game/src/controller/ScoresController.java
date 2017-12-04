package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Scores;

public class ScoresController implements EventHandler<ActionEvent>{

	private Scores score;
	
	public ScoresController() {
		super();
		this.score = new Scores();
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Back to Main Menu")) {
			this.score.backToMainMenu(newStage);
		}
		if (b.getText().equals("Score 1"))
		{
			this.score.LoadScore(newStage);
		}
		if(b.getText().equals("Score 2"))
		{
			this.score.LoadScore(newStage);
		}
		if(b.getText().equals("Score 3"))
		{
			this.score.LoadScore(newStage);
		}
		if(b.getText().equals("Score 4"))
		{
			this.score.LoadScore(newStage);
		}
	}
}
