package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.CustomerService;

public class GetCustomerById {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Id: ");
		int id=sc.nextInt();
		
		CustomerService customerService=new CustomerService();
		customerService.getCustomersById(id);

	}

}
