package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.BankManager;
import com.jsp.bank.service.BankManagerService;

public class UpdateBankManagerName {
public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter your Id: ");
	int id=sc.nextInt();
	System.out.println("Enter your Name: ");
	String name=sc.next();
	
	BankManagerService bankManagerService=new BankManagerService();
	bankManagerService.updateBankManagerName(id, name);
	
}
}