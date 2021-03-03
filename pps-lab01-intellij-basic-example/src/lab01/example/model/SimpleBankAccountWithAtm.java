package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount implements BankAccount {
    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        super.deposit(usrID, amount-1);
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        super.withdraw(usrID, amount+1);
    }

}
