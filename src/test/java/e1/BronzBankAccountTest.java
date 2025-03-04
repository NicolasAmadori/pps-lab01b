package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzBankAccountTest extends BankAccountTest{

    BronzBankAccountTest() {
        super(new BankAccountFactoryImpl().createBronzeBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        super.account.deposit(1000);
        assertDoesNotThrow(() -> super.account.withdraw(200));
    }

    @Test
    public void testWithdrawMoreThanAvailable() {
        super.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> super.account.withdraw(1001));
    }

    @Test
    public void testZeroFeeWithdrawal() {
        super.account.deposit(1000);
        super.account.withdraw(99);
        assertEquals(901, super.account.getBalance());
    }

    @Test
    public void testFeeWithdrawal() {
        super.account.deposit(1000);
        super.account.withdraw(100);
        assertEquals(899, super.account.getBalance());
    }
}
