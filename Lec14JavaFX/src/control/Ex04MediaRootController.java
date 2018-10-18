package control;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Ex04MediaRootController implements Initializable{
	
	@FXML MediaView mediaView;
	@FXML Button btnPlay;
	@FXML Button btnPause;
	@FXML Button btnStop;
	
	@FXML Label lblTime;
	@FXML ProgressBar progressBar;
	@FXML ProgressIndicator indicator;
	@FXML Slider sliderVolume;
	
	boolean endOfMedia=false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		File mediaFile= new File("media/StayWithMeMV.m4v");
		String source=mediaFile.toURI().toString();
		
		//System.out.println(source);
		
		Media media = new Media(source);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		//버튼 이벤트 핸들링
		btnPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(endOfMedia) {
					mediaPlayer.stop();
				}
				mediaPlayer.play();
				endOfMedia=false;
			}
		});
		btnPause.setOnAction (event-> mediaPlayer.pause());
		btnStop.setOnAction(event->mediaPlayer.stop());
		
		
		
		//미디어 플레이어 상태에 따른 실행 코드
		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				System.out.println("setOnReady()....");
				
				mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
						//Progress 정보
						double progress=mediaPlayer.getCurrentTime().toSeconds()/mediaPlayer.getTotalDuration().toSeconds();
						progressBar.setProgress(progress); //0.0~1.0 0.0%~100.0%
						indicator.setProgress(progress);
						
						//현재시간/영상 총 시간.
						String strTime=(int)mediaPlayer.getCurrentTime().toSeconds()+"/"
						              +(int)mediaPlayer.getTotalDuration().toSeconds()+"sec";
						lblTime.setText(strTime);
					}
				});
				
				btnPlay.setDisable(false); //true: 비활성화  / false: 활성화.
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			}
		});
		
		mediaPlayer.setOnPlaying(()-> {
				System.out.println("setOnPlaying()....");
				btnPlay.setDisable(true); //true: 비활성화  / false: 활성화.
				btnPause.setDisable(false);
				btnStop.setDisable(false);
		});
		mediaPlayer.setOnPaused(()-> {
				System.out.println("setOnPaused()....");
				btnPlay.setDisable(false); //true: 비활성화  / false: 활성화.
				btnPause.setDisable(true);
				btnStop.setDisable(false);
		});
		mediaPlayer.setOnStopped(()-> {
				System.out.println("setOnStopped()....");
				btnPlay.setDisable(false); //true: 비활성화  / false: 활성화.
				btnPause.setDisable(true);
				btnStop.setDisable(true);
		});
		mediaPlayer.setOnEndOfMedia(()-> {
				System.out.println("setOnEndOfMedia()....");
				btnPlay.setDisable(false); //true: 비활성화  / false: 활성화.
				btnPause.setDisable(true);
				btnStop.setDisable(false);
				
				progressBar.setProgress(1.0);
				indicator.setProgress(1.0);
				
				endOfMedia=true;
		});
		
		//볼륨 조절.
		//sliderVolume.setValue(30);min//0~100 max
		sliderVolume.setMin(0.0);
		sliderVolume.setMax(1.0);
		sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				//mediaPlayer.setVolume(newValue.doubleValue()/100);
				mediaPlayer.setVolume(newValue.doubleValue());
			}
		});
	}
}
