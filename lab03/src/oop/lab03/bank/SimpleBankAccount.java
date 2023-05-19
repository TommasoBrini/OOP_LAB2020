package oop.lab03.bank;

import oop.lab03.bank.interfaces.BankAccount;

public class SimpleBankAccount implements BankAccount{

	static double ATM_TRANSACTION_FEE = 1;
	
	private int userID;
	private double balance;
	private int nTransactions;
	
    /*
     * Aggiungere i seguenti campi:
     * - double balance: ammontare del conto
     * - int userID: id del possessore del conto (già dichiarato: si veda al riguardo il metodo checkUser dichiarato in fondo alla classe)
     * - int nTransactions: numero delle operazioni effettuate
     * - static double ATM_TRANSACTION_FEE = 1: costo delle operazioni via ATM
     */

    /*
     * Creare un costruttore pubblico che prenda in ingresso un intero (ossia l'id
     * dell'utente) ed un double (ossia, l'ammontare iniziale del conto corrente).
     */

	public SimpleBankAccount(int userID, double balance) {
		this.userID = userID;
		this.balance = balance;
		this.nTransactions = 0;
	}
	
    /*
     * Si aggiungano selettori per: 
     * - ottenere l'id utente del possessore del conto
     * - ottenere il numero di transazioni effettuate
     * - ottenere l'ammontare corrente del conto.
     */

	public int getUserID() {
		return userID;
	}

	public double getBalance() {
		return balance;
	}
	
	boolean checkID(int id) {
		if(this.userID == id) {
			return true;
		}
		return false;
	}

    public void deposit(final int usrID, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto Nota: il deposito va a buon fine solo se l'id utente
         * corrisponde
         */
    	if(checkID(usrID)) {
    		this.nTransactions++;
    		this.balance += amount;
    	}
    }

	public void withdraw(final int usrID, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde
         */
		if(checkID(usrID)) {
    		this.nTransactions++;
    		this.balance -= amount;
    	}
    }

    public void depositFromATM(final int usrID, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto detraendo le spese (costante ATM_TRANSACTION_FEE) relative
         * all'uso dell'ATM (bancomat) Nota: il deposito va a buon fine solo se
         * l'id utente corrisponde
         */
    	if(checkID(usrID)) {
    		this.nTransactions++;
    		this.balance += (amount-ATM_TRANSACTION_FEE);
    	}
    }

    public void withdrawFromATM(final int usrID, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount + le spese
         * (costante ATM_TRANSACTION_FEE) relative all'uso dell'ATM (bancomat)
         * al totale del conto. Note: - Il conto puo' andare in rosso (ammontare
         * negativo) - Il prelievo va a buon fine solo se l'id utente
         * corrisponde
         */
    	if(checkID(usrID)) {
    		this.nTransactions++;
    		this.balance -= (amount + ATM_TRANSACTION_FEE);
    	}
    }

	public void chargeManagementFees(int usrID) {
		
	}

	public int getTransactionsCount() {
		return nTransactions;
	}

}
