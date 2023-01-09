package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.AdminService;

public class ApprovedBankManager {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Admin id: ");
		int adminid=sc.nextInt();
		
		System.out.println("Enter your BankManager id: ");
		int bankManagerid=sc.nextInt();
		
		AdminService adminService=new AdminService();
		adminService.approvedBankManager(bankManagerid, adminid);

	}

}
