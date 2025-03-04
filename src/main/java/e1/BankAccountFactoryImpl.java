package e1;

public class BankAccountFactoryImpl implements BankAccountFactory {
    @Override
    public BankAccount createSilverBankAccount() {
        return new NegativeBalanceBankAccount(0,
                new FeeBankAccount((a) -> 1,
                        new CoreBankAccount()));
    }

    @Override
    public BankAccount createGoldBankAccount() {
        return new NegativeBalanceBankAccount(-500,
                new FeeBankAccount((a) -> 0,
                        new CoreBankAccount()));
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        return new NegativeBalanceBankAccount(0,
                new FeeBankAccount((a) -> (a < 100) ? 0 : 1,
                        new CoreBankAccount()));
    }
}
