package com.merve.insurance.management;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TravelInsurance extends Insurance{

	public TravelInsurance(String insuranceName, double insurancePrice, Date startInsuranceDate,
			Date endInsuranceDate) {
		super(insuranceName, insurancePrice, startInsuranceDate, endInsuranceDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		
		long difference = super.getStartInsuranceDate().getTime() - super.getEndInsuranceDate().getTime();
		long diffCalculate = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
		double calculatePrice = (super.insurancePrice * diffCalculate) * 1.0;
		return super.insurancePrice + calculatePrice;
	}

}
