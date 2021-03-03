package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {

    public static final double ATM_FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        super.deposit(usrID, amount-ATM_FEE);
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        super.withdraw(usrID, amount+ATM_FEE);
    }

}
