package com.cdkglobal.customer;

import com.cdkglobal.model.Customer;
import com.cdkglobal.model.CustomerType;

/**
 * Factory class to create customer object based on the customer type.
 */
public class CustomerFactory {

    /**
     * Return customer object based on the customer type.
     *
     * Note: On addition of new customer type, add new if condition to check new customer type and create object of
     * that customer type's concrete class.
     *
     * @param customer customer object
     * @return object of concrete class created for customer type
     */
    public ICustomer getCustomer(final Customer customer) {
        ICustomer iCustomer = null;
        if(CustomerType.REGULAR.equals(customer.getCustomerType())) {
            iCustomer = new RegularCustomer();
        }
        return iCustomer;
    }
}
