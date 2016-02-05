package com.training.daoc;

import com.training.ifaces.DAO;
import com.training.myexceptions.RangeCheckException;
import com.training.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.*;

public class CustomerDAO implements DAO<Customer> {

	private Connection con;

	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}

	public CustomerDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	@Override
	public int add(Customer t) {
		String sql = "insert into customer values(?,?,?,?)";

		int rowadded = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getCustomerName());
			pstmt.setInt(2, t.getCustomerId());
			pstmt.setLong(3, t.getHandPhone());
			pstmt.setString(4, t.getEmail_Id());

			rowadded = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowadded;
	}

	@Override
	public Customer find(int key) {
		Customer cust = null;
		String sql = "select * from customer where custId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cust = getCustomer(rs);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cust;
	}

	@Override
	public List<Customer> findAll() {
		ArrayList<Customer> custList = new ArrayList<>();
		String sql = "Select * from customer";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer cust = getCustomer(rs);
				custList.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custList;

	}

	private Customer getCustomer(ResultSet rs) {
		Customer cust = null;
		try {
			int custId = rs.getInt("custid");
			String custName = rs.getString("custName");
			String mail = rs.getString("email");
			long phone = rs.getLong("phone");

			cust = new Customer(custId, custName, mail, phone);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public int update(int key, long phone) {
		Customer cust = null;
		int rowupdated = 0;
		String sql = "update customer set phone=? where custId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, phone);
			pstmt.setInt(2, key);
			rowupdated = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowupdated;
	}

	@Override
	public int delete(int key) {
		Customer cust = null;
		int rowdeleted = 0;
		String sql = "delete from customer where custId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowdeleted;
	}

}
