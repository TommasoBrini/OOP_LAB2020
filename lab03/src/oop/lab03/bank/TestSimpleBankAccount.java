package oop.lab03.bank;

public final class TestSimpleBankAccount {

    private TestSimpleBankAccount() { }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Mario Rossi con id 1 2) Creare
         * l' AccountHolder relativo a Luigi Bianchi con id 2 3) Creare i due
         * SimpleBankAccount corrispondenti 4) Effettuare una serie di depositi e
         * prelievi 5) Stampare a video l'ammontare dei due conti e verificare
         * la correttezza del risultato 6) Provare a prelevare fornendo un idUsr
         * sbagliato 7) Controllare nuovamente l'ammontare
         */
    	AccountHolder marioRossi = new AccountHolder("Mario", "Rossi", 1);
    	AccountHolder luigiBianchi = new AccountHolder("Luigi", "Bianchi", 2);
    	
    	SimpleBankAccount rossiAccount = new SimpleBankAccount(marioRossi.getUserID(), 1000);
    	System.out.println(rossiAccount.getBalance());
    	SimpleBankAccount bianchiAccount = new SimpleBankAccount(luigiBianchi.getUserID(), 0);
    	System.out.println(bianchiAccount.getBalance());
    	System.out.println();
    	
    	rossiAccount.withdraw(marioRossi.getUserID(), 500);
    	bianchiAccount.deposit(4, 500);
    	System.out.println(rossiAccount.getBalance());
    	System.out.println(bianchiAccount.getBalance());
    	System.out.println();
    	
    	rossiAccount.deposit(marioRossi.getUserID(), 500);
    	System.out.println(rossiAccount.getBalance());
    	
    	rossiAccount.depositFromATM(marioRossi.getUserID(), 500);
    	System.out.println(rossiAccount.getBalance());
    }
}
