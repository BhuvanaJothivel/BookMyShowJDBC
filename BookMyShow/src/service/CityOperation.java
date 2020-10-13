package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.CityDAO;
import model.City;

public class CityOperation {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	CityDAO citydao = new CityDAO();
	AdminOperation adminoperation = new AdminOperation();

	public void viewOperations() throws NumberFormatException, IOException, SQLException {
		while (true) {
			System.out.println("Select the operation");
			System.out.println(
					"1. Create city details\n2. Display city details\n3. Delete city detail\n4. Update city detail\n5. Exit");
			int opt = Integer.parseInt(br.readLine());
			switch (opt) {
			case 1: {
				System.out.println("Enter the city id");
				int cityId = Integer.parseInt(br.readLine());
				System.out.println("Enter the city name");
				String cityName = br.readLine();
				City city = new City(cityId, cityName);
				citydao.addCity(city);
				break;
			}

			case 2: {
				citydao.viewCity();
				break;
			}
			case 3: {
				System.out.println("Enter the city id that you want to delete from the list");
				int id = Integer.parseInt(br.readLine());
				citydao.deleteCity(id);
				break;
			}
			case 4: {
				System.out.println("Enter the city id that you want to update");
				int city_id = Integer.parseInt(br.readLine());
				System.out.println("Enter the city name to get updated");
				String name = br.readLine();
				citydao.updateCity(city_id, name);
				break;
			}
			case 5: {

				adminoperation.adminOperations();
				break;

			}
			default: {
				System.out.println("Invalid option!!! Kindly choose the right one!!!");
			}
			}
			System.out.println("Do you want to proceed with city operations?\n1. YES    2. NO");
			int option = Integer.parseInt(br.readLine());
			if (option == 1)
				continue;
			else
				adminoperation.adminOperations();
		}

	}

}
