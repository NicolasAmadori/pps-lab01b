package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzBankAccountTest extends BankAccountTest{

    BronzBankAccountTest() {
        super(new BronzBankAccount(new CoreBankAccount()));
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        assertDoesNotThrow(() -> this.account.withdraw(200));
    }

    @Test
    public void testWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1500));
    }

    @Test
    public void testZeroFeeWithdrawal() {
        this.account.deposit(1000);
        this.account.withdraw(99);
        assertEquals(901, this.account.getBalance());
    }
}
