package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Level;

public class LevelSelectController implements EventHandler<ActionEvent>{

	private Level level;
	
	public LevelSelectController() {
		super();
		this.level = new Level();
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		System.out.println( b.getText() );
		
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Level 1")) {
			this.level.loadLevel(newStage, 1);
		}
		if (b.getText().equals("Level 2")) {
			this.level.loadLevel(newStage, 2);
		}
		if (b.getText().equals("Level 3")) {
			this.level.loadLevel(newStage, 3);
		}
		if (b.getText().equals("Level 4")) {
			this.level.loadLevel(newStage, 4);
		}
		
		if (b.getText().equals("Back to Main Menu")) {
			this.level.backToMainMenu(newStage);
		}
		if(b.getText().equals("Level 1")) 
		{
		}
		if(b.getText().equals("Level 2"))
		{
		}
		if(b.getText().equals("Level 3"))
		{
		}
		if(b.getText().equals("Level 4"))
		{
		}
	}

}
