package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.BankAccount;
import com.jsp.bank.service.CustomerService;

public class DepositeMoney {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Customer id: ");
		int CustomerId=sc.nextInt();
		System.out.println("Enter your Bank id: ");
		int bankId= sc.nextInt();
		System.out.println("Enter your amount to deposit:");
        double amount=sc.nextDouble();
        
        if(amount>0){
        	CustomerService customerService=new CustomerService();
        	BankAccount bankAccount=customerService.depositAmount(CustomerId, bankId, amount);
        	
        	if(bankAccount!= null) {
        		System.out.println("Transaction successfull");
        	}else {
        		System.out.println("Transaction failed");
        	}	
        }else {
        	System.out.println("Invalid Amount");
        }
        
        	
        
				

	}

}
