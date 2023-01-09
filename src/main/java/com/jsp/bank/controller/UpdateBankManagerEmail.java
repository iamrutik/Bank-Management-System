package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.BankManagerService;

public class UpdateBankManagerEmail {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Id: ");
		int id=sc.nextInt();
		System.out.println("Enter your Email: ");
		String email=sc.next();
		
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.updateBankManagerEmail(id, email);
		

	}

}
