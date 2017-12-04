package model;

import controller.GameController;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class Scores {

	public Scores() {
		
	}
	
	/**
	 * Returns the current score 
	 * @param score
	 * @return
	 */
	public void LoadScore(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HighScoreView.fxml"));
			Parent root = (Parent) loader.load();
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encrypt");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void randomScore()
	{
		int[] randomScore = new int[5];
		Random rand = new Random();
		for(int i = 0; i < 6; i++)
		{
			randomScore[i] = rand.nextInt(100) + 20;
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
