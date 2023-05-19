package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount {

	private static final double TRANSACTION_FEE = 0.1;
	
	protected RestrictedBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}

	protected double computeFees() {
		return MANAGEMENT_FEE + (getNTransactions() * TRANSACTION_FEE);
	}

	protected boolean isWithdrawAllowed(double amount) {
		return getBalance() >= amount;
	}

}
