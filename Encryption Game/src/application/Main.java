package application;
	
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
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			primaryStage.setScene(new Scene(root, 480, 640));
			primaryStage.setTitle("Project Encyrpt: Main Menu");
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
