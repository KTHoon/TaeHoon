package Container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex01AnchorPane extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Ex01AnchorPaneRoot.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex01AnchorPane");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
