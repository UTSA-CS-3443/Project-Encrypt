package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Simple driver class that runs the test version of the Encryption Game.
 * @author Connor Guerra
 *
 */
public class EncryptDriver extends Application{
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encryption");
			primaryStage.getIcons().add(new Image("/view/icon-512@x.png"));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
		
	}
	public static void main(String[] args){
		launch(args);
		EncryptGame game = new EncryptGame("Testificate");
		game.runGame();
	}
	public static Stage getStage()
	{
		return stage;
	}

}