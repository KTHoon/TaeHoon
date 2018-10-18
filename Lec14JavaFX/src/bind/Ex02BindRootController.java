package bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Ex02BindRootController implements Initializable{
	
	@FXML TextArea textArea1;
	@FXML TextArea textArea2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//속성 바인딩.
		//단방향 바인딩. 바인딩 받는쪽은 편집불가.
		//textArea2.textProperty().bind(textArea1.textProperty());
		
		//양방향 바인딩.
		//textArea2.textProperty().bindBidirectional(textArea1.textProperty());
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
	}
}
