package com.Banking;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemsTest {
    Account account = new Account(1000, "A123", "Saving", "John");
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
@Test
    public void testBuyItemWithSufficientBalance() {
        Items item = new Items("Item 1", "A123", 500.0, 3);
        double initialBalance = account.getBalance();
        String out=item.buy(account);
        double updatedBalance = account.getBalance();
        Assertions.assertEquals("Item bought",out);
        Assertions.assertEquals(updatedBalance , initialBalance- item.getPrice());
    }

    @Test
    public void testBuyItemWithInsufficientBalance() {
        Items item = new Items("Item 2", "A1234",5000,4);
        double initialBalance = account.getBalance();
        String out = item.buy(account);
        double updatedBalance = account.getBalance();
        Assertions.assertEquals("Not Enough Balance",out);
        Assertions.assertEquals(initialBalance, updatedBalance);
    }

}