package com.cdkglobal.com.cdkglobal.exception;

/**
 * Custom Exception to handle illegal customer type.
 */
public class IllegalCustomerTypeException extends Exception {

    public IllegalCustomerTypeException(String customerType) {
        super("Customer Type \"" + customerType + "\" does not exists.");
    }
}
