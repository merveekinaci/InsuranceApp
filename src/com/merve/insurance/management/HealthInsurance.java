package com.merve.insurance.management;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HealthInsurance extends Insurance{

	public HealthInsurance(String insuranceName, double insurancePrice, Date startInsuranceDate,
			Date endInsuranceDate) {
		super(insuranceName, insurancePrice, startInsuranceDate, endInsuranceDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate() {
		
		long difference = super.getStartInsuranceDate().getTime() - super.getEndInsuranceDate().getTime();
		long diffCalculate = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
		double calculatePrice = (super.insurancePrice * diffCalculate) * 0.35;
		return super.insurancePrice + calculatePrice;
	}
	


}
