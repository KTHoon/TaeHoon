package concurrent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Ex02TaskRootController implements Initializable{
	
	@FXML ProgressBar progressBar;
	@FXML Label lblProgress;
	@FXML Label lblResult;
	
	Task<Integer> task;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void handleStart(ActionEvent e) {
		task = new Task<Integer>() {
			@Override
			protected Integer call() throws Exception {
				//1~100까지의 합
				int result=0;
				for(int i=1; i<=100; i++) {
					if(isCancelled()) {
						break;
					}
					result+=i;
					
					//Task 속성(Property):progress,message 속성
					updateProgress(i, 100);
					updateMessage(i+""); //String.valueOf(i)
					
					try {
					Thread.sleep(200);
					}catch(InterruptedException ex) {}
				}
				return result;
			}
			//작업 상태별 콜백함수 정의
			@Override
			protected void succeeded() {
				System.out.println("succeeded 호출");
				lblResult.setText(getValue()+"");
			}
			@Override
			protected void cancelled() {
				System.out.println("cancelled 호출");
				lblResult.setText("취소");
			}
			@Override
			protected void failed() {
				System.out.println("failed 호출");
				lblResult.setText("실패");
			}
		};
		
		//속성 바인딩
		progressBar.progressProperty().bind(task.progressProperty());
		lblProgress.textProperty().bind(task.messageProperty());
		
		//Thread 기동
		Thread thread =new Thread(task);
		thread.setDaemon(true);
		thread.start();
		
		
	}
	public void handleStop(ActionEvent e) {
		task.cancel();
	}
	
}
