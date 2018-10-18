import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FxNotepadRootController implements Initializable{
	
	
	@FXML TextArea txtDocument;
	
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void handleNew(ActionEvent event) {
		primaryStage.setTitle("NoName");
		txtDocument.clear();
	}

	public void handleOpen(ActionEvent event) {
		FileChooser fileChooser= new FileChooser();
		File selectedFile =fileChooser.showOpenDialog(primaryStage);
		if(selectedFile!=null) {
			primaryStage.setTitle(selectedFile.getPath());
			txtDocument.clear();
			
			//Worker Thread
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					BufferedReader reader = null;
					try {
						reader = new BufferedReader(new FileReader(selectedFile));
						while(true) {
							String text=reader.readLine();
							if(text==null) {
								break;
							}
							//UI 변경 및 생성
							Platform.runLater(()->{
								txtDocument.appendText(text+"\n");
							});
							
							try {
								Thread.sleep(200);
							}catch(InterruptedException e) {}
						}
						
					}catch(IOException e) {
						e.printStackTrace();
					}finally {
						try {
							if(reader !=null) reader.close();
						}catch(IOException e) {}
					}
				}
			});
			thread.setDaemon(true);
			thread.start();
		}
	}

	public void handleSave(ActionEvent event) {
		
		FileChooser fileChooser = new FileChooser();
		File selectedFile=fileChooser.showSaveDialog(primaryStage);
		
		if(selectedFile!=null) {
			
			primaryStage.setTitle(selectedFile.getPath());
			
			PrintWriter writer = null;
			try {
				writer=new PrintWriter(new FileWriter(selectedFile));
				writer.print(txtDocument.getText());
				writer.flush();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
					if(writer !=null) writer.close();
			}
		}
	}

	public void handleExit(ActionEvent event) {
		Platform.exit();
	}

	public void handleCut(ActionEvent event) {
		txtDocument.cut();
	}

	public void handleCopy(ActionEvent event) {
		txtDocument.copy();
	}

	public void handlePaste(ActionEvent event) {
		txtDocument.paste();
	}
}
