package com.merve.account.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.merve.adress.management.Adress;
import com.merve.adress.management.AdressManager;
import com.merve.adress.management.BusinessAdress;
import com.merve.adress.management.HomeAdress;
import com.merve.customer.management.EnterpriseCustomer;
import com.merve.customer.management.IndividualCustomer;
import com.merve.customer.management.User;
import com.merve.exception.management.InvalidAuthenticationException;
import com.merve.insurance.management.Insurance;

public class AccountManager {

	public Set<Account> accountSet;

	private static TreeSet<Account> accountList;

	public AccountManager(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

	public static TreeSet<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(TreeSet<Account> accountList) {
		this.accountList = accountList;
	}

	public Account login(String email, String password) throws InvalidAuthenticationException {

		Iterator<Account> iterator = accountSet.iterator();

		while (iterator.hasNext()) {
			Account account = iterator.next();
			if (account.login(account, email, password)) {
				System.out.println(AuthenticationStatus.SUCCESS.getDescription());
				return account;
			}
		}
		throw new InvalidAuthenticationException(AuthenticationStatus.FAIL.getDescription());
	}

	public void createCustomers() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("***New Customer***");

		ArrayList<Adress> userAdress = new ArrayList<Adress>();

		System.out.println("Add Customer Info:");

		System.out.println("Name :");
		String name = scanner.nextLine();

		System.out.println("Last Name :");
		String lastName = scanner.nextLine();

		System.out.println("Email :");
		String email = scanner.nextLine();

		System.out.println("Password :");
		String password = scanner.nextLine();

		System.out.println("Job :");
		String job = scanner.nextLine();

		System.out.println("Age :");
		int age = scanner.nextInt();

		User user = new User(name, lastName, email, password, job, age, userAdress);

		System.out.println("Choose Customer Type");
		System.out.println("1- Individual");
		System.out.println("2- Enterprice");
		System.out.println("**************");

		System.out.println("Choise 1 or 2 : ");
		int choose = scanner.nextInt();

		if (choose == 1) {

			scanner.nextLine();

			System.out.println("Customer's Home Adress Info:");

			System.out.println("Country :");
			String country = scanner.nextLine();

			System.out.println("City :");
			String city = scanner.nextLine();

			System.out.println("Street :");
			String street = scanner.nextLine();

			System.out.println("Number :");
			int number = scanner.nextInt();

			System.out.println("PostCode :");
			int postCode = scanner.nextInt();

			AdressManager.addAdress(user, new HomeAdress(country, city, street, number, postCode));
			Account account = new IndividualCustomer(user, new ArrayList<Insurance>());
			this.accountSet.add(account);

			System.out.println("Saved!");
			System.out.println("*********************************");
			System.out.println(" ");
			System.out.println(" ");

		} else if (choose == 2) {

			scanner.nextLine();

			System.out.println("Customer's Business Adress Info:");

			System.out.println("Country :");
			String country = scanner.nextLine();

			System.out.println("City :");
			String city = scanner.nextLine();

			System.out.println("Street :");
			String companyName = scanner.nextLine();

			System.out.println("Number :");
			int number = scanner.nextInt();

			System.out.println("PostCode :");
			int postCode = scanner.nextInt();

			AdressManager.addAdress(user, new BusinessAdress(country, city, companyName, postCode));
			Account account = new EnterpriseCustomer(user, new ArrayList<Insurance>());
			this.accountSet.add(account);

			System.out.println("Saved!");
			System.out.println("*********************************");
			System.out.println(" ");
			System.out.println(" ");

		} else {
			System.out.println("Please enter 1 or 2");
		}
	}

}
