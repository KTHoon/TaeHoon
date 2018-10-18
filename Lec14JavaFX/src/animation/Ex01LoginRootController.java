package animation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Ex01LoginRootController implements Initializable {
	
	@FXML Button btnMain;
	@FXML BorderPane login;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void handleMain(ActionEvent event) {
		StackPane root =(StackPane)btnMain.getScene().getRoot();
		//
		
		//애니메이션 효과
		KeyValue keyValue = new KeyValue(login.translateXProperty(),root.getPrefWidth());
		KeyFrame keyFrame = new KeyFrame(Duration.millis(2000),
												new EventHandler<ActionEvent>() {
												public void handle(ActionEvent event) {
													root.getChildren().remove(login);}
												},keyValue);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		
	}
}
