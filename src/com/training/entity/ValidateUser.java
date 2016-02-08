package com.training.entity;
import java.sql.Connection;

import com.training.util.SqlConnection;

import java.sql.*;

public class ValidateUser {
	private Connection con;

	public boolean validate(User user) {
		
		
		String sql = "Select * from SapientUser where username=? AND password=?";
		ResultSet rs = null;
		boolean check = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			rs = pstmt.executeQuery();
			check = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return check;
	}

	public ValidateUser() {
		super();
		con = SqlConnection.getOracleConnection();
	}

}
