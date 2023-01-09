package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.Admin;
import com.jsp.bank.service.AdminService;

public class SaveAdmin {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name: ");
		String name=sc.next();
		System.out.println("Enter your Email: ");
		String email=sc.next();
		System.out.println("Enter your password: ");
		String password=sc.next();

		Admin admin=new Admin();
		admin.setName(name);
		admin.setEmail(email);
		admin.setPassword(password);
		
		AdminService adminService=new AdminService();
		Admin admin2=adminService.saveAdmin(admin);
		if(admin2 != null) {
			System.out.println("Admin Inserted");
			
		}else {
			System.out.println("Not Inserted");
		}
		

	}

}
