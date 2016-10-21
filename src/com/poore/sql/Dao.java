package com.poore.sql;

import java.sql.*;

public class Dao {
	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;

	public Dao() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "rootroot";
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s?autoReconnect=true&useSSL=false", new Object[] {
				"ecdalqkkhuqq.rds.sae.sina.com.cn", "10568", "bookdb" });
		Class.forName(driver);
		this.con = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("getConnection success");
		this.stat = this.con.createStatement();
		System.out.println("connect successfully!!");
	}

	public void close() throws SQLException {
		if (this.con != null) {
			this.con.close();
		}
		System.out.println("close connection successful!!");
	}

	public boolean execute(String sql) throws SQLException {
		return this.stat.execute(sql);
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		System.out.println(sql);
		return this.stat.executeQuery(sql);
	}

	public void executeUpdate(String sql) throws SQLException {
		this.stat.executeUpdate(sql);
	}
}
