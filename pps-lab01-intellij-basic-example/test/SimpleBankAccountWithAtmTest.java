import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    private static final double ATM_FEE = SimpleBankAccountWithAtm.ATM_FEE;

    @BeforeEach
    void setBankAccount() {
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, EMPTY);
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        assertEquals(BIG_AMOUNT-ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        bankAccount.deposit(WRONG_ID, BIG_AMOUNT);
        assertEquals(BIG_AMOUNT-ATM_FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), MEDIUM_AMOUNT);
        assertEquals(LITTLE_AMOUNT-ATM_FEE*2, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), BIG_AMOUNT);
        bankAccount.withdraw(WRONG_ID, MEDIUM_AMOUNT);
        assertEquals(BIG_AMOUNT-ATM_FEE, bankAccount.getBalance());
    }

}
