package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int uid;
	@Column(name="Username")
	private String uname;
	private int age;
	private int salary;
	private String desig;
	Employee()
	{
		// step 
	}
	public Employee(int uid, String uname, int age, int salary, String desig) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.age = age;
		this.salary = salary;
		this.desig = desig;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	@Override
	public String toString() {
		return "Employee [uid=" + uid + ", uname=" + uname + ", age=" + age + ", salary=" + salary + ", desig=" + desig
				+ "]";
	}    
}
