package de.klingbeil.model;

public class User {

	private Long id;
	private Long version;
	private String firstName;
	private String lastName;
	private String eMail;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getVersion() {
		return version;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id=" + id);
		builder.append(" version=" + version);
		builder.append(" firstName=" + firstName);
		builder.append(" lastName=" + lastName);
		builder.append(" eMail=" + eMail);
		return builder.toString();
	}

}
