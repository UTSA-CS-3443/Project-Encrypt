package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Level {

	public Level() {
		// TODO Auto-generated constructor stub
	}

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
