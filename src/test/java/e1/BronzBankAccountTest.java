package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzBankAccountTest extends BankAccountTest{

    BronzBankAccountTest() {
        super(new BronzBankAccount(new CoreBankAccount()));
    }
}
