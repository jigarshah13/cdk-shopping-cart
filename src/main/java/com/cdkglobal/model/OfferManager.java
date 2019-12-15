package com.cdkglobal.model;

import com.cdkglobal.com.cdkglobal.exception.IllegalCustomerTypeException;
import com.cdkglobal.com.cdkglobal.exception.InvalidAmountException;
import com.cdkglobal.customer.CustomerFactory;
import com.cdkglobal.customer.ICustomer;

/**
 * Manager class which executes discount on purchase amount based on the type of customer.
 */
public class OfferManager {

    /**
     * Obtain object of concrete class for customer type and call method to calculate amount.
     * No change require in this class on addition of new customer type or removal of existing customer type.
     *
     * @param customer object of customer
     * @param purchaseAmount total purchase amount
     * @return calculated bill amount after applying discount as per slab
     * @throws Exception thrown exception in case of erroneous condition
     */
    public double processDiscount(final Customer customer, final double purchaseAmount) throws Exception {
        final CustomerFactory customerFactory = new CustomerFactory();
        ICustomer customerManager = customerFactory.getCustomer(customer);
        if(customerManager == null) {
            throw new IllegalCustomerTypeException(customer.getCustomerType() == null ? null : customer.getCustomerType().name());
        }

        if(purchaseAmount <= 0) {
            throw new InvalidAmountException(purchaseAmount);
        }
        return customerManager.calculateBillAmount(purchaseAmount);
    }
}
