package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Scores;

public class ScoresController implements EventHandler<ActionEvent>{

	private Scores score;
	
	public ScoresController() {
		// TODO Auto-generated constructor stub
		this.score = new Scores();
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		if (b.getText().equals("Back to Main Menu")) {
			Stage newStage = (Stage) b.getScene().getWindow();
			this.score.backToMainMenu(newStage);
		}
	}
}
