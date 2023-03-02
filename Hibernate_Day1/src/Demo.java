import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.*;

import entity.Customer;

public class Demo {
	
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		int srno;
		String fname,lname,address;
		
		Scanner obj = new Scanner(System.in);
		
		System.out.println("**********Customer Records**********");
		
		System.out.print("Enter Serial No : ");
		
		srno=Integer.parseInt(obj.nextLine());
		
//		System.out.print("\nEnter First Name : ");
//
//		fname=obj.nextLine();
//		
//		System.out.print("\nEnter Last Name : ");
//		
//		lname=obj.nextLine();
//		
//		System.out.print("\nEnter Address : ");
//		
//		address=obj.nextLine();
		
//        Customer cus = new Customer(srno);
		
//		Customer cus = new Customer(srno, fname, lname, address);
		
		Customer cus = session.get(Customer.class,srno);
		
		System.out.println(cus.getFname());
		System.out.println(cus.getLname());
		System.out.println(cus.getAddress());

//		session.save(cus);
//		session.update(cus);
//		session.delete(cus);
		tx.commit();
		session.close();
		
		System.out.println("Inserted Succesfully");
	}

}
