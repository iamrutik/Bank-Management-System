package com.jsp.bank.controller;

import com.jsp.bank.service.CustomerService;

public class GetAllBankAccount {

	public static void main(String[] args) {
		
		CustomerService customerService=new CustomerService();
		customerService.getAllBankAccounts();

	}

}
