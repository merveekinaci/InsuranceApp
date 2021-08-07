package com.merve.main;

import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.merve.account.management.Account;
import com.merve.account.management.AccountManager;
import com.merve.exception.management.InvalidAuthenticationException;
import com.merve.insurance.management.CarInsurance;
import com.merve.insurance.management.HealthInsurance;
import com.merve.insurance.management.Insurance;
import com.merve.insurance.management.ResidenceInsurance;
import com.merve.insurance.management.TravelInsurance;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static AccountManager accountManager = createCustomers();
	static Account account;
	static Insurance insurance;


	public static void main(String[] args) {

		showMenu();

		while (true) {

			int choice = makeProcessChoice();

			if (choice == 5) {
				System.out.println("\nSUCCESSFUL LOGOUT");
				account = null;
				break;
			}

			switch (choice) {
			case 0:
				showMenu();
				System.out.println();
				break;

			case 1:
				account = loginControl(account);
				System.out.println();
				break;

			case 2:
				account.showUserInfo(account.getUser());
				System.out.println();
				break;
			case 3:
				addInsurance(account);
				System.out.println();
				break;
			case 4:
				account.showInsurance(account.getInsuranceList());
				System.out.println();
				break;
			}

		}

	}

	private static void showMenu() {

		System.out.println("0- Show Menu ");
		System.out.println("1- Login ");
		System.out.println("2- Customer Info ");
		System.out.println("3- Add Insurance for Customer ");
		System.out.println("4- Customer's Insurances ");
		System.out.println("5- Logout ");

		
	}
		
	public static int makeProcessChoice() {

		System.out.println("Choose Your Operation");
		int choice = scanner.nextInt();
		return choice;
	}

	private static Account loginControl(Account account) {
		account = login(accountManager, account);

		while (account == null) {
			System.out.println();
			account = login(accountManager, account);
			
		}
		return account;
	}

	private static Account login(AccountManager accountManager, Account account) {
		System.out.println("***Login Page***");
		scanner.nextLine();

		String email, password;

		System.out.println("\nEmail :");
		email = scanner.nextLine();

		System.out.println("Password :");
		password = scanner.nextLine();

		try {
			account = accountManager.login(email, password);
		} catch (InvalidAuthenticationException e) {
			System.out.println(e.getMessage());
		}
		return account;
	}

	private static AccountManager createCustomers() {

		Set<Account> accountSet = new TreeSet<Account>();
		AccountManager accountManager = new AccountManager(accountSet);
		accountManager.createCustomers();
		return accountManager;
	}

	private static void addInsurance(Account account) {

		Insurance insurance = getInsuranceType();
		while (insurance == null) {
			insurance = getInsuranceType();
		}

		if (account.addInsurance(account, insurance)) {
			System.out.println("Added!");
		} else {
			System.out.println("Try Again");
		}
	}
	
	private static Insurance getInsuranceType() {
		byte key;
		
		
		System.out.println("******ADD INSURANCE******");
		System.out.println("1-Health Insurance");
		System.out.println("2-Residence Insurance");
		System.out.println("3-Car Insurance");
		System.out.println("4-Travel Insurance");

		key = scanner.nextByte();
		scanner.nextLine();
		switch (key) {
		case 1:
			return new HealthInsurance("Health Insurance",5000, new Date(), new Date());
		case 2:
			return new ResidenceInsurance("Residence Insurance", 150000, new Date(), new Date());
		case 3:
			return new CarInsurance("Car Insurance",1500, new Date(), new Date());
		case 4:
			return new TravelInsurance("Travel Insurance",500, new Date(), new Date());
		default:
			return null;
		}
	}
}
	
	
	