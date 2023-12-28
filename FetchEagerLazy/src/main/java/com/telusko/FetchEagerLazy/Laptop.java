package com.telusko.FetchEagerLazy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
private int lid;
private String brand;
private String price;
@ManyToOne
private Alien alien;




public Alien getAlien() {
	return alien;
}
public void setAlien(Alien alien) {
	this.alien = alien;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}






}
