package com.jsp.bank.controller;

import java.util.Scanner;

import com.jsp.bank.dto.Admin;
import com.jsp.bank.service.AdminService;

public class UpdateAdminName {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id: ");
		int id=sc.nextInt();
		System.out.println("Enter your new Name: ");
		String name=sc.next();
		
		AdminService adminService= new AdminService();
		adminService.updateAdminNameById(id, name);
		
		}
}
