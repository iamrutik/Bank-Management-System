package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.CustomerService;

public class DebiteAmount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Customer id: ");
		int CustomerId= sc.nextInt();
		System.out.println("Enter your bank id: ");
		int bankId=sc.nextInt();
		System.out.println("Enter your Amount: ");
		double amount =sc.nextDouble();
		
		CustomerService customerService=new CustomerService();
		customerService.debiteAmount(CustomerId, bankId, amount);

	}

}
