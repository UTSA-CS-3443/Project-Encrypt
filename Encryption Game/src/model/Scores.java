package model;

import java.util.ArrayList;

import controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scores {

	ArrayList<String> scores;
	
	public Scores() {
		// TODO Auto-generated constructor stub
		this.scores = new ArrayList<String>();
	}
	
	/**
	 * Returns the current score 
	 * @param score
	 * @return
	 */
	public void LoadScore(Stage primaryStage, int level) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HighScoreView.fxml"));
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
