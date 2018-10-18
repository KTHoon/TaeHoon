package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Ex02InputRootController implements Initializable{
	
	@FXML TextField txtTitle;
	@FXML PasswordField txtPassword;
	@FXML ComboBox<String> cmbOpenYn;
	@FXML DatePicker dateFinish;
	@FXML TextArea txtContent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//ObservableList() :Factory메서드
		ObservableList<String> items = FXCollections.observableArrayList(
				new String("공개")
				,"비공개",
				String.valueOf("임시 공개"));
		//cmbOpenYn.setItems(items);
		cmbOpenYn.getSelectionModel().select(0);
	}
	public void handleRegist(ActionEvent e) {
		System.out.println("제    목: " +txtTitle.getText());
		System.out.println("비밀번호: " +txtPassword.getText());
		System.out.println("공개여부: " +cmbOpenYn.getValue());
		System.out.println("게시종료: " +dateFinish.getValue());
		System.out.println("내    용: " +txtContent.getText());
	}
	public void handleCancel(ActionEvent e) {
		Platform.exit();
	}
}
