package com.revature.models;

public class Customer {
	private int customerId; 
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String strNum;
	private String strName;
	private String city;
	private String state;
	private String zip;
	private String applicationStatus;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId, String userName, String password, String firstName, String lastName, String strNum,
			String strName, String city, String state, String zip, String applicationStatus) {
		super();
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.strNum = strNum;
		this.strName = strName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.applicationStatus = applicationStatus;
	}

	// no id
	public Customer(String userName, String password, String firstName, String lastName, String strNum, String strName,
			String city, String state, String zip, String applicationStatus) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.strNum = strNum;
		this.strName = strName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.applicationStatus = applicationStatus;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getStrNum() {
		return strNum;
	}


	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}


	public String getStrName() {
		return strName;
	}


	public void setStrName(String strName) {
		this.strName = strName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String string) {
		this.zip = string;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}


	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationStatus == null) ? 0 : applicationStatus.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((strName == null) ? 0 : strName.hashCode());
		result = prime * result + ((strNum == null) ? 0 : strNum.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (applicationStatus == null) {
			if (other.applicationStatus != null)
				return false;
		} else if (!applicationStatus.equals(other.applicationStatus))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (customerId != other.customerId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (strName == null) {
			if (other.strName != null)
				return false;
		} else if (!strName.equals(other.strName))
			return false;
		if (strNum == null) {
			if (other.strNum != null)
				return false;
		} else if (!strNum.equals(other.strNum))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}


	public String toString() {
		return "Customer [customerId=" + customerId + ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", strNum=" + strNum + ", strName=" + strName
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", applicationStatus=" + applicationStatus
				+ "]";
	}
	
	
	
}// Customer class
