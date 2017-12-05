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
	
	public HighScoreController()
	{
		super();
		Scanner scan = null;
		int i = 0;
		scores = new Scores();
		highScores = new int[4];
		try {
			scan = new Scanner(new File("scores.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scan.hasNextInt())
		{
			highScores[i] = scan.nextInt();
			i++;
		}
	}
	
	public void initialize()
	{
		score1.setText("" + highScores[3]);
		score2.setText("" + highScores[2]);
		score3.setText("" + highScores[1]);
		score4.setText("" + highScores[0]);
		playerScore.setText("" + playerS);
	}
	
	public void handle(ActionEvent event)
	{
		Button b = (Button)event.getSource();
		System.out.println( b.getText() );
		Stage newStage = (Stage) b.getScene().getWindow();
		
		if (b.getText().equals("Back To Main Menu")) {
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
