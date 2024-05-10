package com.example;

import java.util.Date;

abstract class Promotion implements Applicable, Comparable<Promotion> {
    protected String promoCode;
    protected Date startDate;
    protected Date endDate;

    public Promotion(String promoCode, Date startDate, Date endDate) {
        this.promoCode = promoCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public int compareTo(Promotion promo) {
        return Double.compare(this.calculateDiscount(), promo.calculateDiscount());
    }

    @Override
    public boolean isCustomerEligible(Customer customer) {
        if (customer instanceof Member) {
            Member member = (Member) customer;
            int membershipDuration = member.getMembershipDuration();
            return membershipDuration > 30;
        }
        return false;
    }

    @Override
    public boolean isMinimumPriceEligible(Order order) {
        double subtotal = order.getSubTotal();

        return false;
    }

    public abstract double calculateDiscount();

    @Override
    public boolean isShippingFeeEligible(Order order) {
        double shipFee = order.getShipCost();

        return false;
    }
}

class PercentOffPromo extends Promotion
{

}

class Cashback extends Promotion
{

}

class DeliveryFeePromo extends Promotion
{

}
