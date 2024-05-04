package com.example.cab;

import com.example.cab.entity.Driver;
import com.example.cab.entity.Location;
import com.example.cab.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CabApplication {

	private static List<Driver> driverList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(CabApplication.class, args);

		initialUsers();
		initializeDriver();


		String result1 = findRider("Abhishek", new Location(0, 0), new Location(10,1));
		String result2 = findRider("Rahul", new Location(10, 0), new Location(15, 3));
		String result3 = findRider("Nandini", new Location(15, 6), new Location(20,4));

		System.out.println("  Abhishek  " + result1);
		System.out.println("  Rahul " + result2);
		System.out.println("  Nandini " + result3);
	}

	public static void initialUsers() {
		List<User> userService = new ArrayList<>();
		userService.add(new User("Abhishek, M, 23"));
		userService.add(new User("Rahul, M, 29"));
		userService.add(new User("Nandini, F, 22"));

		System.out.println("----------------------------User Details are--------------------------");
		userService.forEach(x -> System.out.println(x.getUserDetails()));

		System.out.println("----------------------------****************--------------------------");
	}

	public static void initializeDriver() {
		// Create locations
		Location location1 = new Location(10, 1);
		Location location2 = new Location(11, 10);
		Location location3 = new Location(5, 3);

		driverList.add(new Driver("Driver1,M,22", "Swift, KA-01-12345", location1));
		driverList.add(new Driver("Driver2,M,29", "Swift, KA-01-12345", location2));
		driverList.add(new Driver("Driver3,M,24", "Swift, KA-01-12345", location3));

		System.out.println("---------------------------Registered Driver are--------------------------");
		driverList.forEach(y -> System.out.println(y.getDriverDetails() + y.getDriverCar()));

		System.out.println("----------------------------****************--------------------------");
	}

	public static String findRider(String userName, Location sourceLocation, Location destinationLocation) {
		for (Driver driver : driverList) {
			int distanceSource = calculateDistance(driver.getCurrentLocation(), sourceLocation);
			int distanceDestination = calculateDistance(driver.getCurrentLocation(), destinationLocation);
			if (distanceSource < 5 && distanceDestination <= 5 && driver.isAvailable()) {
				driver.setAvailable(false);
				return driver.getDriverDetails() + " [Available]";
			}
		}
		return "No ride found";
	}



	private static int calculateDistance(Location location1, Location location2) {

		int dx = location1.getX() - location2.getX();
		int dy = location1.getY() - location2.getY();
		return (int) Math.sqrt(dx * dx + dy * dy);
	}
}