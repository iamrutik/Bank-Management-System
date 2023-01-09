package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.BankManagerService;

public class UpdateBankManagerPassword {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Id: ");
		int id=sc.nextInt();
		System.out.println("Enter your Password: ");
		String password=sc.next();
		
		BankManagerService bankManagerService=new BankManagerService();
		bankManagerService.updateBankManagerPassword(id, password);
		

	}

}
