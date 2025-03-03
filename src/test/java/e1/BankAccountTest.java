package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    private final BankAccount startingAccount;
    protected BankAccount account;

    public BankAccountTest(BankAccount account) {
        this.startingAccount = account;
    }

    @BeforeEach
    void init(){
        this.account = this.startingAccount;
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
}
