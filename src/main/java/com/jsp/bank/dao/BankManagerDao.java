package com.jsp.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.BankManager;
import com.jsp.bank.dto.Customers;

public class BankManagerDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rutik");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	
	public BankManager saveBankManager(BankManager bankManager) {
		
		bankManager.setStatus("unapproved");
		
		entityTransaction.begin();
		entityManager.persist(bankManager);
		entityTransaction.commit();
		
		return bankManager;
	}
	
	//Update BankManager Name
	public BankManager updateBankManagerName(int id, String name) {
	
		BankManager bankManager1=entityManager.find(BankManager.class, id);
		
		if(bankManager1 != null) {
		bankManager1.setName(name);
		
		entityTransaction.begin();
		entityManager.merge(bankManager1);
		entityTransaction.commit();
		
		System.out.println("BankManager Name Updated");
		}
		else {
			System.out.println("BankManager not Found");
		}
		
		return bankManager1;
	}
	
	//Update BankManager Email
	public BankManager updateBankManagerEmail(int id, String email) {
		
		BankManager bankManager1=entityManager.find(BankManager.class, id);
		
		if(bankManager1 != null) {
		bankManager1.setName(email);
		
		entityTransaction.begin();
		entityManager.merge(bankManager1);
		entityTransaction.commit();
		
		System.out.println("BankManager Email Updated");
		}
		else {
			System.out.println("BankManager not Found");
		}
		
		return bankManager1;
	}
	
	//Update BankManager Password
	public BankManager updateBankManagerPassword(int id, String password) {
		
		BankManager bankManager1=entityManager.find(BankManager.class, id);
		
		if(bankManager1 != null) {
		bankManager1.setName(password);
		
		entityTransaction.begin();
		entityManager.merge(bankManager1);
		entityTransaction.commit();
		
		System.out.println("BankManager Password Updated");
		}
		else {
			System.out.println("BankManager not Found");
		}
		
		return bankManager1;
	}
	
	//Delete BankManager
	public BankManager deleteBankManagerById(int id) {
		BankManager bankManager1= entityManager.find(BankManager.class, id);
		
		if(bankManager1 != null) {
		
		entityTransaction.begin();
		entityManager.remove(bankManager1);
		entityTransaction.commit();
		
		System.out.println(bankManager1.getName()+" BankManager Deleted Successfully");
		}
		else {
			System.out.println("BankManager not Found");
		}
		
		return bankManager1;
	}
	
	//Get Particular BankManager Details
	public BankManager getBankManagerById(int id) {
		
		BankManager bankManager1= entityManager.find(BankManager.class, id);
		
		if(bankManager1!= null) {
			System.out.println(bankManager1.getId());
			System.out.println(bankManager1.getName());
			System.out.println(bankManager1.getEmail());
			System.out.println(bankManager1.getPassword());
			System.out.println(bankManager1.getStatus());
		}
		else {
			System.out.println("No Object BankManager Found");
		}
		return bankManager1;
	}
	
	//Get all BankManager Details
	public List<BankManager> getAllBankManager() {
		
		String sql= "Select b From  BankManager b";
		Query query= entityManager.createQuery(sql);
		
		List<BankManager> bankManagers= query.getResultList();
		
		for(BankManager b: bankManagers) {
			System.out.println(b.getId());
			System.out.println(b.getName());
			System.out.println(b.getEmail());
			System.out.println(b.getPassword());
			System.out.println(b.getStatus());
		}
		return bankManagers;
	}
	
	//delete customers by own manager
	public Customers deleteCustomersById(int bankmanagerId, int CustomerId) {
		BankManager bankManager= entityManager.find(BankManager.class, bankmanagerId);
		
		Customers customers= entityManager.find(Customers.class, CustomerId);
		if(bankManager != null) {
			if(customers != null) {
				if(customers.getBankManager().getId()==bankmanagerId) {
					entityTransaction.begin();
					entityManager.remove(customers);
					entityTransaction.commit();
					System.out.println(customers.getName()+" deleted Successfully");
				}else {
					System.out.println(customers.getName()+" is not your Customer");
				}
			}else {
				System.out.println("Customer not found");
			}
		}else{
			System.out.println("invalid Manager Credential");
		}
	return customers;
	}
	
	//approve customers
	public List<Customers> approvedAllCustomers(int id){
		BankManager bankmanager= entityManager.find(BankManager.class, id);
		List<Customers> customers= null;
		if(bankmanager != null) {
			if(bankmanager.getStatus().equals("Approved")) {
				String sql= "select c from Customers c";
				Query query = entityManager.createQuery(sql);
				
				customers= query.getResultList();
				for(Customers c :customers) {
					if(c.getStatus().equals("Unapproved")) {
						c.setStatus("Approved");
						c.setBankManager(bankmanager);
						entityTransaction.begin();
						entityManager.merge(c);
						entityTransaction.commit();
						System.out.println(c.getName()+" is approved");
					}
				}
			}else {
				System.out.println("You are not approved manager");
			}
		}else {
			System.out.println("Manager"+ id+ "does not exist");
		}
		return customers;
	}
	
	//approve particular customer
	public Customers approvedCustomer(int customerId, int bankManagerId) {
		Customers customers= entityManager.find(Customers.class, customerId);
		BankManager bankManager=entityManager.find(BankManager.class, bankManagerId);
		if(bankManager.getStatus().equals("Approved")) {
			if(customers.getStatus().equals("Unapproved")) {
				customers.setStatus("Approved");
				customers.setBankManager(bankManager);
				entityTransaction.begin();
				entityManager.merge(customers);
				entityTransaction.commit();
				System.out.println("Approved Successfully");
			}else {
				System.out.println("Customer already approved");
			}
		}else {
			System.out.println("BankManager is not Approved");
		}
		return customers;
	}
	
	}
