package com.telusko.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;

//POJO
@Entity
public class Laptop {
	
	//fields
	@Id
	private int lid;
	private String brand;
	private int price;
	
	
	
	//getters and setters
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	
	
	
	
}
