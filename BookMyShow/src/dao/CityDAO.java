package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.City;
import utility.ConnectionManager;

public class CityDAO {

	public void addCity(City city) throws SQLException {
		Connection con = ConnectionManager.getConnection();

		PreparedStatement stmt = con.prepareStatement("insert into city values (?,?)");

		stmt.setInt(1, city.getCityId());
		stmt.setString(2, city.getCityName());

		int result = stmt.executeUpdate();

		if (result == 0)
			System.out.println("Details not added in the city table");
		else
			System.out.println("Details successfully added in the city table");
		con.close();
	}

	public void viewCity() throws SQLException {
		Connection con = ConnectionManager.getConnection();

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from city ");

		System.out.println("City Id\t\tCity Name");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t\t" + rs.getString(2));
		}

	}

	public void deleteCity(int id) throws SQLException {
		Connection con = ConnectionManager.getConnection();

		PreparedStatement stmt = con.prepareStatement("delete from city where id = ?");

		stmt.setInt(1, id);

		int result = stmt.executeUpdate();

		if (result == 0)
			System.out.println("Entered city detail is not deleted from the city table");
		else
			System.out.println("Entered city detail is successfully deleted from the city table");
		con.close();

	}

	public void updateCity(int city_id, String name) throws SQLException {
		Connection con = ConnectionManager.getConnection();

		PreparedStatement stmt = con.prepareStatement("update city set name = ? where id = ?");

		stmt.setString(1, name);
		stmt.setInt(2, city_id);

		int result = stmt.executeUpdate();

		if (result == 0)
			System.out.println("City detail is not updated in the city table");
		else
			System.out.println("City detail is successfully updated in the city table");
		con.close();

	}

}
