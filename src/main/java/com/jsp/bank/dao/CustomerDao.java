package com.jsp.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bank.dto.BankAccount;
import com.jsp.bank.dto.Customers;
import com.jsp.bank.dto.Statement;

public class CustomerDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rutik");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	//save customers
	public Customers saveCustomers(Customers customers) {
		
		String sql="Select c from Customers c";
		Query query=entityManager.createQuery(sql);
		List<Customers> customer=query.getResultList();
		for(Customers c: customer) {
			if(c.getAdharno()== customers.getAdharno()) {
				System.out.println("Customer already exist");
				return null;
			}
		}
		customers.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		System.out.println("Customers save");
		return customers;
		}
	
	//delete customer
	public Customers deleteCustomer(int id) {
		Customers customers=entityManager.find(Customers.class, id);
		if(customers != null) {
			entityTransaction.begin();
			entityManager.remove(customers);
			entityTransaction.commit();
			System.out.println("Customer removed successfully");
		}else {
			System.out.println("Customer not exist");
		}
		return customers;
	}
	
	//update customer name by id
	public Customers updateCustomerNameById(int id, String name) {
		Customers customers=entityManager.find(Customers.class, id);
		if(customers!= null) {
		customers.setName(name);
		entityTransaction.begin();
		entityManager.merge(customers);
		entityTransaction.commit();
		System.out.println("Customer name updated");
		}else {
			System.out.println("Customer not found");
		}
		return customers;
	}
	
	//update customer dob by id
	public Customers updateCustomerDobById(int id, String dob) {
		Customers customers=entityManager.find(Customers.class, id);
		if(customers!= null) {
		customers.setDob(dob);
		entityTransaction.begin();
		entityManager.merge(customers);
		entityTransaction.commit();
		System.out.println("Customer Date of Birth updated");
		}else {
			System.out.println("Customer not found");
		}
		return customers;
	}
	
	//update customer gender by id
	public Customers updateCustomerGenderById(int id, String gender) {
		Customers customers=entityManager.find(Customers.class, id);
		if(customers!= null) {
		customers.setGender(gender);
		entityTransaction.begin();
		entityManager.merge(customers);
		entityTransaction.commit();
		System.out.println("Customer Gender updated");
		}else {
			System.out.println("Customer not found");
		}
		return customers;
	}
	
	//get customer by id
	public Customers getCustomersById(int id) {
		Customers customers=entityManager.find(Customers.class, id);
		if(customers != null) {
			System.out.println("==========================================================");
			System.out.println(customers.getId()+"/t");
			System.out.println(customers.getName()+"/t");
			System.out.println(customers.getGender()+"/t");
			System.out.println(customers.getDob()+"/t");
			System.out.println(customers.getAdharno()+"/t");
			System.out.println(customers.getStatus()+"/t");
		}else {
			System.out.println("Customer not exist");
		}
		return customers;
	}
	
	//Get all customers
	public List<Customers>getAllCustomers(){
		
		String sql= "Select s from Customers c";
		Query query= entityManager.createQuery(sql);
		List<Customers>c =query.getResultList();
		
		for(Customers customers: c) {
			System.out.println("===========================================================");
			System.out.println(customers.getId());
			System.out.println(customers.getName());
			System.out.println(customers.getGender());
			System.out.println(customers.getAdharno());
			System.out.println(customers.getDob());
			System.out.println(customers.getStatus());
		}
		return c;
	}
	
	//Save bank account
	public BankAccount saveBankAccount(BankAccount bankAccount, int CustomerId) {
		List<BankAccount> b=getAllBankAccounts();
		for(BankAccount bankAccount1: b) {
			if(bankAccount1.getCustomers().getId()==CustomerId) {
				System.out.println("You already have an account");
				return null;
			}
		}
		Customers customers=entityManager.find(Customers.class, CustomerId);
		if(customers != null) {
			if(customers.getStatus().equals("Approved")) {
				bankAccount.setCustomers(customers);
				bankAccount.setName(customers.getName());
				bankAccount.setBank_name("SBI Bank");
				bankAccount.setAccount_no(479567800+customers.getId());
				bankAccount.setIFSC("SBI09729");
				entityTransaction.begin();
				entityManager.persist(bankAccount);
				entityTransaction.commit();
				System.out.println("BankAccount successfully added");
						
			}else {
				System.out.println("You are not approved customer");
			}
		}else {
			System.out.println("Customer not found");
		}
		return bankAccount;
	}
	
	//Delete BankAccount
	public BankAccount deleteBankAccount(int id) {
		BankAccount bankAccount = entityManager.find(BankAccount.class, id);
		if (bankAccount != null) {
			entityTransaction.begin();
			entityManager.remove(bankAccount);
			entityTransaction.commit();
			System.out.println("BankAccount deleted successfully");
		} else {
			System.out.println("BankAccount not exist");
		}
		return bankAccount;
	}
	
	// get particular bankAccount details
		public BankAccount getBankAccount(int id) {
			BankAccount bankAccount = entityManager.find(BankAccount.class, id);
			if (bankAccount != null) {
				System.out.println("=============================================================");
				System.out.print(bankAccount.getId()+"\t");
				System.out.print(bankAccount.getName()+"\t");
				System.out.print(bankAccount.getBank_name()+"\t");
				System.out.print(bankAccount.getAccount_no()+"\t");
				System.out.print(bankAccount.getIFSC()+"\t");
				System.out.print(bankAccount.getBalance()+"\t");
			} else {
				System.out.println("BankAccount not exist");
			}
			return bankAccount;
		}

		// get all bankAccounts details
		public List<BankAccount> getAllBankAccounts() {
			String sql = "Select b from BankAccount b";
			Query query = entityManager.createQuery(sql);
			List<BankAccount> bankAccount = query.getResultList();
			for (BankAccount b : bankAccount) {
				System.out.println("=====================");
				System.out.println(b.getId());
				System.out.println(b.getName());
				System.out.println(b.getBank_name());
				System.out.println(b.getAccount_no());
				System.out.println(b.getIFSC());
				System.out.println(b.getBalance());
			}
			return bankAccount;
		}


		// deposit amount
		public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
			Customers c = entityManager.find(Customers.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (amount > 0) {
					b.setBalance(b.getBalance() + amount);
					statement.setBid(bankAccountId);
					statement.setDetails("Deposited : Rs." + amount + " to your Account no:" + b.getAccount_no());

					entityTransaction.begin();
					entityManager.merge(b);
					entityManager.persist(statement);
					entityTransaction.commit();
					System.out.println("Amount deposited successfully");
				} else {
					System.out.println("Invalid amount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}

		
		Statement statement=new Statement();
		
		// debited amount
		public BankAccount debiteAmount(int customerId, int bankAccountId, double amount) {
			Customers c = entityManager.find(Customers.class, customerId);
			BankAccount b = entityManager.find(BankAccount.class, bankAccountId);
			if (c.getStatus().equals("Approved")) {
				if (b.getCustomers().getId() == customerId) {
					if (amount < b.getBalance() && amount > 0) {
						b.setBalance(b.getBalance() - amount);
						statement.setBid(bankAccountId);
						statement.setDetails("Debited : Rs." + amount + " from your Account no:" + b.getAccount_no());

						entityTransaction.begin();
						entityManager.merge(b);
						entityManager.persist(statement);
						entityTransaction.commit();
						System.out.println("Amount Debited successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b;
		}

		// transfer amount
		public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
			Customers c = entityManager.find(Customers.class, customerId);
			BankAccount b1 = entityManager.find(BankAccount.class, creditorId);
			BankAccount b2 = entityManager.find(BankAccount.class, depositorId);
			if (c.getStatus().equals("Approved")) {
				if (b1.getCustomers().getId() == customerId) {
					if (amount > 0 && b1.getBalance() > amount) {
						b1.setBalance(b1.getBalance() - amount);
						statement.setBid(creditorId);
						statement.setDetails("Credited  : Rs." + amount + " from your Account no:" + b1.getAccount_no());

						b2.setBalance(b2.getBalance() + amount);
						Statement statement1 = new Statement();
						statement1.setBid(depositorId);
						statement1.setDetails("Deposited : Rs." + amount + " by Account no :" + b1.getAccount_no());

						entityTransaction.begin();
						entityManager.merge(b1);
						entityManager.merge(b2);
						entityManager.persist(statement);
						entityManager.persist(statement1);
						entityTransaction.commit();
						System.out.println("Amount transfer successfully");
					} else {
						System.out.println("Invalid amount");
					}
				} else {
					System.out.println("This is not your bankAccount");
				}
			} else {
				System.out.println("Customer is not approved");
			}
			return b1;
		}

		// statement of bankAccounts
		public List<Statement> bankAccountStatement(int bankAccountId) {
			String sql = "Select s from Statement s";
			Query query = entityManager.createQuery(sql);

			List<Statement> s = query.getResultList();
			System.out.println("===================================================================");
			System.out.println("Statement of BankAccount Id : "+bankAccountId);
			for (Statement res : s) {
				if (bankAccountId == res.getBid()) {
					System.out.println(res.getDetails());
				}
			}
			return s;
		}

}
