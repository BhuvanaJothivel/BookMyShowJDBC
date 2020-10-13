package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.UserDetails;
import utility.ConnectionManager;

public class UserDAO {

	public void addUser(UserDetails userdetails) throws SQLException {
		Connection con = ConnectionManager.getConnection();

		PreparedStatement stmt = con.prepareStatement("insert into userdetails values (?,?,?,?)");

		stmt.setString(1, userdetails.getUsername());
		stmt.setString(2, userdetails.getPassword());
		stmt.setString(3, userdetails.getEmail());
		stmt.setLong(4, userdetails.getPhoneNumber());

		int result = stmt.executeUpdate();

		if (result == 0)
			System.out.println("Details not added in the userdetails table");
		else
			System.out.println("Details successfully added in the userdetails table");
		con.close();
		
	}

	public boolean loginUser(String name, String passWord) throws SQLException {
		Connection con = ConnectionManager.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from userdetails ");

		while (rs.next()) {
			if (rs.getString(1).equals(name) && rs.getString(2).equals(passWord)) {
				return true;
			}
		}
		return false;
		
	}

}
