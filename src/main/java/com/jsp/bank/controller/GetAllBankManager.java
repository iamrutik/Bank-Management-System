package com.jsp.bank.controller;

import java.util.List;

import com.jsp.bank.dto.BankManager;
import com.jsp.bank.service.BankManagerService;

public class GetAllBankManager {

	public static void main(String[] args) {
		BankManagerService bankManagerService=new BankManagerService();
		
		List<BankManager> bankManager2= bankManagerService.getAllBankManager();

	}

}
