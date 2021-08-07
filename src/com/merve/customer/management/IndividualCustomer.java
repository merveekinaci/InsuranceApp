package com.merve.customer.management;

import java.util.ArrayList;

import com.merve.account.management.Account;
import com.merve.insurance.management.Insurance;

public class IndividualCustomer extends Account{

	public IndividualCustomer(User user, ArrayList<Insurance> insuranceList) {
		super(user, insuranceList);
		
	}

	@Override
	protected double addProfit(double insurancePrice) {
		double totalPrice;
		totalPrice = insurancePrice + (insurancePrice * 0.70);
		return totalPrice;	}

	@Override
	public int compareTo(Account o) {
		return this.getUser().getLastName().compareTo(o.getUser().getLastName());
	}

}
