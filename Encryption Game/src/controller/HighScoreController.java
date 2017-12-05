package controller;

import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.ScoresController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Scores;

public class HighScoreController implements EventHandler<ActionEvent>{


	private Scores scores;
	private int playerS;
	private int[] highScores;
	private int level;
	@FXML
	private Label playerScore;
	@FXML
	private Label playerName;
	@FXML
	private TextField playerInput;
	@FXML
	private Label score1;
	@FXML
	private Label score2;
	@FXML
	private Label score3;
	@FXML
	private Label score4;
	private String temp;
	
	public HighScoreController()
	{
		super();
		this.scores = new Scores();

		Scanner scan = null;
		int i = 0;
		scores = new Scores();
		highScores = new int[300];
		try {
			scan = new Scanner(new File("scores.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(scan.hasNext("PLAYER"))
		{
			temp = scan.next();
			if(scan.hasNextInt())
			{
				playerS = scan.nextInt();
			}
			System.out.println(temp);
			System.out.println(playerS);
		}
		while(scan.hasNextInt())
		{
			highScores[i] = scan.nextInt();
			i++;
		}
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setupScores(int level) {
		this.scores.setLevel(this.level);
		this.scores.readScores();
		this.scores.getTopScores();
		score1.setText("" + scores.getScore(0));
		score2.setText("" + scores.getScore(1));
		score3.setText("" + scores.getScore(2));
		score4.setText("" + scores.getScore(3));
	}
	
	public void initialize()
	{
//		score1.setText("" + highScores[3]);
//		score2.setText("" + highScores[2]);
//		score3.setText("" + highScores[1]);
//		score4.setText("" + highScores[0]);
//		score1.setText("1: " + scores.getScore(0));
//		score2.setText("2: " + scores.getScore(1));
//		score3.setText("3: " + scores.getScore(2));
//		score4.setText("4: " + scores.getScore(3));
		playerScore.setText("" + playerS);
	}
	
	public void handle(ActionEvent event)
	{
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Back to Main Menu")) {
			this.scores.backToMainMenu(newStage);
		}
		if (b.getText().equals("Back to Scores Menu")) {
			this.scores.backToScoresMenu(newStage);
		}
		if (b.getText().equals("SUBMIT"))
		{
			this.playerName.setText(playerInput.getText());
		}
		
	}
}
