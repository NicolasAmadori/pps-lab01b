package e1;

import java.util.function.Function;

public class NegativeBalanceBankAccount implements BankAccount{

    private final Integer minBalance;
    private final BankAccount base;

    public NegativeBalanceBankAccount(Integer minBalance, BankAccount base) {
        this.minBalance = minBalance;
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
        if(this.getBalance() - amount < this.minBalance) {
            throw new IllegalStateException("Balance can't go under: " + this.minBalance);
        }
        this.base.withdraw(amount);
    }
}
