package com.merve.adress.management;

public class BusinessAdress implements Adress {

	private String country;
	private String city;
	private String companyName;
	private int postCode;
	
	public BusinessAdress() {
		
	}

	public BusinessAdress(String country, String city, String companyName, int postCode) {

		this.city = city;
		this.country = country;
		this.postCode = postCode;
		this.companyName = companyName;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(this.getCountry());
		builder.append(" - ");
		builder.append(this.getCity());
		builder.append(" - ");
		builder.append(this.getCompanyName());
		builder.append(" - ");
		builder.append(this.getPostCode());
		builder.append("]");

		return builder.toString();

	}

}
