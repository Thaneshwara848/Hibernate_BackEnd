package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="MyStudent")
public class Student {
	
	@Id
	private int uid;
	@Column(name="St_Name")
	private String name;
	private String city;
	private int pin;
	public Student()
	{
	}
	public Student(int uid, String name, String city,int pin) {
		super();
		this.uid = uid;
		this.name = name;
		this.city = city;
		this.pin = pin;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return this.uid + " "+this.name + " : "+this.city  + " : "+this.pin;
	}	
}
