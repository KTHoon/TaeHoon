package event;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex01Event extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HBox root = new HBox();
		root.setPrefSize(300,200);
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		//이벤트 핸들링.
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("버튼1번 클릭");
				//System.exit(0);
			}
		});
		//람다식으로 변경.
		/*btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼2번 클릭");
			}
		});*/
		btn2.setOnAction((event)-> System.out.println("버튼2번 클릭"));
		
		//btn2.setOnAction(event->Platform.exit());
		
		root.getChildren().addAll(btn1,btn2);//root.getChildren().add(btn2);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex01Event");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
