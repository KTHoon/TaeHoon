package animation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Ex01AnimationRootController implements Initializable {
	
	@FXML Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void handleLogin(ActionEvent event) throws IOException {
		//화면 전환
		//UI 컨트롤로 부터 Scene이나 루트 컨테이너를 가져오기.
		StackPane root = (StackPane) btnLogin.getScene().getRoot();
		Parent login =FXMLLoader.load(getClass().getResource("Ex01LoginRoot.fxml"));
		root.getChildren().add(login);
		
		//애니메이션 효과
		login.setOpacity(0);
		KeyValue keyValue = new KeyValue(login.opacityProperty(),1);
		KeyFrame keyFrame= new KeyFrame(Duration.millis(2000),keyValue);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
}
