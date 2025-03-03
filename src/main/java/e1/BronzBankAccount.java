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
        if (this.getBalance() - amount < 0){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
