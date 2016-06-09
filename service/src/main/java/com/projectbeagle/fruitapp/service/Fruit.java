package com.projectbeagle.fruitapp.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="fruit")
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fruit_id")
	private int fruitId;
	
	@Column(name="fruit_name")
	private String fruitName;
	
	@Column(name="fruit_description")
	private String fruitDescription;
	

	public int getFruitId() {
		return fruitId;
	}

	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitDescription() {
		return fruitDescription;
	}

	public void setFruitDescription(String fruitDescription) {
		this.fruitDescription = fruitDescription;
	}

	

	@Override
	public String toString() {
		return "Fruit [id=" + fruitId + ", fruitName=" + fruitName
				+ ", fruitDescription=" + fruitDescription + "]";
	}

}

