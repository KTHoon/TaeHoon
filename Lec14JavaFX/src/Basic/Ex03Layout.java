package Basic;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Ex03Layout extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPadding(new Insets(10,10,10,10));
		root.setSpacing(10);
		
		TextField textField = new TextField();
		textField.setPrefWidth(300);
		
		Button button = new Button();
		button.setText("확인");
		
		ObservableList<Node> children =root.getChildren();
		children.add(textField);
		children.add(button);
		
		Scene scene=new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex03Layout");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
