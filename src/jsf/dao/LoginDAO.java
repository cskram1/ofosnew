package jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jsf.util.DBConnect;

public class LoginDAO {

	public static boolean validate(String email, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DBConnect.getConnection();
			ps = con.prepareStatement("Select uname, password from Account where uname = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DBConnect.close(con);
		}
		return false;
	}
}
