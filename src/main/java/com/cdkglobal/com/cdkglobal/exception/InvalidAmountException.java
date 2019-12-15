package com.cdkglobal.com.cdkglobal.exception;

/**
 * Custom Exception to handle invalid purchase Amount.
 */
public class InvalidAmountException extends Exception {

    public InvalidAmountException(final double purchaseAmount) {
        super("Purchase Amount should be greater than 0: "+purchaseAmount);
    }
}
