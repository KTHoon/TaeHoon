package concurrent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Ex01RunLaterRootController implements Initializable{
	
	@FXML Label lblTime;
	boolean stop=false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void hadleStart(ActionEvent e) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				stop=false;
				
				while (!stop) {
					String strTime = dateFormat.format(new Date());
					//*****************************
					Platform.runLater(()->{
						//UI 변경
						lblTime.setText(strTime);
					});
					//******************************
					System.out.println(strTime);
					try {
					Thread.sleep(100);
					}catch(InterruptedException e1) {}
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
	}
	public void hadleStop(ActionEvent e) {
		stop=true;
	}
}
