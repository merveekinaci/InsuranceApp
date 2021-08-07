package com.merve.adress.management;

public class HomeAdress implements Adress {

	private String country;
	private String city;
	private String street;
	private int apartmentNumber;
	private int postCode;
	
	public HomeAdress() {
		
	}

	public HomeAdress(String country, String city, String street, int apartmentNumber, int postCode) {
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.country = country;
		this.postCode = postCode;
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public int getPostCode() {
		return postCode;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(this.getCountry());
		builder.append(" - ");
		builder.append(this.getCity());
		builder.append(" - ");
		builder.append(this.getStreet());
		builder.append(" - ");
		builder.append(this.getApartmentNumber());
		builder.append(" - ");
		builder.append(this.getPostCode());
		builder.append("]");

		return builder.toString();

	}

}
