package Container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex07StackPane extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root =  FXMLLoader.load(getClass().getResource("Ex07StackPaneRoot.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex07StackPane");
		primaryStage.show();
}
public static void main(String[] args) {
		launch(args);
	}
}
