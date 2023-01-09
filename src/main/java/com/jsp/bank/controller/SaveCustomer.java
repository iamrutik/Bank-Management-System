package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.Customers;
import com.jsp.bank.service.CustomerService;

public class SaveCustomer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name: ");
		String name=sc.next();
		System.out.println("Enter your Gender: ");
		String gender=sc.next();
		System.out.println("Enter your Date of Birth: ");
		String dob=sc.next();
		System.out.println("Enter your Adhar card no. ");
		long adharno=sc.nextLong();
		System.out.println("Default Customer status is unapproved");
	     
		Customers customers=new Customers();
		customers.setName(name);
		customers.setGender(gender);
		customers.setDob(dob);
		customers.setAdharno(adharno);
		
		CustomerService customerService=new CustomerService();
		customerService.saveCustomers(customers);
	}

}
