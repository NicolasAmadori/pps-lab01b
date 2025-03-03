package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest {

    private BankAccount account;

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanAvailableButLessThanFiveHundred(){
        this.account.deposit(1000);
        assertDoesNotThrow(() -> this.account.withdraw(1500));
    }
}
