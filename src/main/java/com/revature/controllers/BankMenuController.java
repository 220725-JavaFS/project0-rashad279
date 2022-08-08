package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.services.CustomerServicesController;


public class BankMenuController {
	private Customer customer = new Customer();
	private CustomerServicesController customerServicesController = new CustomerServicesController();
	private Scanner scanner = new Scanner(System.in);

	public void bankMenu() {
		
		String userChoice = "";
		
		System.out.println("\nWelcome To Rocket Finances");
		
		while (!userChoice.equalsIgnoreCase("0")) {
			System.out.println("\nMain Menu"
					+ "\nEnter 1 - To Register As A Customer"
					+ "\nEnter 2 - To Login"
					+ "\nEnter 0 - To Exit");
			userChoice = scanner.nextLine();

			switchChoice: 
			switch (userChoice){
				case "0":
					System.out.println("\nSorry to see you leave, Goodbye.");
					break switchChoice;
				case "1":
					System.out.println("\nYou selected Register\n\nThanks, for being are our newest customer!");
					registerCustomer();
					// No break so user can be send to Login afterwards
				case "2":
					loginMenu();
					break switchChoice;
				default:
					System.out.println("\nThat is not a valid input. Try again!");
					break switchChoice;
					
			}//switchChoice
			
		}//while loop
		
	}//bankMenu method

	private void registerCustomer() {
		
		System.out.println("Create a new username: ");
		customer.setUserName(scanner.nextLine());
		
		System.out.println("Create a new password: ");
		customer.setPassword(scanner.nextLine());
		
		customerServicesController.createCustomer(customer);
		
	}
	
	private void loginMenu() {
		
		String userAnswer = "";
		
		loginMenu:
		while (!userAnswer.equals("0")) {
			System.out.println("\nLogin Menu"
					+ "\nEnter 1 - Customer Login"
					+ "\nEnter 2 - Employee Login"
					+" \nEnter 3 - Administrator Login"
					+ "\nEnter 0 - To Exit");
			
			System.out.println("Choose a number corresponding to your role: ");
			userAnswer = scanner.nextLine();

			
			switch (userAnswer){
				case "0":
					break;
				case "1":
					loginCustomer();
					checkApplicationStatus();
					break loginMenu;
				case "2":
					break loginMenu;
				case "3":
					break loginMenu;
				default:
					System.out.println("\nThat is not a valid input. Try again");
					break;
					
			}//switchChoice
			
		}//while loop
		
	}//loginMenu

	private void loginCustomer() {
		
		System.out.println("\nType your existing username: ");
		customer.setUserName(scanner.nextLine());
		
		System.out.println("Type your password: ");
		customer.setPassword(scanner.nextLine());
		
		customerServicesController.checkCustomerLogin(customer);
	}
	
	
	private void checkApplicationStatus() {
		
		String status = customer.getApplicationStatus();
		
		if (status.equalsIgnoreCase("none")) {
			applyForAccount();
		}
		else if (status.equalsIgnoreCase("applied")) {
			System.out.println("your financial account application is pending, please check back later");
		}
		else if (status.equalsIgnoreCase("denied")) {
			System.out.println("We are sorry you have NOT been approved for a financial account with us."
					+ "\nSorry for the inconvenience");
		}
		else if (status.equalsIgnoreCase("approved")) {
			// navigate to financial account Menu
		}
		else {
			System.out.println("an error occurred");
		}
	
		
	}

	private void applyForAccount() {
		String answer = "";
		System.out.println("Would you like to apply for a financial account?"
				+ "\nType 'yes' or 'no':");
		answer = scanner.nextLine();
		
		if (answer.trim().equalsIgnoreCase("yes")) {
			applicationQuestions();
			customerServicesController.addCustomerApplication(customer);
			System.out.println("your financial account application has been sent, please check back later!");
		}
		else if (answer.trim().equalsIgnoreCase("no")){
			System.out.println("Ok, you can apply later");
		}
		else {
			System.out.println("\ninvalid input");
		}
		
		
		
	}

	private void applicationQuestions() {
		
		System.out.println("\nApplication Questions\n");
		
		System.out.println("First Name: ");
		customer.setFirstName(scanner.nextLine());
		
		System.out.println("Last Name: ");
		customer.setLastName(scanner.nextLine());
		
		System.out.println("Address Street Number: ");
		customer.setStrNum(scanner.nextLine());
		
		System.out.println("Address Street Name: ");
		customer.setStrName(scanner.nextLine());
		
		System.out.println("City: ");
		customer.setCity(scanner.nextLine());
		
		System.out.println("State: ");
		customer.setState(scanner.nextLine());
		
		System.out.println("Zip: ");
		customer.setZip(scanner.nextLine());
		
		// Change application status
		String a = "applied";
		customer.setApplicationStatus(a);
		
	}
	
	
	
	
	
	
	
}//class
