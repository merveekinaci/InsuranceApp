package com.merve.account.management;

public enum AuthenticationStatus {

	SUCCESS(true,"SUCCESSFUL LOGIN"), 
	FAIL(false,"CUSTOMER NOT EXISTED");

	private final boolean code;
	private final String description;

	
	private AuthenticationStatus(boolean code, String description) {
		this.code = code;
		this.description = description;
	}


	public boolean getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}
