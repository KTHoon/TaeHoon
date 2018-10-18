package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ex01ButtonRootController implements Initializable{
	
	@FXML CheckBox chBtn1; 
	@FXML CheckBox chBtn2; 
	@FXML CheckBox chBtn3;
	@FXML VBox chBox;
	
	ImageView imgCanon;
	ImageView imgNikon;
	ImageView imgSony;
	
	@FXML RadioButton rdoCanon;
	@FXML RadioButton rdoNikon;
	@FXML RadioButton rdoSony;
	@FXML ImageView rdoImageView;
	ToggleGroup rdoGroup;
	
	@FXML Rectangle rectangle;
	@FXML ToggleGroup togGroup;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//UI 컨트롤 초기화
		//System.out.println(getClass().getResource("/res/images/Canon.png").toString());
		imgCanon = new ImageView(getClass().getResource("/res/images/Canon.png").toString());
		imgCanon.setFitHeight(40);
		imgCanon.setFitWidth(100);
		imgNikon = new ImageView(getClass().getResource("/res/images/Nikon.png").toString());
		imgNikon.setFitHeight(40);
		imgNikon.setFitWidth(100);
		imgSony = new ImageView(getClass().getResource("/res/images/Sony.png").toString());
		imgSony.setFitHeight(40);
		imgSony.setFitWidth(100);
		
		//라이도 버튼 그룹핑.
		rdoGroup= new ToggleGroup();
		rdoCanon.setToggleGroup(rdoGroup);
		rdoNikon.setToggleGroup(rdoGroup);
		rdoSony.setToggleGroup(rdoGroup);
		
		//속성 감시.
		rdoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(javafx.beans.value.ObservableValue
					<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				String userData=newValue.getUserData().toString();
				System.out.println("선택된 토글 : " + userData);
					
				rdoImageView.setImage(new Image(getClass().getResource("/res/images/"+userData).toString()));
		
				/*String imageUrl =getClass().getResource("/res/images/"+userData).toString();
				rdoImageView.setImage(new Image(imageUrl));*/
			};
			
		});
		togGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle > observable, Toggle oldValue, Toggle newValue) {
				Color color = (Color)newValue.getUserData();
				rectangle.setFill(color);
			}; 
		});
	}
	public void handleCheckAction(ActionEvent event) {
		
		/*if(chBtn1.isSelected()){ //체크박스 선택 여부
			System.out.println("체크 박스 : " + chBtn1.getText());
		}*/
		CheckBox chBtn = (CheckBox)event.getSource();
		
		String userData = chBtn.getUserData().toString();
		if(chBtn.isSelected()) {
			System.out.println("체크 박스 : " + chBtn.getUserData());
			if("Canon".equals(userData)){
				chBox.getChildren().add(imgCanon);
			}else if("Nikon".equals(userData)){
				chBox.getChildren().add(imgNikon);
			}
			else if("Sony".equals(userData)){
				chBox.getChildren().add(imgSony);
			}
		}else {
			if("Canon".equals(userData)){
				chBox.getChildren().remove(imgCanon);
			}else if("Nikon".equals(userData)){
				chBox.getChildren().remove(imgNikon);
			}
			else if("Sony".equals(userData)){
				chBox.getChildren().remove(imgSony);
			}
		}
	}
	
}
