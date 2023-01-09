package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.BankAccount;
import com.jsp.bank.service.CustomerService;

public class TransferMoney {

	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter your Customer id: ");
	    int customerId=sc.nextInt();
	    System.out.println("Enter your Bank id: ");
	    int customerBankId=sc.nextInt();
	    System.out.println("Enter Receiver bank id: ");
	    int receiverBankId= sc.nextInt();
	    System.out.println("Enter transfer amount: ");
	    double transferAmount= sc.nextDouble();
	    
	    if(transferAmount> 0) {
	    	CustomerService customerService =new CustomerService();
	    	BankAccount bankAccount=customerService.transferAmount(customerId, customerBankId, receiverBankId, transferAmount);
	    	
	    	if(bankAccount != null) {
	    		System.out.println("Transaction complete");
	    	}else { 
	    		System.out.println("Transaction failed");
	    	}
	    }else {
	    	System.out.println("Invalid amount");
	    }

	}

}
