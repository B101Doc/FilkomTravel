package com.example;

interface Applicable {
    boolean isCustomerEligible(Customer customer);
    boolean isMinimumPriceEligible(Order order);
    boolean isShippingFeeEligible(Order order);
    double calculateTotalDiscount(Order order);
    double calculateTotalCashback(Order order);
    double calculateShippingFeeDiscount(Order order);
}
