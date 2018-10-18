package event;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex02Event extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root =  FXMLLoader.load(getClass().getResource("Ex02EventRoot.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex02Event");
		primaryStage.show();
}
public static void main(String[] args) {
		launch(args);
	}
}
