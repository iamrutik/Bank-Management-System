package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.CustomerService;

public class GetBankAccountDetailsOfCustomer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Customer id: ");
		int customerId=sc.nextInt();
		
		CustomerService customerService=new CustomerService();
		customerService.getBankAccount(customerId);
				
				
	}

}
