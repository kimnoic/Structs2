package test;

import java.sql.*;

public class DataMaker {	
	static String form(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into author values(");
		sb.append(String.format("%013d", i)+',');
		sb.append("'name"+i+"',");
		sb.append(i + ",");
		sb.append("'country"+i+"'");
		sb.append(')');
		return sb.toString();
	}
	
	static String frombook(int i) {
		return String.format("insert into book values('bookname%d', %d, 'publisher%d', %d, '999999999%03d', '%04d-%02d-%02d')", i, i/10+1,i%10,i,i,2016,1,i%20+1);
	}
	
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
			// Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/lib_db?autoReconnect=true&useSSL=false",
							"root", "root");
			// Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");

			Statement initDB = connect.createStatement();
			
			for (int i = 0; i < 100; i++) {
				String tmp = frombook(i);
				System.out.println(tmp);
				initDB.execute(tmp);
			}
			
			/*
			for (int i = 1; i <= 10; i++) {
//				System.out.println("insert into user values("+i+",'team"+i+"')");
				String tmp = form(i);
				System.out.println(tmp);
				initDB.execute(tmp);
			}
			*/
			
//			Statement stmt = connect.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from user");
//			// user 为你表的名称
//			while (rs.next()) {
//				System.out.println(rs.getString("name") + " : " + rs.getString("number"));
//			}
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}
}
