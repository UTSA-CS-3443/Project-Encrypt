package controller;

import model.MainMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainController implements EventHandler<ActionEvent> {

	private MainMenu mainMenu;
	private Stage newStage;
	
	public MainController() {
		// TODO Auto-generated constructor stub
		super();
		this.mainMenu = new MainMenu();
	}
	
	/**
	 * Change stage based on main menu selection
	 */
	public void handle(ActionEvent event) {
		Button b = (Button) event.getSource();
		this.newStage = (Stage) b.getScene().getWindow();
		System.out.println( b.getText() );
		this.mainMenu.changeMode(b.getText(), newStage);
	}
}
