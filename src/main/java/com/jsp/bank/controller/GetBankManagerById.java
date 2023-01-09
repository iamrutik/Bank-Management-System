package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.BankManager;
import com.jsp.bank.service.BankManagerService;

public class GetBankManagerById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id: ");
		int id=sc.nextInt();
		
		BankManagerService bankManagerService=new BankManagerService();
		BankManager bankManager2= bankManagerService.getBankManagerById(id);

	}

}
