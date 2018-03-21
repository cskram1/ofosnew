package jsf.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnection() {
		try {
//			String hostname = "oracle-instance1.cprjhicmmemt.us-east-2.rds.amazonaws.com";
//			String port = "1521";
//			String dbName = "ORCL";
			String userName = "admin";
			String password = "password";
			//String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName + "?user=" + userName + "&password=" + password;
			String jdbcUrl = "jdbc:oracle:thin:@oracle-instance1.cprjhicmmemt.us-east-2.rds.amazonaws.com:1521:ORCL";
			Connection con = DriverManager.getConnection(jdbcUrl,userName,password);
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
