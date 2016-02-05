package com.training.daoc;

import java.util.*;

import com.training.entity.Customer;

public class sqlApplication {

	public static void main(String[] args) {
		// try {
		// Customer cust = new Customer(1003, "Suresh", "sur@abc.com",
		// 9987372999L);
		// CustomerDAO dao = new CustomerDAO();
		// int rowadded = dao.add(cust);
		// System.out.println(rowadded+" Row Added");
		// } catch (RangeCheckException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	CustomerDAO dao = new CustomerDAO();
//		Customer cust2 = new Customer();
//		cust2 = dao.find(1003);
//		System.out.println(cust2.showCustomer());
//
//int  i= dao.update(1004, 8867625252L);
//	System.out.println("Row updated "+i);

	List<Customer> custList = dao.findAll();
System.out.println(custList);
	}

}
