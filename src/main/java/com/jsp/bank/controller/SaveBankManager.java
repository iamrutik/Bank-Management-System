package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.BankManager;
import com.jsp.bank.service.BankManagerService;

public class SaveBankManager {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name: ");
		String name=sc.next();
		System.out.println("Enter your Email: ");
		String email=sc.next();
		System.out.println("Enter your password: ");
		String password=sc.next();
		System.out.println("Default Manager status is unapproved");

		
		BankManager bankManager=new BankManager();
		bankManager.setName(name);
		bankManager.setEmail(email);
		bankManager.setPassword(password);
		
		BankManagerService bankManagerService=new BankManagerService();
		BankManager bankManager2=bankManagerService.saveBankManager(bankManager);
		
		if(bankManager2!= null) {
			System.out.println("BankManager Inserted");
		}
		else {
			System.out.println("Not Inserted");
		}

	}

}
