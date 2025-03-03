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
        if (amount >= 100 && this.getBalance() - amount - 1 < 0) {
            throw new IllegalStateException();
        } else if (amount < 100 && this.getBalance() - amount < 0){
            throw new IllegalStateException();
        }
        if (amount >= 100) {
            base.withdraw(amount + 1);
        } else {
            base.withdraw(amount);
        }
    }
}
