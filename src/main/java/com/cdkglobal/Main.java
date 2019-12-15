package com.cdkglobal;

import com.cdkglobal.com.cdkglobal.exception.IllegalCustomerTypeException;
import com.cdkglobal.model.Customer;
import com.cdkglobal.model.CustomerType;
import com.cdkglobal.model.OfferManager;

import java.util.Scanner;

/**
 * Main class to run application with different use cases and to view the results.
 */
public class Main {

    public static void main(String[] args) {
        try {
            new Main().executeTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void executeTransaction() throws Exception {
        final CustomerType customerType = getCustomerType();
        final double purchaseAmount = getPurchaseAmount();
        Customer customer = new Customer(customerType);
        OfferManager offerManager = new OfferManager();
        final double billAmount = offerManager.processDiscount(customer, purchaseAmount);
        System.out.println("Charged Bill Amount to customer is: $"+billAmount);
    }

    private CustomerType getCustomerType() throws IllegalCustomerTypeException {
        String customerType = "";
        try {
            final Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Customer Type: ");
            customerType = scanner.nextLine();
            return CustomerType.valueOf(customerType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalCustomerTypeException(customerType);
        }
    }

    private double getPurchaseAmount() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Purchase Amount: $");
        return scanner.nextDouble();
    }
}
