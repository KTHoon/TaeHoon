package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.model.Camera;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ex03ViewRootController implements Initializable{
	
	@FXML ListView<String> listView;
	
	@FXML TableView<Camera> tableView;
	@FXML TableColumn<Camera,String> tcMaker;
	@FXML TableColumn<Camera,String> tcImage;
	@FXML TableColumn<Camera,Integer> tcPrice;
	
	@FXML ImageView imageView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//UI컨트롤 초기화 / 이벤트 핸들링 / 속성감시 및 바인딩.
		ArrayList<String> itemList = new ArrayList<>();
		itemList.add("Canon");
		itemList.add("Nikon");
		itemList.add("Sony");
		listView.getItems().addAll(itemList);
		//다중 선택모드
		//listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//실행 시 기본적으로 선택되어있음.
		//listView.getSelectionModel().select(0);
		
		ObservableList<Camera> tableItems=FXCollections.observableArrayList(
				new Camera("캐논", "Canon.png", 130000),
				new Camera("니콘", "Nikon.png", 140000),
				new Camera("소니", "Sony.png", 120000),
				new Camera("필름", "Film.png", 220000),
				new Camera("폴로", "Polo.png", 320000)
				);
		tableView.setItems(tableItems);
		//테이블 컬럼 cellValue 설정
		tcMaker.setCellValueFactory(new PropertyValueFactory<>("maker"));
		tcImage.setCellValueFactory(new PropertyValueFactory<>("image"));
		tcPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		
		//속성 감시
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				//리스트 테이블 클릭시 테이블 뷰의 같은 라인이 선택됨.
				tableView.getSelectionModel().select(newValue.intValue());
				//스크롤 이동
				tableView.scrollTo(newValue.intValue());
			}
		});
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Camera>() {
			@Override
			public void changed(ObservableValue<? extends Camera> observable, Camera oldValue, Camera newValue) {
				if(newValue !=null) {
					//
					Image img=new Image(getClass().getResource("/res/images/"+newValue.getImage()).toString());
					imageView.setImage(img);
				}
			}
		});
	}
	public void handleOk(ActionEvent e) {
		String listItem = listView.getSelectionModel().getSelectedItem();
		System.out.println("선택됨 아이템 : " + listItem);
		
		Camera camera=tableView.getSelectionModel().getSelectedItem();
		if(camera!=null) {
		System.out.println("제조사 : "+camera.getMaker()+"\n" + "가격 : "+ camera.getPrice());
		}
	}
}
