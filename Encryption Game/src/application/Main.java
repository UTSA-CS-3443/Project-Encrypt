package application;
	
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		// Clear existing contents of scores.txt before starting application
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("scores.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
		try {
			writer = new PrintWriter("scores1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
		try {
			writer = new PrintWriter("scores2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
		try {
			writer = new PrintWriter("scores3.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
		try {
			writer = new PrintWriter("scores4.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encrypt: Main Menu");
			primaryStage.getIcons().add(new Image("/view/icon-512@x.png"));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
}
