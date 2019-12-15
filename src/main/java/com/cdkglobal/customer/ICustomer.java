package com.cdkglobal.customer;

/**
 * Hold the abstract method to calculate bill amount so customer specific implementation can be provided.
 * Example:
 *  For Regular Customer, RegularCustomer class is implemented using this interface which holds discount calculation
 *  logic according to the slab defined for Regular customer.
 *
 *  On introduction of new type of customer, for example VIP customer, new class VIPCustomer should be created from
 *  this interface where discount would be calculate according the slab.
 */
public interface ICustomer {

    double calculateBillAmount(final double purchaseAmount);
}
