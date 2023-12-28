	package com.telusko.MappingRelationsInHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	
	//fields 
	@Id
	private int rollNo;
	private String name;
	private String marks;
	@OneToMany(mappedBy = "student")
	private List<Laptop> laptopList=new ArrayList<>();
	
	
	
	
	//getters and setters
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public List<Laptop> getLaptopList() {
		return laptopList;
	}
	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}
	

	

}
