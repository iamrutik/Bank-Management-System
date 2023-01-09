package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.BankManagerService;

public class ApproveAllCustomers {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter your Manager id: ");
	int id=sc.nextInt();
	BankManagerService bankManagerService=new BankManagerService();
	bankManagerService.approvedAllCustomers(id);
}
}
