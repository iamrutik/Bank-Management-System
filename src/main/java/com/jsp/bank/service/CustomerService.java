package com.jsp.bank.service;

import java.util.List;

import com.jsp.bank.dao.CustomerDao;
import com.jsp.bank.dto.BankAccount;
import com.jsp.bank.dto.Customers;
import com.jsp.bank.dto.Statement;

public class CustomerService {

	CustomerDao customerDao=new CustomerDao();
	
	//save customers
	public Customers saveCustomers(Customers customers) {
		return customerDao.saveCustomers(customers);
	}
	
	//delete Customer
	public Customers deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}
	
	//update Customer's name by id
	public Customers updateCustomersNameById(int id, String name) {
		return customerDao.updateCustomerNameById(id, name);
	}
	
	//update Customer's dob by id
		public Customers updateCustomersDobById(int id, String dob) {
			return customerDao.updateCustomerDobById(id, dob);
	}
		
	//update Customer's gender by id
	public Customers updateCustomersGenderById(int id, String gender) {
		return customerDao.updateCustomerGenderById(id, gender);
	}
	
	//get customer by id
	public Customers getCustomersById(int id) {
		return customerDao.getCustomersById(id);
	}
	
	//get all customers
	public List<Customers> getAllCustomers(){
		return customerDao.getAllCustomers();
	}
		
	public BankAccount saveBankAccount(BankAccount bankAccount, int customerId) {
		return customerDao.saveBankAccount(bankAccount, customerId);
	}
	
	public BankAccount deleteBankAccount(int id) {
		return customerDao.deleteBankAccount(id);
	}
	
	public BankAccount getBankAccount(int id) {
		return customerDao.getBankAccount(id);
	}
	
	public List<BankAccount> getAllBankAccounts(){
		return customerDao.getAllBankAccounts();
	}
		
	public BankAccount depositAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.depositAmount(customerId, bankAccountId, amount);
	}
	
	public BankAccount debiteAmount(int customerId, int bankAccountId, double amount) {
		return customerDao.debiteAmount(customerId, bankAccountId, amount);
	}
	
	public BankAccount transferAmount(int customerId, int creditorId, int depositorId, double amount) {
		return customerDao.transferAmount(customerId, creditorId, depositorId, amount);
	}
	
	public List<Statement> bankAccountStatement(int bankAccountId){
		return customerDao.bankAccountStatement(bankAccountId);
	}
}
