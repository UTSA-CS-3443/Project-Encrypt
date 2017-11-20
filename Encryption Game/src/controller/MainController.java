package controller;
import core.EncryptGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements EventHandler<ActionEvent> {
	
	private EncryptGame game;
	
	public MainController()
	{
		super();
		game = new EncryptGame("Player1");
	}

	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		game.update(b.getText());
		
	}

}
