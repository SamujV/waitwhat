package userInterface;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.util.Scanner;

public class Main extends Application {

	Scanner i = new Scanner(System.in);
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("magikGod.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Magic Square God");			
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}

