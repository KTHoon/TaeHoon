package Basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex04FXMLLayout extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HBox root = FXMLLoader.load(getClass().getResource("Ex04FXMLLayoutRoot.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex04FXMLLayout");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
