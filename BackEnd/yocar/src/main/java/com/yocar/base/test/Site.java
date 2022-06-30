package com.yocar.base.test;

public class Site {
private int siteId;
private int carLimit;
public Site(int siteId, int carLimit) {
	super();
	this.siteId = siteId;
	this.carLimit = carLimit;
}

public String addCar(Car car) {
	Car addCar=new Car(car.getCarId(), car.getCarName(), car.getType());
	return new String("Car added");
	
}
public static void main(String[] args) {
  Car car=new Car(1001,"mycar","mytype");
  Site site=new Site(12,30);
  site.addCar(car);
}
}
