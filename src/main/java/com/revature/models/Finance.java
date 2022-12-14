package com.revature.models;

public class Finance {
	
	private int customerId;
	private int accountNum;
	private double accountBalance;
	
	private double deposit, withdraw, fundsToTransfer;
	private int accountNumReceivingTransfer;
	
	
	public Finance(int accountNumReceivingTransfer) {
		super();
		this.accountNumReceivingTransfer = accountNumReceivingTransfer;
	}


	public Finance(double deposit, double withdraw, double fundsToTransfer) {
		super();
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.fundsToTransfer = fundsToTransfer;
	}


	public Finance() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Finance(int customerId, int accountNum, double accountBalance) {
		super();
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.accountBalance = accountBalance;
	}


	public Finance(int accountNum, double accountBalance) {
		super();
		this.accountNum = accountNum;
		this.accountBalance = accountBalance;
	}



	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public double getDeposit() {
		return deposit;
	}


	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}


	public double getWithdraw() {
		return withdraw;
	}


	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}


	public double getFundsToTransfer() {
		return fundsToTransfer;
	}


	public void setFundsToTransfer(double fundsToTransfer) {
		this.fundsToTransfer = fundsToTransfer;
	}


	public int getAccountNumReceivingTransfer() {
		return accountNumReceivingTransfer;
	}


	public void setAccountNumReceivingTransfer(int accountNumReceivingTransfer) {
		this.accountNumReceivingTransfer = accountNumReceivingTransfer;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountNum;
		result = prime * result + customerId;
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
		Finance other = (Finance) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountNum != other.accountNum)
			return false;
		if (customerId != other.customerId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Finance [customerId=" + customerId + ", accountNum=" + accountNum + ", accountBalance=" + accountBalance
				+ "]";
	}
	
	
	
	
	
}
