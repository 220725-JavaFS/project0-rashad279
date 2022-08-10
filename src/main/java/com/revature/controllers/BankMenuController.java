package com.revature.controllers;

import java.util.List;
import java.util.Scanner;


import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Finance;
import com.revature.services.CustomerServicesController;
import com.revature.services.EmployeeServicesController;
import com.revature.services.FinanceServicesController;
import com.revature.services.AdminServicesController;


public class BankMenuController {
	
	private Customer customer = new Customer();
	private Employee employee = new Employee();
	private Admin admin = new Admin();
	private Finance finance = new Finance();
	
	private AdminServicesController adminServicesController = new AdminServicesController();
	private CustomerServicesController customerServicesController = new CustomerServicesController();
	private EmployeeServicesController employeeServicesController = new EmployeeServicesController();
	private FinanceServicesController financeServicesController = new FinanceServicesController();
	
	private Scanner scanner = new Scanner(System.in);

	public void bankMenu() {
		
		String userChoice = "";
		
		System.out.println("\nWelcome To Rocket Finances");
		
		while (!userChoice.equalsIgnoreCase("0")) {
			System.out.println("\nMain Menu"
					+ "\nEnter 1 - To Register"
					+ "\nEnter 2 - To Login"
					+ "\nEnter 0 - To Exit");
			userChoice = scanner.nextLine();

			switchChoice: 
			switch (userChoice){
				case "1":
					System.out.println("\nYou selected Register\n\nThanks, for being are our newest customer!");
					registerCustomer();
					// No break so user can be send to Login afterwards
				case "2":
					loginMenu();
					break switchChoice;
				case "0":
					System.out.println("\nSorry to see you leave, Goodbye.");
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
		
		String loginChoice = "";
		
		loginMenu:
		while (!loginChoice.equals("0")) {
			System.out.println("\nLogin Menu"
					+ "\nEnter 1 - For Customer Login"
					+ "\nEnter 2 - For Employee Login"
					+" \nEnter 3 - For Administrator Login"
					+ "\nEnter 0 - To Exit");
			
			System.out.println("Choose a number: ");
			loginChoice = scanner.nextLine();

			
			switch (loginChoice){
				case "0":
					break;
				case "1":
					loginCustomer();
					checkApplicationStatus();
					break loginMenu;
				case "2":
					loginEmployee();
					employeeMenu();
					break loginMenu;
				case "3":
					loginAdmin();
					adminMenu();
					break loginMenu;
				default:
					System.out.println("\nThat is not a valid input. Try again");
					break;
					
			}//switchChoice
			
		}//while loop
		
	}//loginMenu

	
	private void employeeMenu() {
		
		String employeeChoice = "";

		while (!employeeChoice.equalsIgnoreCase("0")) {
			System.out.println("\nBank Employee Menu"
					+ "\nEnter 1 - To Display All Customer Accounts"
					+ "\nEnter 2 - To Approve/Deny Applications" 
					+ "\nEnter 0 - To Exit");
			employeeChoice = scanner.nextLine();

			switchChoice: 
			switch (employeeChoice){
				case "0":
					break switchChoice;
				case "1":
					allCustomerAccounts();
					break switchChoice;
				case "2":
					updateApplications();
					break switchChoice;
				default:
					System.out.println("\nThat is not a valid input. Try again!");
					break switchChoice;
					
			}//switchChoice
			
		}//while loop
	}

	private void allCustomerAccounts() {
		List<Customer> accountsList = employeeServicesController.displayCustomerAccounts();
		
		for(Customer b:accountsList) {
			System.out.println(b);
		}
	}

	
	private void updateApplications() {
	
		List<Customer> applicationList = employeeServicesController.customerApplications();
		
		for (Customer a : applicationList) {
			System.out.println(a);
		}

		System.out.println("Enter the CustomerID of the customer you want to approve/deny");
		customer.setCustomerId(scanner.nextInt());

		System.out.println("Type 'approved' to approve, or type 'denied' to deny application.");
		scanner.nextLine();
		customer.setApplicationStatus(scanner.nextLine());

		employeeServicesController.updateCustomerAppl(customer);

		String newStatus = customer.getApplicationStatus();

		if (newStatus.equalsIgnoreCase("approved")) {
			employeeServicesController.createFinancialAccount(customer);
		}
	}

	

	private void adminMenu() {
		
		String adminChoice = "";
		
		while (!adminChoice.equalsIgnoreCase("0")) {
			System.out.println("\nBank Admin Menu"
					+ "\nEnter 1 - To Display/Edit Customer Accounts"
					+ "\nEnter 2 - To Display/Edit Employee Accounts"
					+ "\nEnter 3 - To Approve/Deny Applications"
					+ "\nEnter 4 - To Create New Employee Login"
					+ "\nEnter 0 - To Exit");
			adminChoice = scanner.nextLine();

			switchChoice: 
			switch (adminChoice){
				case "0":
					break switchChoice;
				case "1":
					System.out.println("u entered 1");
					adminViewCustomerAccounts();
					break switchChoice;
				case "2":
					System.out.println("u entered 2");
					adminViewEmployeeAccounts();
					break switchChoice;
				case "3":
					System.out.println("u entered 3");
					updateApplications();
					break switchChoice;
				case "4":
					System.out.println("u entered 4");
					createNewEmployee();
					break switchChoice;
				default:
					System.out.println("\nThat is not a valid input. Try again!");
					break switchChoice;
					
			}//switchChoice
			
		}//while loop
		
	}

	private void createNewEmployee() {
		
		System.out.println("\nType new employee username: ");
		employee.setUserName(scanner.nextLine());
		
		System.out.println("Type new employee password: ");
		employee.setPassword(scanner.nextLine());
	
		adminServicesController.createNewEmployee(employee);
		
	}

	private void adminViewEmployeeAccounts() {
		List<Employee> employeeList = adminServicesController.employeeAccountsView(employee);
		
		for (Employee a : employeeList) {
			System.out.println(a);
		}
		
		String answer = "";
		System.out.println("\nType 'change' if you want to change employee login credentials."
				+ "\nType 'remove' if you want to remove an employee account"
				+ "\nType '0' to exit");
		answer = scanner.nextLine();
		
		if (answer.trim().equalsIgnoreCase("change")) {
			
			System.out.println("Please enter the employee id: ");
			employee.setEmployeeId(scanner.nextInt());
			scanner.nextLine();
			
			System.out.println("\nType new employee username: ");
			employee.setUserName(scanner.nextLine());
			
			System.out.println("Type new employee password: ");
			employee.setPassword(scanner.nextLine());
			
			adminServicesController.updateEmployee(employee);
		}
		else if (answer.trim().equalsIgnoreCase("remove")) {
			
			System.out.println("Please enter the employee id: ");
			employee.setEmployeeId(scanner.nextInt());
			
			adminServicesController.removeEmployee(employee);
		}
		else if (answer.trim().equalsIgnoreCase("0")) {
			System.out.println("you selected exit");
		}
		else {
			System.out.println("invalid input. try again later!");
		}
	}

	private void adminViewCustomerAccounts() {
		allCustomerAccounts();
		
		String answer1 = "";
		System.out.println("\nType '1' if you want to change customer login credentials."
				+ "\nType '2' if you want update customer name and address"
				+ "\nType '3' if you want to update customer account balance"
				+ "\nType '4' if you want to remove a customer account"
				+ "\nType '0' to exit");
		answer1 = scanner.nextLine();
		
		if (answer1.trim().equalsIgnoreCase("1")) {
		
			System.out.println("Please enter the customer id: ");
			customer.setCustomerId(scanner.nextInt());
			scanner.nextLine();
			
			System.out.println("\nType new employee username: ");
			customer.setUserName(scanner.nextLine());
			
			System.out.println("Type new employee password: ");
			customer.setPassword(scanner.nextLine());
			
			adminServicesController.changeCustomerLogin(customer);
			}
		else if (answer1.trim().equalsIgnoreCase("2")) {
			applicationQuestions();
			
			adminServicesController.changeCustomerAddress(customer);
			}
		else if (answer1.trim().equalsIgnoreCase("3")) {
			System.out.println("Please enter the customer id: ");
			finance.setCustomerId(scanner.nextInt());
			
			System.out.println("What amount do you want to change the balance to: ");
			finance.setAccountBalance(scanner.nextDouble());
			
			adminServicesController.changeCustomerAccountBal(finance);
			}
		else if (answer1.trim().equalsIgnoreCase("4")) {
			System.out.println("Please enter the customer id: ");
			finance.setCustomerId(scanner.nextInt());
			
			adminServicesController.removeCustomerAccount(finance);
			}
		else if (answer1.trim().equalsIgnoreCase("0")) {
			System.out.println("you selected exit");
			}
		else {
			System.out.println("invalid input. try again later!");
		}
	}

	private void loginAdmin() {
		// TODO Auto-generated method stub
		System.out.println("\nAdmin:\nType your existing username: ");
		admin.setUserName(scanner.nextLine());
		
		System.out.println("Type your password: ");
		admin.setPassword(scanner.nextLine());
		
		adminServicesController.checkAdminLogin(admin);
	}

	private void loginEmployee() {
		// TODO Auto-generated method stub
		System.out.println("\nEmployee:\nType your existing username: ");
		employee.setUserName(scanner.nextLine());
		
		System.out.println("Type your password: ");
		employee.setPassword(scanner.nextLine());
		
		employeeServicesController.checkEmployeeLogin(employee);
	}

	private void loginCustomer() {
		
		
		System.out.println("\nCustomer:\nType your existing username: ");
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
			System.out.println("\nYour financial account application is pending, please check back later");
		}
		else if (status.equalsIgnoreCase("denied")) {
			System.out.println("\nWe are sorry you financial account with us has been denied."
					+ "\nSorry for the inconvenience");
		}
		else if (status.equalsIgnoreCase("approved")) {
			customerFinancesMenu();
		}
		else {
			System.out.println("an error occurred");
		}
	
		
	}


	private void importFinancialAccount() {
		int id = customer.getCustomerId();
		finance.setCustomerId(id);
		financeServicesController.getCustomerFinanceInformation(finance);
		
	}

	private void customerFinancesMenu() {
		
		String customerChoice = "";
		
		while (!customerChoice.equalsIgnoreCase("0")) {
			
			importFinancialAccount();
			
			System.out.println("Account Balance: $"+finance.getAccountBalance()+ "\tAccount Number: #" +finance.getAccountNum()
					+ "\nEnter 1 - To Deposit"
					+ "\nEnter 2 - To Withdraw"
					+" \nEnter 3 - To Transfer funds"
					+ "\nEnter 0 - To Exit");
			customerChoice = scanner.nextLine();

			switchChoice: 
			switch (customerChoice){
				case "0":
					break switchChoice;
				case "1":
					depositMoney();
					break switchChoice;
				case "2":
					withdrawMoney();
					break switchChoice;
				case "3":
					transferfunds();
					break switchChoice;
				default:
					System.out.println("\nThat is not a valid input. Try again!");
					break switchChoice;
					
			}//switchChoice
		}//while loop	
	}//customerMenu

	private void transferfunds() {
		
		System.out.println("What is the account number you are transferring to?: ");
		finance.setAccountNumReceivingTransfer(scanner.nextInt());
		
		System.out.println("How much do you want to send?: ");
		finance.setFundsToTransfer(scanner.nextDouble());
		scanner.nextLine();
		
		if (finance.getFundsToTransfer() >= 0 && finance.getFundsToTransfer() <= finance.getAccountBalance()) {
			financeServicesController.financialTransferFunds(finance);
		}
		else if (finance.getFundsToTransfer() >= 0 && finance.getFundsToTransfer() > finance.getAccountBalance()) {
			System.out.println("You dont have enough money");
		}
		else if (finance.getFundsToTransfer() < 0) {
			System.out.println("Money transfer can NOT be negative");
		}
		else {
			System.out.println("invalid input, try again soon");
		}
	}

	private void withdrawMoney() {
		
		
		System.out.println("How much do you want to withdraw?: ");
		finance.setWithdraw(scanner.nextDouble());
		scanner.nextLine();
		
		if (finance.getWithdraw() >= 0 && finance.getWithdraw() <= finance.getAccountBalance()) {
			financeServicesController.financialWithdrawal(finance);
		}
		else if (finance.getWithdraw() >= 0 && finance.getWithdraw() > finance.getAccountBalance()) {
			System.out.println("You dont have enough money");
		}
		else if (finance.getWithdraw() < 0) {
			System.out.println("Withdrawal can NOT be negative");
		}
		else {
			System.out.println("invalid input, try again soon");
		}
	}
		

	private void depositMoney() {

		System.out.println("How much do you want to deposit?: ");
		finance.setDeposit(scanner.nextDouble());
		scanner.nextLine();
		
		if (finance.getDeposit() >= 0) {
			financeServicesController.financialDeposit(finance);
		}
		else if (finance.getDeposit() < 0) {
			System.out.println("deposit can NOT be negative, try again later");
		}
		else {
			System.out.println("invalid input, try again soon");
		}
	}

	private void applyForAccount() {
		String answer = "";
		System.out.println("\nWould you like to apply for a financial account?"
				+ "\nType 'yes' or 'no':");
		answer = scanner.nextLine();
		
		if (answer.trim().equalsIgnoreCase("yes")) {
			System.out.println("\nApplication Questions\n");
			applicationQuestions();
			String a = "applied";
			customer.setApplicationStatus(a);
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
		
		
		
	}
	
	
}//class

