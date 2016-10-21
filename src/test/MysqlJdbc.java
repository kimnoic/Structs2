package test;

import java.sql.*;


public class MysqlJdbc {
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
							"jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false",
							"root", "root");
			// Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码

			System.out.println("Success connect Mysql server!");
			
/*			
			Statement initDB = connect.createStatement();
			for (int i = 0; i < 10; i++) {
//				System.out.println("insert into user values("+i+",'team"+i+"')");
				initDB.execute("insert into user values("+i+",'team"+i+"')");
			}*/
			
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			// user 为你表的名称
			while (rs.next()) {
				System.out.println(rs.getString("name") + " : " + rs.getString("number"));
			}
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}
}