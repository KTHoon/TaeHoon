package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex07Dialog extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ex07DialogRoot.fxml"));
		
		Parent root =  loader.load();
		
		Ex07DialogRootController contorller = loader.getController();
		contorller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex07Dialog");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
