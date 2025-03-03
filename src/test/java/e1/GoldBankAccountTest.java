package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest {

    @Test
    public void testInitiallyEmpty() {
        BankAccount account = new GoldBankAccount(new CoreBankAccount());
        assertEquals(0, account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        BankAccount account = new GoldBankAccount(new CoreBankAccount());

        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }
}
