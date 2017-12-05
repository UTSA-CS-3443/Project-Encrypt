package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

import controller.GameController;
import controller.HighScoreController;

import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Scores {

//	private int[] score;
//	BufferedWriter bw = null;
//	FileWriter fw = null;
//	
//	public Scores() {
//		score = new int[4];
//	}
//	
//	/**
//	 * Reads in all scores from scores array
//	 * @param a
//	 */
//	public void readScores(int[] a) {
//		try {
//			fw = new FileWriter("scores.txt");
//			bw = new BufferedWriter(fw);
//			for(int i = 0; i < 4; i++)
//			{
//				bw.write("" + a[i] + "\n");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			bw.close();
//			fw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	/**
//	 * Returns specified score in score Array
//	 * @param scoreNum 
//	 * @return
//	 */
//	public int getScore(int scoreNum) {
//		return score[scoreNum];
//	}
	
	private ArrayList<Integer> scores;
	private ArrayList<Integer> topScores;
	private int level;
	
	public Scores() {
		this.scores = new ArrayList<Integer>();
		this.topScores = new ArrayList<Integer>();
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * Reads in all scores from scores.txt
	 */
	public void readScores() {
		Scanner in = null;
		try {
//<<<<<<< HEAD
			if (this.level == 1)
				in = new Scanner(new File("scores1.txt"));
			else if (this.level == 2)
				in = new Scanner(new File("scores2.txt"));
			else if (this.level == 3)
				in = new Scanner(new File("scores3.txt"));
			else 
				in = new Scanner(new File("scores4.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Failed to open scores.txt");
			System.exit(1);
//=======
//			fw = new FileWriter("scores.txt", true);
//			bw = new BufferedWriter(fw);
//			for(int i = 0; i < 4; i++)
//			{
//				bw.write("" + a[i] + "\n");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//>>>>>>> branch 'master' of https://github.com/UTSA-CS-3443/Project-Encrypt.git
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
	 * @param scoreNum
	 * @return
	 */
	public int getScore(int scoreNum) {
		if (this.topScores.size() < scoreNum)
			return 0;
		return this.topScores.get(scoreNum);
	}
	
	/**
	 * Loads the high score view
	 * @param score
	 * @return
	 */
//	public void LoadScore(Stage primaryStage, int[] a ) {
	public void LoadScore(Stage primaryStage, int level ) {
		//this.readScores(a);
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
	 * Generates 4 Random scores to populate high score view 
	 */
	public void randomScore(int a[])
	{
		Random rand = new Random();
		for(int i = 0; i < 4; i++)
		{
			a[i] = rand.nextInt(75) + 20;
		}
	}
	/**
	 * Sorts array in ascending order
	 * @param a
	 */
	public void rankScore(int[] a)
	{
		Arrays.sort(a);
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
