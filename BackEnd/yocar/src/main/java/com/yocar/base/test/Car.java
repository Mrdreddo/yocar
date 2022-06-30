package com.yocar.base.test;

public class Car {
  private	int carId;
  private String carName;
  private String type;
public Car(int carId, String carName, String type) {
	super();
	this.carId = carId;
	this.carName = carName;
	this.type = type;
}
public int getCarId() {
	return carId;
}
public void setCarId(int carId) {
	this.carId = carId;
}
public String getCarName() {
	return carName;
}
public void setCarName(String carName) {
	this.carName = carName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
	



}
