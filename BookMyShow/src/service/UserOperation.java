package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.UserDAO;
import model.UserDetails;

public class UserOperation {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	UserDAO userdao = new UserDAO();
	public void operation() throws NumberFormatException, IOException, SQLException {
		while(true) {
		System.out.println("1. SignUp\n2. SignIn\n3. Exit");
		int opt = Integer.parseInt(br.readLine());
		switch(opt) {
		case 1:{
			System.out.println("Enter username");
			String username = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			System.out.println("Enter email");
			String email = br.readLine();
			System.out.println("Enter phone number");
			long phoneNumber = Long.parseLong(br.readLine());
			UserDetails userdetails = new UserDetails(username,password,email,phoneNumber);
			userdao.addUser(userdetails);
			userOperations();
			break;
		}
		case 2:{
			System.out.println("Enter the username");
			String name = br.readLine();
			System.out.println("Enter the password");
			String passWord = br.readLine();
			boolean result = userdao.loginUser(name,passWord);
			if (result) {
				System.out.println("Welcome " + name);
				userOperations();
			} else
				System.out.println("Check your credentials please!!!");
		}
		}
		System.out.println("Do you want to add or login as user?\n1. YES    2. NO");
		int option = Integer.parseInt(br.readLine());
		if (option == 1)
			continue;
		else
			break;
		}
		
		
	}
	private void userOperations() {
		// TODO Auto-generated method stub
		
	}

}
