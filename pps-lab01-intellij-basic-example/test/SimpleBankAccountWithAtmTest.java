import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;

public class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{

    @BeforeEach
    void setBankAccount() {
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

}
