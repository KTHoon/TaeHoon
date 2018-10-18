package bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Ex03BindingsRootController implements Initializable{
	
	@FXML Circle circle;
	@FXML AnchorPane root;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//UI 컨트롤 초기화, 이벤트 핸들링, 속성 감시 및 바인딩.
		
		circle.centerXProperty().bind(Bindings.divide(root.widthProperty(),2));
		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
	}
}
