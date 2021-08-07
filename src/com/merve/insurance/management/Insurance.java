package com.merve.insurance.management;


import java.util.Date;

public abstract class Insurance {
	
	protected String insuranceName;
	protected double insurancePrice;
	protected Date startInsuranceDate;
	protected Date endInsuranceDate;
	
	public Insurance(String insuranceName, double insurancePrice, Date startInsuranceDate, Date endInsuranceDate) {
        this.insuranceName = insuranceName;
        this.insurancePrice = insurancePrice;
        this.startInsuranceDate = startInsuranceDate;
        this.endInsuranceDate = endInsuranceDate;
    }
	
	
	
	public String getInsuranceName() {
		return insuranceName;
	}



	public double getInsurancePrice() {
		return insurancePrice;
	}



	public Date getStartInsuranceDate() {
		return startInsuranceDate;
	}



	public Date getEndInsuranceDate() {
		return endInsuranceDate;
	}



	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}



	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}



	public void setStartInsuranceDate(Date startInsuranceDate) {
		this.startInsuranceDate = startInsuranceDate;
	}



	public void setEndInsuranceDate(Date endInsuranceDate) {
		this.endInsuranceDate = endInsuranceDate;
	}



	public abstract double calculate();
	
}
