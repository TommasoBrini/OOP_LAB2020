package oop.lab03.bank;

import oop.lab03.bank.interfaces.BankAccount;

public class StrictBankAccount implements BankAccount {

	private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    private final int usrID;
    private double balance;
    private int nTransactions;
	
	public StrictBankAccount(int usrID, double balance) {
		this.usrID = usrID;
		this.balance = balance;
		this.nTransactions = 0;
	}

	boolean checkID(int id) {
		if(this.usrID == id) {
			return true;
		}
		return false;
	}

	public void withdraw(int usrID, double amount) {
		if(checkID(usrID)) {
			if(this.balance >= amount) {
				this.nTransactions++;
				this.balance -= amount;
			}
		}
	}

	public void deposit(int usrID, double amount) {
		if(checkID(usrID)) {
			this.nTransactions++;
			this.balance += amount;
		}
	}

	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
	}

	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
	}

	public void chargeManagementFees(int usrID) {
		final double feeAmount = MANAGEMENT_FEE + (this.nTransactions * TRANSACTION_FEE);
		if(checkID(usrID)) {
			this.balance -= feeAmount;
			this.nTransactions = 0;
		}
	}

	public double getBalance() {
		return this.balance;
	}

	public int getTransactionsCount() {
		return this.nTransactions;
	}

}
