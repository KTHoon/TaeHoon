package event;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Ex02EventRootController implements Initializable{
	
	@FXML Button btn1; //객체 주입,(Dependency Injection :DI,의존성 주입)
	@FXML Button btn2;
	//@FXML Button btn3;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//UI컨트롤 초기화,이벤트 핸들러 등록, 속성 감시 및 바인딩 등록.
		
		//이벤트 핸들러 등록.
		//전통적인 방법
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼1번 클릭.");
			}
		});
		
		//람다식
		btn2.setOnAction((event) -> handleBtn2Action(event));
		/*btn1.setOnAction((event)-> System.out.println("버튼1번 클릭."));
		btn2.setOnAction((event)-> System.out.println("버튼2번 클릭."));
		btn3.setOnAction((event)-> System.out.println("버튼3번 클릭."));*/
	}
	public void handleBtn2Action(ActionEvent event) {
		System.out.println("버튼2번 클릭.\t **메소드를 통한 이벤트 호출**");
	}
	//FXML파일에 직접 연결.
	public void handleBtn3Action(ActionEvent event) {
		System.out.println("버튼3번 클릭.\t **메소드를 통한 이벤트 호출**");
	}
}
