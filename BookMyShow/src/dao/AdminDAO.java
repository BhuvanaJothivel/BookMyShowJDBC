package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.ConnectionManager;

public class AdminDAO {

	public boolean checkCredentials(String adminName, String password) throws SQLException {
		Connection con = ConnectionManager.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from admin ");

		while (rs.next()) {
			if (rs.getString(1).equals(adminName) && rs.getString(2).equals(password)) {
				return true;
			}
		}
		return false;
	}

}
