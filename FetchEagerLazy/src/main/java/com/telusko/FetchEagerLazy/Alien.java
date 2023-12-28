package com.telusko.FetchEagerLazy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//POJO
@Entity
public class Alien {

	@Id
	private int aid;
	private String aname;
	
	//eager loading
	@OneToMany(mappedBy = "alien",fetch = FetchType.EAGER)
	private List<Laptop> laptops =new ArrayList<>();
	
	
	
	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}


	
	

}
