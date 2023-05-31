package com.Banking;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Bill_PaymentTest {
    Account account = new Account(1000, "A123", "Saving", "John");
    Bill_Payment bill_payment = new Bill_Payment("Electricity", 50.0);
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddBill() {

        int initialBillsSize = account.getBills().size();
        bill_payment.addBill("Electricity", 50.0,account);
        int updatedBillsSize = account.getBills().size();
        Assertions.assertEquals(initialBillsSize + 1, updatedBillsSize);
    }




    @Test
    public void testPayBillAfterPayment() {
        bill_payment.addBill("Electricity", 50.0,account);
        int initialBillsSize = account.getBills().size();
        double initialBalance=account.getBalance();
        bill_payment.pay(account);
        int updatedBillsSize = account.getBills().size();
        double updatedBalance = account.getBalance();
        Assertions.assertEquals(initialBillsSize - 1, updatedBillsSize);
        Assertions.assertEquals(updatedBalance,initialBalance-50);
    }

    @Test
    public void testPayBillWithNonExistingBill() {
        int initialBillsSize = account.getBills().size();
        String out= bill_payment.pay(account);
        int updatedBillsSize = account.getBills().size();
        double updatedBalance = account.getBalance();
        Assertions.assertEquals(initialBillsSize, updatedBillsSize);
        Assertions.assertEquals(1000.0, updatedBalance);
        Assertions.assertEquals("Bill not found",out);
    }

    @Test
    public void testFindBillWithExistingBillType() {
        bill_payment.addBill("Electricity", 50.0,account);
        int billIndex = bill_payment.findBill("Electricity",account);
        Assertions.assertEquals(0, billIndex);
    }

    @Test
    public void testFindBillWithNonExistingBillType() {
        int billIndex = bill_payment.findBill("Water",account);
        Assertions.assertEquals(-1, billIndex);
    }

}