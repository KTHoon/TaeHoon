package Basic;

import javafx.application.Application;
import javafx.stage.Stage;

public class Ex01AppMain extends Application{
	public Ex01AppMain() {
		System.out.println(Thread.currentThread().getName()
				              +" : 생성자 실행.");
	}
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName()
	              +" : init() 실행.");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName()
	              +" : start() 실행.");
		primaryStage.setTitle("JavaFX Application");//제목
		primaryStage.show();//화면 띄우기.
	}
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName()
	              +" : stop 실행.");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()
	              +" : 메인 실행.");
		launch(args);
		
	}
}
