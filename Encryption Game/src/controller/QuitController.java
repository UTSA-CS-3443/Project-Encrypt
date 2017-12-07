package controller;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Quit;

public class QuitController implements EventHandler<ActionEvent>{

	@FXML
	private Quit quit; 					// Quit object
	private Stage primaryStage;			// Stage object
	private PauseTransition delay;		// Controls whether or not application will close
	
	public QuitController() {
		quit = new Quit();
	};
	
	/**
	 * This method sets a PauseTransition that will close the application in 5 seconds
	 * unless user clicks on "Cancel"
	 */
	public void initialize() {
		this.delay = new PauseTransition(Duration.seconds(5));
		this.delay.setOnFinished( event -> primaryStage.close() );
		this.delay.play();
	}
	
	/**
	 * This method recieves the stage identifier of the current view
	 * @param stage stage identifier of the current view
	 */
	public void setStage(Stage stage) {
		this.primaryStage = stage;
	}
	
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		/* If user chooses cancel, application will return to main menu */
		if (b.getText().equals("Cancel")) {
			this.delay.stop();	// Cancel automatic close action set in initialize()
			Stage newStage = (Stage) b.getScene().getWindow();
			quit.backToMainMenu(newStage);
		}
	}

}
