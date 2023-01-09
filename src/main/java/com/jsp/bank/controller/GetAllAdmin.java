package com.jsp.bank.controller;

import java.util.List;

import com.jsp.bank.dto.Admin;
import com.jsp.bank.service.AdminService;

public class GetAllAdmin {

	public static void main(String[] args) {
		AdminService adminService=new AdminService();
		
		List<Admin> admin2=adminService.getAllAdmin();
		
		
	}

}
