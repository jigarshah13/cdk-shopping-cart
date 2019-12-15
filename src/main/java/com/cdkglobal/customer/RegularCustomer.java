package com.cdkglobal.customer;

/**
 * Class which holds the logic to calculate discount according to the defined slab for this Regular customer.
 */
public class RegularCustomer implements ICustomer {

    private static final double FIRST_SLAB_MAX_VALUE = 5000;
    private static final double FIRST_SLAB_DISCOUNT = 0.0d;

    private static final double SECOND_SLAB_MAX_VALUE = 10000;
    private static final double SECOND_SLAB_DISCOUNT = 0.1d;

    private static final double THIRD_SLAB_STARTING_VALUE = 10000;
    private static final double THIRD_SLAB_DISCOUNT = 0.2d;

    /**
     * Hold business logic to calculate Bill Amount according to the discount slab.
     *
     * @param purchaseAmount total purchase amount
     * @return calculated bill amount after applying discount as per slab
     */
    public double calculateBillAmount(final double purchaseAmount) {

        double discount = 0;

        if (purchaseAmount < FIRST_SLAB_MAX_VALUE) {
            discount = FIRST_SLAB_MAX_VALUE * FIRST_SLAB_DISCOUNT;
        } else if (purchaseAmount <= SECOND_SLAB_MAX_VALUE) {
            discount = FIRST_SLAB_MAX_VALUE * FIRST_SLAB_DISCOUNT + (purchaseAmount - FIRST_SLAB_MAX_VALUE) * SECOND_SLAB_DISCOUNT;
        } else if (purchaseAmount > THIRD_SLAB_STARTING_VALUE) {
            discount = FIRST_SLAB_MAX_VALUE * FIRST_SLAB_DISCOUNT + (THIRD_SLAB_STARTING_VALUE - FIRST_SLAB_MAX_VALUE) * SECOND_SLAB_DISCOUNT + (purchaseAmount - 10000) * THIRD_SLAB_DISCOUNT;
        }
        return purchaseAmount - discount;
    }
}
