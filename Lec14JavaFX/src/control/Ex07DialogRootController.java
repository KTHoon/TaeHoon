package control;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ex07DialogRootController implements Initializable {
	
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	public void handleOpenFileChooser(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		
		//확장자 필터
		fileChooser.getExtensionFilters().addAll(
				     new ExtensionFilter("Text File","*.txt"),
				     new ExtensionFilter("Java File","*.java"),
				     new ExtensionFilter("Class File","*.class"),
				     new ExtensionFilter("XML File","*.fxml","*.xml"),
				     new ExtensionFilter("Image File","*.jpg","*.jpeg","*.bmp","*.gif","*.png"),
				     new ExtensionFilter("All File","*.*"));
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		if(selectedFile!=null) {
			System.out.println("선택된 파일: "+ selectedFile.getPath());
		}
	}

	public void handleSaveFileChooser(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		File saveFile = fileChooser.showSaveDialog(primaryStage);
		
		if(saveFile != null) {
			System.out.println("저장 할 파일: "+ saveFile.getPath());
		}
	}

	public void handleDirectoryChooser(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		File directory=directoryChooser.showDialog(primaryStage);
		if(directory !=null) {
			System.out.println("디렉토리 : "+directory.getPath());
		}
	}

	public void handlePopupChooser(ActionEvent event) throws IOException {
		Popup popup = new Popup();
		HBox hbox=FXMLLoader.load(getClass().getResource("Ex07Popup.fxml"));
		
		ImageView imageView = (ImageView)hbox.lookup("#imageView");
		Label lblMessage = (Label)hbox.lookup("#lblMessage");
		
		String url=getClass().getResource("/res/images/info.png").toString();
		imageView.setImage(new Image(url));
		
		lblMessage.setText("1개의 신규 메시지가 도착했습니다.");
		
		popup.getContent().add(hbox);
		popup.setAutoHide(true);
		popup.show(primaryStage);
		
	}

	public void handleCustomChooser(ActionEvent event) throws IOException {
		Stage dialog=new Stage(StageStyle.UTILITY);
		
		//메인 윈도우 설정
		dialog.initOwner(primaryStage);
		//모달 셋팅
		dialog.initModality(Modality.WINDOW_MODAL);
		
		Parent root = FXMLLoader.load(getClass().getResource("Ex07Login.fxml")); 
		
		TextField txtId= (TextField)root.lookup("#txtId");
		PasswordField txtPwd=(PasswordField)root.lookup("#txtPwd");
		Button btnLogin=(Button)root.lookup("#btnLogin");
		
		//이벤트 핸들링
		btnLogin.setOnAction(e->{
			String id= txtId.getText();
			String pwd=txtPwd.getText();
			System.out.printf("ID : %s,PWD : %s",id,pwd);
			dialog.hide();//dialog.close()
		});
		
		Scene scene= new Scene(root);
		
		dialog.setScene(scene);
		dialog.setTitle("로그인 화면");
		dialog.show();
	}

}
