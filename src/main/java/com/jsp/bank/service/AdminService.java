package com.jsp.bank.service;

import java.util.List;

import com.jsp.bank.dao.AdminDao;
import com.jsp.bank.dto.Admin;
import com.jsp.bank.dto.BankManager;

public class AdminService {

	public Admin saveAdmin(Admin admin) {
		AdminDao adminDao=new AdminDao();
		return adminDao.saveAdmin(admin);
	}
	
	public Admin updateAdminNameById(int id, String name) {
		AdminDao adminDao=new AdminDao();
		return adminDao.updateAdminNameById(id, name);
	}
	
	public Admin deleteAdminById(int id) {
		AdminDao adminDao=new AdminDao();
		return adminDao.deleteAdminById(id);
	}
	
	public Admin updateAdminEmailById(int id, String email) {
		AdminDao adminDao=new AdminDao();
		return adminDao.updateAdminEmailById(id, email);
	}
	
	public Admin updateAdminPasswordById(int id, String password) {
		AdminDao adminDao=new AdminDao();
		return adminDao.updateAdminPasswordById(id, password);
	}
	
	public Admin getAdminById(int id) {
		AdminDao adminDao =new AdminDao();
		return adminDao.getAdminById(id);
	}
	
	public List<Admin> getAllAdmin() {
		AdminDao adminDao= new AdminDao();
		return adminDao.getAllAdmin();
	}
	
	public List<BankManager> approvedAllManager(int id){
		AdminDao adminDao=new AdminDao();
		return adminDao.approveAllBankManager(id);
	}
	
	public BankManager approvedBankManager(int bankManagerId, int adminId) {
		AdminDao adminDao=new AdminDao();
		return adminDao.approvedBankManager(bankManagerId, adminId);
		
	}
}
