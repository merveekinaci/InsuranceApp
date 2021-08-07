package com.merve.insurance.management;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CarInsurance extends Insurance {

	public CarInsurance(String insuranceName, double insurancePrice, Date startInsuranceDate, Date endInsuranceDate) {
		super(insuranceName, insurancePrice, startInsuranceDate, endInsuranceDate);

	}

	@Override
	public double calculate() {
		
		long difference = super.getStartInsuranceDate().getTime() - super.getEndInsuranceDate().getTime();
		long diffCalculate = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
		double calculatePrice = (super.insurancePrice * diffCalculate) * 2.0;
		return super.insurancePrice + calculatePrice;
		
	}

}
