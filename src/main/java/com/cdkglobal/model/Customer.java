package com.cdkglobal.model;

/**
 * Customer Bean that holds customer information.
 * I have kept only one field customer type considering given definition otherwise it should contains
 * customer's attributes like customerId, customerName, age etc.
 *
 */
public class Customer {

    private final CustomerType customerType;

    public Customer (final CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }
}
