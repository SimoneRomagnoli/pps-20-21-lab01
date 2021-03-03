package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {
    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }
}
