package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Scores;

public class ScoresController implements EventHandler<ActionEvent>{

	private Scores score;
	
	/*@FXML
	private Label score1;
	@FXML
	private Label score2;
	@FXML
	private Label score3;
	@FXML
	private Label score4;*/
	
	
	public ScoresController() {
		super();
		this.score = new Scores();
		/*this.score1.setText( getScore(1) );
		this.score1.setText( getScore(2) );
		this.score1.setText( getScore(3) );
		this.score1.setText( getScore(4) );*/
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
			this.score.LoadScore(newStage, 1);
		}
		if(b.getText().equals("Score 2"))
		{
			this.score.LoadScore(newStage, 2);
		}
		if(b.getText().equals("Score 3"))
		{
			this.score.LoadScore(newStage, 3);
		}
		if(b.getText().equals("Score 4"))
		{
			this.score.LoadScore(newStage, 4);
		}
	}
}
