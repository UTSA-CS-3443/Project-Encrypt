package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import controller.HighScoreController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scores {
	
	private ArrayList<Integer> scores;
	private ArrayList<Integer> topScores;
	private int level;
	
	public Scores() {
		this.scores = new ArrayList<Integer>();
		this.topScores = new ArrayList<Integer>();
	}
	
	/**
	 * This method sets the current level for which scores will be processed
	 * @param level Specified level for which scores will be processed
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Reads in all scores from scores file of specified level
	 */
	public void readScores() {
		Scanner in = null;
		try {
			if (this.level == 1)
				in = new Scanner(new File("scores1.txt"));
			else if (this.level == 2)
				in = new Scanner(new File("scores2.txt"));
			else if (this.level == 3)
				in = new Scanner(new File("scores3.txt"));
			else 
				in = new Scanner(new File("scores4.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Failed to open scores file");
			System.exit(1);
		}
		while (in.hasNext()) {
			this.scores.add(Integer.parseInt(in.next()));
		}
		in.close();
	}
	
	/**
	 * Sorts scores ArrayList in reverse order and adds top 4 scores to topScores ArrayList
	 */
	public void getTopScores() {
		Collections.sort(scores);
		Collections.reverse(scores);
		for (int i = 0; i < 4; i++) {
			if (this.scores.size() - 1 < i) {
				this.topScores.add(0);
				System.out.println("Score " + i + " = " + this.topScores.get(i));
			}
			else {
				this.topScores.add(this.scores.get(i));
				System.out.println("Score " + i + " = " + this.topScores.get(i));
			}
		}
	}
	
	/**
	 * Returns specified score in topScores ArrayList
	 * @param scoreNum specified index of score in topScores
	 * @return score associated with topScores.get(scoreNum)
	 */
	public int getScore(int scoreNum) {
		if (this.topScores.size() < scoreNum)
			return 0;
		return this.topScores.get(scoreNum);
	}
	
	/**
	 * This methods loads the high score view based on the level selected 
	 * @param primaryStage Stage object for loading the next scene
	 * @param level Level from which highscores will be displayed
	 */
	public void LoadScore(Stage primaryStage, int level ) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HighScoreView.fxml"));
			Parent root = (Parent) loader.load();
			HighScoreController controller = loader.getController();
			controller.setLevel(level);
			controller.setupScores(level);
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
	
	/**
	 * This method allows the user to return to the scores menu 
	 * @param primaryStage Stage object to set new scene on
	 */
	public void backToScoresMenu(Stage primaryStage) {
		/* If user chooses to return to main menu */
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/ScoresView.fxml"));
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encrypt: Scores");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
