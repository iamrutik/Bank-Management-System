package com.jsp.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.Admin;
import com.jsp.bank.dto.BankManager;

public class AdminDao {

	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("rutik");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	public Admin saveAdmin(Admin admin) {
		if(admin != null) {
		
		 entityTransaction.begin();
		 entityManager.persist(admin);
		 entityTransaction.commit();
		 
		 System.out.println("Admin inserted");
		}
		else {
			System.out.println("Not inserted");
		}
		 return admin;
		 }
	 
	//update Admin name
	public Admin updateAdminNameById(int id, String name) {
		Admin admin1	=entityManager.find(Admin.class, id);
		
		if(admin1 !=null) {
		admin1.setName(name);
		
		entityTransaction.begin();
		entityManager.merge(admin1);
		entityTransaction.commit();
		
		System.out.println("Admin name Updated");
		}
		else {
			System.out.println("Admin not found");
		}
		
		return admin1;	
	}
	
	//update Admin email
	public Admin updateAdminEmailById(int id, String email) {
		
		Admin admin1=entityManager.find(Admin.class, id);
		
		if(admin1 !=null) {
			admin1.setEmail(email);
			
			entityTransaction.begin();
			entityManager.merge(admin1);
			entityTransaction.commit();
			
			System.out.println("Admin Email updated");
		}
		else {
			System.out.println("Admin not Found");
		}
		return admin1;
	}
	
	//update admin password
	public Admin updateAdminPasswordById(int id, String password) {
		Admin admin1=entityManager.find(Admin.class, id);
		
		if(admin1 != null) {
			admin1.setPassword(password);
			
			entityTransaction.begin();
			entityManager.merge(admin1);
			entityTransaction.commit();
			
			System.out.println("Admin password updated");
		}
		else {
			System.out.println("Admin not found");
		}
		return admin1;
	}
	
	//delete Admin
	public Admin deleteAdminById(int id) {
		
		Admin admin1= entityManager.find(Admin.class, id);
		
		if(admin1 != null) {
		
		entityTransaction.begin();
		entityManager.remove(admin1);
		entityTransaction.commit();
		
		System.out.println(admin1.getName()+"Deleted Successfully");
		}
		else {
			System.out.println("Admin not found");
		}
		
		return admin1;	
	}
	 
	public Admin getAdminById(int id) {
		
		Admin admin1=entityManager.find(Admin.class, id);
		
		if(admin1!= null) {
			System.out.println(admin1.getId());
			System.out.println(admin1.getName());
			System.out.println(admin1.getEmail());
			System.out.println(admin1.getPassword());
		}
		else {
			System.out.println("No Object Admin Found");
		}
		return admin1;
	}
	
	public List<Admin> getAllAdmin() {
		
		String sql = "Select a FROM Admin a";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();

		for (Admin a : admins) {
			System.out.println("==============");
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getEmail());
			System.out.println(a.getPassword());
		
		}
		return admins;
	}
	
	//Approve all Bank Managers
	public List<BankManager> approveAllBankManager(int id){
		Admin admin=entityManager.find(Admin.class, id);
		List <BankManager> bankManager=null;
		if(admin != null) {
			
			BankManagerDao bankManagerDao =new BankManagerDao();
			bankManager = bankManagerDao.getAllBankManager();
			 for(BankManager bmanager : bankManager) {
				 if(bmanager.getStatus().equals("unapproved")) {
					 bmanager.setStatus("approved");
					 bmanager.setAdmin(admin);
					 System.out.println("manager approved");
					 entityTransaction.begin();
					 entityManager.merge(bmanager);
					 entityTransaction.commit();
				 }
			 }
			
		}else {
			System.out.println("no such Admin id");
		}
		return bankManager;
	}
	
	//approve particular Manager
	public BankManager approvedBankManager(int bankManagerId, int adminId) {
		BankManager bankManager= entityManager.find(BankManager.class, bankManagerId);
		Admin admin=entityManager.find(Admin.class, adminId);
		if(admin!=null) {
			if(bankManager.getStatus().equals("Unapproved")) {
				bankManager.setStatus("Approved");
				bankManager.setAdmin(admin);
				entityTransaction.begin();
				entityManager.merge(bankManager);
				entityTransaction.commit();
				System.out.println("Approved Successfully");
			}else {
				System.out.println("BankManager already approved");
			}
		}
		else {
			System.out.println("Admin not exist");
		}
		return bankManager;
	}
	}
	

