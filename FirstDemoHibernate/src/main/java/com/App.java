package com;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class CRUD
{
	static void addRecord()
	{	
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter ID :");
		int uid=sc.nextInt();
		
		System.out.println("Enter Name :");
		String name=sc.next();
		
		System.out.println("Enter Age  :");
		int age= sc.nextInt();
		
		System.out.println("Enter Salary :");
		int salary=sc.nextInt();
		
		System.out.println("Enter Designation : ");
		String desig=sc.next();
		Employee e= new Employee();
		e.setUid(uid);
		e.setUname(name);
		e.setAge(age);
		e.setSalary(salary);
		e.setDesig(desig);
		session.save(e);
		tx.commit();
		System.out.println("Data inserted Successfully....!");
	}
	static void deleteRecord()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Id : ");
		int uid=sc.nextInt();
		Employee e= new Employee();
		e.setUid(uid);
		session.delete(e);
		tx.commit();
		System.out.println("Data Deleted Succesfully...!");
	}
	static void updateEmp()
	{	
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter ID :");
		int uid=sc.nextInt();
		
		System.out.println("Enter Designation :");
		String desig=sc.next();
		
		Employee e1= new Employee();
		e1.setUid(uid);
		e1.setDesig(desig);
		session.update(e1);
		tx.commit();
	}
	static void readEmp()
	{	
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		List employee =session.createQuery("from Employee").list();
		Iterator i=employee.iterator();
		while(i.hasNext())
		{
			Employee emp=(Employee)i.next();
			System.out.print(emp.getUid()+" : ");
			System.out.print(emp.getUname()+" : ");
			System.out.print(emp.getAge()+" : ");
			System.out.print(emp.getSalary()+" : ");
			System.out.print(emp.getDesig()+" : ");
			
			System.out.println(" ");
		}
		
	}
}
public class App {

	public static void main(String[] args) {
		 int ch;
		do {
			Scanner sc= new Scanner(System.in);
			System.out.println("1 ) Insert ");
			System.out.println("2 ) Delete ");
			System.out.println("3 ) Update ");
			System.out.println("4 ) READ ");
			 System.out.print("Enter Choice ");
			 ch= sc.nextInt();
			 if(ch==1)
			 {
				 CRUD.addRecord(); 
			 }
			 if(ch==2)
			 {
				 CRUD.deleteRecord(); 
			 }
			 if(ch==3)
			 {
				 CRUD.updateEmp();
			 }
			 if(ch==4)
			 {
				 CRUD.readEmp();
			 }
		}while(ch<=4);
		
	}

}