package com.Banking;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(1000.0, "123456789", "Savings", "John Doe");
    }

    @Test
    public void testGetBalance() {
        double expectedBalance = 1000.0;
        double actualBalance = account.getBalance();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }


}
