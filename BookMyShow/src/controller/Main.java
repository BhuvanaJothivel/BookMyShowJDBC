package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import service.AdminOperation;
import service.UserOperation;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		System.out.println("BookMyShow");
		loginAs();
	}

	public static void loginAs() throws IOException, SQLException {
		int option = 1;
		while (true) {
			System.out.println("Login as\n1. Admin\n2. User\n3. Logout");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int opt = Integer.parseInt(br.readLine());
			switch (opt) {
			case 1:
				AdminOperation adminoperation = new AdminOperation();
				adminoperation.login();
				break;
			case 2:
				UserOperation useroperation = new UserOperation();
				useroperation.operation();
			case 3:
				option = 0;
				break;
			default:
				System.out.println("Invalid option!!! Kindly choose the right one!!!");
			}
			if (option == 1)
				continue;
			else {
				System.out.println("Thank you for your service");
				System.exit(0);
			}
		}

	}

}
