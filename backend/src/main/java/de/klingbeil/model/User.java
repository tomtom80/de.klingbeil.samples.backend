package de.klingbeil.model;

public class User {

	private String firstName;
	private String lastName;
	private String eMail;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}

	public String getEmail() {
		return eMail;
	}

}
