package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzBankAccountTest{
    @Test
    public void testInitiallyEmpty() {
        BankAccount account = new BronzBankAccount(new CoreBankAccount());
        assertEquals(0, account.getBalance());
    }
}
