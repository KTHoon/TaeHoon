package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Ex06MenuToolBarRootController implements Initializable{
	
	@FXML TextArea textArea;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void hadleNew(ActionEvent event) {
		textArea.appendText("New\n");
	}

	public void hadleOpen(ActionEvent event) {
		textArea.appendText("Open\n");
	}

	public void hadleSave(ActionEvent event) {
		textArea.appendText("Save\n");
	}

	public void hadleClose(ActionEvent event) {
		Platform.exit();
	}
}
