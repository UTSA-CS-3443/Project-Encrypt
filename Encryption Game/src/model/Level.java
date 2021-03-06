package model;

import controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Level {

	public Level() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method loads the level selected by the user
	 * @param primaryStage Stage object for loading level
	 * @param level specified level selected by the user
	 */
	public void loadLevel (Stage primaryStage, int level) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GameView.fxml"));
			Parent root = (Parent) loader.load();
			GameController controller = loader.getController();
			controller.setLevel(level);
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encrypt");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method allows the user to return to the main menu 
	 * @param primaryStage Stage object to set new scene on
	 */
	public void backToMainMenu(Stage primaryStage) {
		/* If user chooses to return to main menu */
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));			
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encrypt: Main Menu");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
