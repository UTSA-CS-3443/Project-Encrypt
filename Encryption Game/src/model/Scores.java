package model;

import java.util.ArrayList;

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
	public String getScore(int score) {
		if (this.scores.get(score) == null)
			return "Score" + score;
		else 
			return this.scores.get(score);
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
