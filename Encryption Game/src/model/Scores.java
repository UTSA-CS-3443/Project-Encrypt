package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import controller.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class Scores {

	private ArrayList<Integer> scores;
	private ArrayList<Integer> topScores;
	
	public Scores() {
		this.scores = new ArrayList<Integer>();
		this.topScores = new ArrayList<Integer>();
	}
	
	/**
	 * Reads in all scores from scores.txt
	 */
	public void readScores() {
		Scanner in = null;
		try {
			in = new Scanner(new File("scores.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Failed to open scores.txt");
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
			if (this.scores.size() - 1 < i)
				this.topScores.add(0);
			else
				this.topScores.add(this.scores.get(i));
		}
	}
	
	/**
	 * Returns specified score in topScores ArrayList
	 * @param scoreNum
	 * @return
	 */
	public int getScore(int scoreNum) {
		if (this.topScores.size() < scoreNum)
			return 0;
		return this.topScores.get(scoreNum);
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
