package Basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex02AppMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox(); //루트 컨테이너
		root.setPrefWidth(350); //폭
		root.setPrefHeight(150); //높이
		root.setAlignment(Pos.CENTER);//정렬
		root.setSpacing(10);//컨트롤간의 간격
		//UI 컨트롤
	   Label label = new Label();	//label객체 생성.
	   label.setText("JavaFX Apllication");
	   label.setFont(new Font(20));
	   Button button = new Button();//button객체 생성.
	   button.setText("확인");
	   button.setOnAction(event->Platform.exit());
	   
	   //UI 컨트롤 컨테이너에 추가
	   root.getChildren().add(label);
	   root.getChildren().add(button);
	   
		Scene scene = new Scene(root); //Scene에 루트 컨테이너 설정
		
		primaryStage.setScene(scene);//스테이지에 scene 설정
		primaryStage.setTitle("Ex02AppMain");//제목
		primaryStage.show();//화면 띄우기.
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
