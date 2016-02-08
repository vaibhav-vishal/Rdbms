package com.training.application;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableExample {

	public static void main(String[] args) {
		try {
			int count = 0;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:system/oracle10G@localhost:1521:XE";
			Connection con = DriverManager.getConnection(url);
			CallableStatement stmt = con.prepareCall("call updatePhoneNumer(?,?)");
			stmt.setInt(1, 1003);
			stmt.setLong(2, 8899909222L);
			stmt.executeQuery();
			count = stmt.getUpdateCount();
			System.out.println(count+" Rows Updated");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
