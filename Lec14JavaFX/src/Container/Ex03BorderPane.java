package Container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex03BorderPane extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root =  FXMLLoader.load(getClass().getResource("Ex03BorderPaneRoot.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex03BorderPane");
		primaryStage.show();
}
public static void main(String[] args) {
		launch(args);
	}
}
