## Shopping Cart Assignment

As per provided definition, only regular customer is considered.
But solution designed in a way that new customer type and its discount slab can be easily incorporated
without changing existing customer type related classes.

Key Points
----------
1. Main.java class can be used as a client to test various use cases.
   Run this class and provide required input values to calculate result.
2. RegularCustomer class contains business logic to calculate discount according to the slab for the Regular Customer.
3. To introduce new customer type, its slab and discount calculation follow below steps:
    3.1 Create new class under package com.cdkglobal.customer with name relevant to new customer type.
        Example: VIPCustomer.java
    3.2 New class must implements ICustomer interface hence need to override only method in interface.
    3.3 In that method, write the business logic to calculate discount on purchase amount and to generate bill amount.
4. CustomerFactory class is designed by following factory pattern to get class object based on the customer type. So on
   addition of new customer type, require to add code to generate and return specific object.



