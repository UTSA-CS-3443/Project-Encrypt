package model;

import controller.GameController;
import controller.QuitController;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainMenu {
	
	public MainMenu() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method launches the scene chosen by the user from the main menu
	 * @param selection String representing the text of the button clicked in MainView
	 * @param primaryStage Stage object for setting up next scene
	 */
	public void changeMode(String selection, Stage primaryStage) {
		try {
			Parent root;
			// Determine which FXML to load from main menu selection
			if (selection.equals("Start")) {
				// Load Level 1 by default 
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameView.fxml"));
				root = (Parent) loader.load();
				GameController controller = loader.getController();
				controller.setLevel(1);
				primaryStage .setTitle("Project Encrypt");
			} else if (selection.equals("Level Select")) {
				root = FXMLLoader.load(getClass().getResource("/view/LevelView.fxml"));
				primaryStage .setTitle("Project Encrypt: Level Select");
			} else if (selection.equals("Quit")) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/QuitView.fxml"));
				root = (Parent) loader.load();
				QuitController controller = loader.getController();
				controller.setStage(primaryStage);
			}
			else {
				root = FXMLLoader.load(getClass().getResource("/view/ScoresView.fxml"));
				primaryStage .setTitle("Project Encrypt: Scores");
			}
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
