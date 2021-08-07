package com.merve.account.management;

import java.util.ArrayList;
import java.util.List;

import com.merve.adress.management.Adress;
import com.merve.customer.management.User;
import com.merve.insurance.management.Insurance;

public abstract class Account implements Comparable<Account> {

	protected User user;

	protected List<Insurance> insuranceList;
	
	protected AuthenticationStatus authenticationStatus;

	public Account(User user, List<Insurance> insuranceList) {
		this.user = user;
		this.insuranceList = insuranceList;
	}

	public User getUser() {
		return user;
	}

	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setInsuranceList(List<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}
	
	
	public boolean login(Account account, String email, String password) {

		if (email.equals(account.getUser().getEmail()) && password.equals(account.getUser().getPassword())) {
			authenticationStatus = AuthenticationStatus.SUCCESS;
			
		} else {
			authenticationStatus = AuthenticationStatus.FAIL;
		}
		return authenticationStatus.getCode();
	}


	public final void showUserInfo(User user) {

		if (user != null) {

			StringBuilder builder = new StringBuilder();
			builder.append("User Info: ");
			builder.append("{");
			builder.append(user.getName());
			builder.append(" , ");
			builder.append(user.getLastName());
			builder.append(" , ");
			builder.append(user.getEmail());
			builder.append(" , ");
			builder.append(user.getPassword());
			builder.append(" , ");
			builder.append(user.getJob());
			builder.append(" , ");
			builder.append(user.getAge());
			builder.append(" }");
			
			System.out.println(builder);

			showUserAddress(user);

		} else {
			System.out.println("User List is Empty!");
		}

	}

	
	public void showUserAddress(User user) {

		List<Adress> adressList = new ArrayList<>();
		adressList = user.getAdressList();

		System.out.println(adressList.toString());

	}
	


	public boolean addInsurance(Account account, Insurance insurance) {
	
		List<Insurance> insuranceList = new ArrayList<Insurance>();

			insuranceList.add(insurance);
			account.setInsuranceList(insuranceList);
			return true;

		
	}
	
	public final void showInsurance(List<Insurance> insuranceList) {

		if (!insuranceList.isEmpty()) {
			for (Insurance insurance : insuranceList) {
				StringBuilder builder = new StringBuilder();
				builder.append("Insurance Info: ");
				builder.append("{");
				builder.append(insurance.getInsuranceName());
				builder.append(" , ");
				builder.append(insurance.getInsurancePrice());
				builder.append(" , ");
				builder.append(insurance.getStartInsuranceDate());
				builder.append(" , ");
				builder.append(insurance.getEndInsuranceDate());
				builder.append(" }");
				System.out.println(builder);
			}
		} else {
			System.out.println("Insurance list is Empyt!");

		}

	}

	protected abstract double addProfit(double insurancePrice);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authenticationStatus == null) ? 0 : authenticationStatus.hashCode());
		result = prime * result + ((insuranceList == null) ? 0 : insuranceList.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (authenticationStatus != other.authenticationStatus)
			return false;
		if (insuranceList == null) {
			if (other.insuranceList != null)
				return false;
		} else if (!insuranceList.equals(other.insuranceList))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
	
	


}
