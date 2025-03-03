package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest{

    GoldBankAccountTest(){
        super(new GoldBankAccount(new CoreBankAccount()));
    }

    @Test
    public void testCanWithdraw() {
        super.account.deposit(1000);
        super.account.withdraw(200);
        assertEquals(800, super.account.getBalance());
    }

    @Test
    public void testWithdrawMoreThanAvailableButLessThanFiveHundred(){
        super.account.deposit(1000);
        assertDoesNotThrow(() -> super.account.withdraw(1500));
    }

    @Test
    public void testWithdrawMoreThanAvailableButMoreThanFiveHundred(){
        super.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> super.account.withdraw(1501));
    }
}
