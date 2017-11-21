package controller;
import core.EncryptGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController implements EventHandler<ActionEvent> {
	
	private EncryptGame game;
	
	public MainController()
	{
		super();
		game = new EncryptGame("Player1");
	}

	@Override
	public void handle(ActionEvent event)  {
		try {
		Button b = (Button) event.getSource();
		Stage temp = (Stage) b.getScene().getWindow();
		System.out.println(b.getText());
		game.update(b.getText(), temp);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
