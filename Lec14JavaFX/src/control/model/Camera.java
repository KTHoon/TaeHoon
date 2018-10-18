package control.model;

import javafx.beans.property.*;

public class Camera {
	private StringProperty maker;
	private StringProperty image;
	private IntegerProperty price;
	
	public Camera() {
		this.maker=new SimpleStringProperty();
		this.image=new SimpleStringProperty();
		this.price=new SimpleIntegerProperty();
	}
	
	public Camera(String maker,String image,int price) {
		this.maker=new SimpleStringProperty(maker);
		this.image=new SimpleStringProperty(image);
		this.price=new SimpleIntegerProperty(price);
	}

	public String getMaker() {
		return maker.get();
	}

	public void setMaker(String maker) {
		this.maker.set(maker);;
	}

	public StringProperty makerProperty() {
		return maker;
	}

	public final StringProperty imageProperty() {
		return this.image;
	}
	

	public final String getImage() {
		return this.imageProperty().get();
	}
	

	public final void setImage(final String image) {
		this.imageProperty().set(image);
	}
	

	public final IntegerProperty priceProperty() {
		return this.price;
	}
	

	public final int getPrice() {
		return this.priceProperty().get();
	}
	

	public final void setPrice(final int price) {
		this.priceProperty().set(price);
	}

}
