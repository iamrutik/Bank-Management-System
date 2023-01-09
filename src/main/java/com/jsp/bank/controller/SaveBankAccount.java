package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.BankAccount;
import com.jsp.bank.service.CustomerService;

public class SaveBankAccount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Customer id: ");
		int id=sc.nextInt();
		
		System.out.println("Enter your Initial balance: ");
		double amount=sc.nextDouble();
		
		if(amount>999) {
			BankAccount bankAccount=new BankAccount();
			bankAccount.setBalance(amount);
			
			CustomerService customerService=new CustomerService();
			customerService.saveBankAccount(bankAccount, id);
		}else { 
			System.out.println("Opening Balance must be minimum 1000");
		}

	}

}
