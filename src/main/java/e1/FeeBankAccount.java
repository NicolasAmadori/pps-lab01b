package e1;

import java.util.function.Function;

public class FeeBankAccount implements BankAccount{

    private final Function<Integer, Integer> feeCalculator;
    private final BankAccount base;

    public FeeBankAccount(Function<Integer, Integer> feeCalculator, BankAccount base) {
        this.feeCalculator = feeCalculator;
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        base.withdraw(amount + feeCalculator.apply(amount));
    }
}
