import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {


    private static final String NAME = "Mario";
    private static final String SURNAME = "Rossi";
    protected static final int ID = 1;
    protected static final int WRONG_ID = 2;
    protected static final double EMPTY = 0;
    protected static final double BIG_AMOUNT = 100;
    protected static final double MEDIUM_AMOUNT = 70;
    protected static final double LITTLE_AMOUNT = 30;
    protected AccountHolder accountHolder;
    protected BankAccount bankAccount;

    @BeforeEach
    void setAccountHolder() {
        accountHolder = new AccountHolder(NAME, SURNAME, ID);
    }

    @BeforeEach
    void setBankAccount(){
        bankAccount = new SimpleBankAccount(accountHolder, EMPTY);
    }

    @Test
    void testInitialBalance() {
        assertEquals(EMPTY, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        assertEquals(BIG_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        bankAccount.deposit(WRONG_ID, BIG_AMOUNT);
        assertEquals(BIG_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), MEDIUM_AMOUNT);
        assertEquals(LITTLE_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        bankAccount.withdraw(WRONG_ID, MEDIUM_AMOUNT);
        assertEquals(BIG_AMOUNT, bankAccount.getBalance());
    }
}
