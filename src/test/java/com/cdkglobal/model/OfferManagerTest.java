package com.cdkglobal.model;

import com.cdkglobal.com.cdkglobal.exception.IllegalCustomerTypeException;
import com.cdkglobal.com.cdkglobal.exception.InvalidAmountException;

import static org.junit.Assert.assertEquals;

/**
 * Test class to test various use cases for OfferManager
 */
public class OfferManagerTest {

    private final OfferManager offerManager = new OfferManager();

    @org.junit.Test(expected = IllegalCustomerTypeException.class)
    public void exceptionShouldBeThrownWhenCustomerTypeDoesNotExists() throws Exception {

        final Customer customer = new Customer(null);
        offerManager.processDiscount(customer, 0);
    }

    @org.junit.Test(expected = InvalidAmountException.class)
    public void exceptionShouldBeThrownWhenPurchaseAmountIsLTEZero() throws Exception {

        final Customer customer = new Customer(CustomerType.REGULAR);
        offerManager.processDiscount(customer, 0);
    }

    @org.junit.Test
    public void whenPurchaseAmountIsLessThen5kThenBillAmountShouldBeSameAsPurchaseAmount() throws Exception {

        final Customer customer = new Customer(CustomerType.REGULAR);
        double purchaseAmount = offerManager.processDiscount(customer, 4500);
        assertEquals(4500.0, purchaseAmount, 0);
    }

    @org.junit.Test
    public void whenPurchaseAmountIsGT5kAndLThen10kThen10PDiscountShouldApplyOnPurchaseAmount() throws Exception {

        final Customer customer = new Customer(CustomerType.REGULAR);
        double purchaseAmount = offerManager.processDiscount(customer, 9000);
        assertEquals(8600.0, purchaseAmount, 0);
    }

    @org.junit.Test
    public void whenPurchaseAmountIsGT10kThenDiscountShouldApplyAsPerSlabOnPurchaseAmount() throws Exception {

        final Customer customer = new Customer(CustomerType.REGULAR);
        double purchaseAmount = offerManager.processDiscount(customer, 15000);
        assertEquals(13500.0, purchaseAmount, 0);
    }
}