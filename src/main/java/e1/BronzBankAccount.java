package e1;

public class BronzBankAccount implements BankAccount {

    private final CoreBankAccount base;

    public BronzBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int fee = (amount >= 100) ? 1: 0;
        if (this.getBalance() - amount - fee < 0) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + fee);
    }
}
