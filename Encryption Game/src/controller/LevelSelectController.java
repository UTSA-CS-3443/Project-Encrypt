package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Level;

public class LevelSelectController implements EventHandler<ActionEvent>{

	private Level level;
	
	public LevelSelectController() {
		// TODO Auto-generated constructor stub
		super();
		this.level = new Level();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Button b = (Button) event.getSource();
		System.out.println( b.getText() );
		if (b.getText().equals("Back to Main Menu")) {
			Stage newStage = (Stage) b.getScene().getWindow();
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
