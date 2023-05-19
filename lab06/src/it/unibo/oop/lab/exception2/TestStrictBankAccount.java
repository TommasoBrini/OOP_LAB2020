package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    static final double AMOUNT = 10000;
    static final int MAXATM = 10;
    
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
         
	final AccountHolder tommi = new AccountHolder("Tommaso", "Brini", 1);
	final AccountHolder luca = new AccountHolder("Luca", "Brini", 2);
	
	final StrictBankAccount tommiAccount = new StrictBankAccount(tommi.getUserID(), AMOUNT, MAXATM);
	final StrictBankAccount lucaAccount = new StrictBankAccount(luca.getUserID(), AMOUNT, MAXATM);
	
	/* 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
	
	try {
            tommiAccount.deposit(4, 100);
            fail();
        } catch (WrongAccountHolderException e) {
            assertNotNull(e);
        }
	for (int i = 0; i < 10; i++) {
            try {
                lucaAccount.depositFromATM(luca.getUserID(), 1);
            } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
                fail("Not exceeded yet max no. transactions!");
            }
        }
	
	try {
            lucaAccount.depositFromATM(luca.getUserID(), 1);
            fail("Should raise the exception signaling that we exceeded max no. transactions!");
        } catch (TransactionsOverQuotaException | WrongAccountHolderException e) {
            assertNotNull(e);
        }
	
	try {
            tommiAccount.withdraw(tommi.getUserID(), 50000);
        } catch (WrongAccountHolderException e) {
            fail();
        } catch (NotEnoughFoundsException e) {
            assertNotNull(e);
        }
    }
}
