package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.AdminService;

public class ApprovedAllBankManager {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Admin id: ");
		int id=sc.nextInt();
		AdminService adminService=new AdminService();
		adminService.approvedAllManager(id);

	}

}
