package bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class Ex01PropertyRootController implements Initializable {
	@FXML Label label;  
	@FXML Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//UI컨트롤 초기화,이벤트 핸들러 등록, 속성 감시 및 바인딩 등록.
		
		//속성(Property)감시(Listen)
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {
				
				System.out.println("newValue"+newValue);
				System.out.println("oldValue"+oldValue);
				//폰트 사이즈 변경
				label.setFont(new Font(newValue.doubleValue()));
			}
		});
		
	}
}
