package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.Main;
import dao.AdminDAO;

public class AdminOperation {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void login() throws IOException, SQLException {
		System.out.println("Enter the admin name");
		String adminName = br.readLine();
		System.out.println("Enter the password");
		String password = br.readLine();
		AdminDAO admindao = new AdminDAO();
		boolean result = admindao.checkCredentials(adminName, password);
		if (result) {
			System.out.println("Welcome " + adminName);
			adminOperations();
		} else
			System.out.println("Check your credentials please!!!");

	}

	public void adminOperations() throws NumberFormatException, IOException, SQLException {
		while (true) {
			System.out.println("Select the option for CRUD\n1. City\n2. Threatre\n3. Movie\n4. Ticket\n5. Exit");

			int opt = Integer.parseInt(br.readLine());

			switch (opt) {
			case 1:
				CityOperation cityoperation = new CityOperation();
				cityoperation.viewOperations();
				break;
			case 5:
				Main main = new Main();
				Main.loginAs();
				break;
			default:
				System.out.println("Invalid option!!! Please choose the right one!!!");
			}
			System.out.println("Do you want to proceed with admin operations?\n1. YES    2. NO");
			int option = Integer.parseInt(br.readLine());
			if (option == 1)
				continue;
			else
				break;
		}

	}
}
