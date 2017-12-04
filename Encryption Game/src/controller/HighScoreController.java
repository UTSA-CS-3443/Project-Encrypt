package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Scores;

public class HighScoreController implements EventHandler<ActionEvent>{

	private Scores scores;
	
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
		
		if (b.getText().equals("Back To Main Menu")) {
			this.scores.backToMainMenu(newStage);
		}
	}
}
