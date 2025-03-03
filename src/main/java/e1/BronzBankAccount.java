package e1;

public class BronzBankAccount implements BankAccount {

    private final CoreBankAccount base;

    public BronzBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void withdraw(int amount) {

    }
}
