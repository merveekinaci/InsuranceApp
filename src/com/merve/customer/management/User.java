package com.merve.customer.management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.merve.adress.management.Adress;
import com.merve.adress.management.AdressManager;

public class User {

	protected String name;
	protected String lastName;
	protected String email;
	protected String password;
	protected String job;
	protected int age;
	protected ArrayList<Adress> adressList;
	protected Date lastSystemLoginDate;

	public User() {

	}

	public User(String name, String lastName, String email, String password, String job, int age,
			ArrayList<Adress> adressList) {

		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.job = job;
		this.age = age;
		this.adressList = adressList;
		

	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getJob() {
		return job;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<Adress> getAdressList() {
		return adressList;
	}

	public Date getLastSystemLoginDate() {
		return lastSystemLoginDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAdressList(ArrayList<Adress> adressList) {
		this.adressList = adressList;
	}

	public void setLastSystemLoginDate(Date lastSystemLoginDate) {
		this.lastSystemLoginDate = lastSystemLoginDate;
	}

	


}
