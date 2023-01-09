package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.service.AdminService;

public class UpdateAdminPassword {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id: ");
		int id=sc.nextInt();
		System.out.println("Enter your new Password: ");
		String password=sc.next();
		
		AdminService adminService= new AdminService();
		adminService.updateAdminPasswordById(id, password);
		
	}

}
