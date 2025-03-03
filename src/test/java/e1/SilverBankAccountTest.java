package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest{

    SilverBankAccountTest(){
        super(new SilverBankAccount(new FeeBankAccount((a) -> 1, new CoreBankAccount())));
    }

    @Test
    public void testCanWithdraw() {
        super.account.deposit(1000);
        super.account.withdraw(200);
        assertEquals(799, super.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        super.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> super.account.withdraw(1200));
    }

}
