package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class Promotion implements Applicable, Comparable<Promotion> {
    protected String promoCode;
    protected Date startDate;
    protected Date endDate;
    protected double minimumOrderTotal;
    protected double discountPercent;


    public Promotion(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent) {
        this.promoCode = promoCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumOrderTotal = minimumOrderTotal;
        this.discountPercent = discountPercent;
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
        if (shipFee > 10000) {
            return true;
        } else {
            return false;
        }
    }
}

class PercentOffPromo extends Promotion
{


    public PercentOffPromo(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent) {
        super(promoCode, startDate, endDate, minimumOrderTotal, discountPercent);
    }

    @Override
    public double calculateTotalDiscount(Order order){

        return 0;
    }
    @Override
    public double calculateTotalCashback(Order order) {
        return 0;
    }

    @Override
    public double calculateShippingFeeDiscount(Order order) {
        return 0;
    }

    @Override
    public double calculateDiscount() {
        return 0;
    }
}

class Cashback extends Promotion
{
    public Cashback(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent) {
        super(promoCode, startDate, endDate, minimumOrderTotal, discountPercent);
    }

    @Override
    public double calculateTotalDiscount(Order order) {
        return 0;
    }

    @Override
    public double calculateTotalCashback(Order order) {

        return 0;
    }

    @Override
    public double calculateShippingFeeDiscount(Order order) {
        return 0;
    }

    @Override
    public double calculateDiscount() {
        return 0;
    }
}

class DeliveryFeePromo extends Promotion
{
    public static List<Promotion> promotions = new ArrayList<Promotion>();

    public DeliveryFeePromo(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent) {
        super(promoCode, startDate, endDate, minimumOrderTotal, discountPercent);
    }


    @Override
    public double calculateDiscount() {
        return 0;
    }

    @Override
    public double calculateTotalDiscount(Order order) {
        return 0;
    }

    @Override
    public double calculateTotalCashback(Order order) {
        return 0;
    }

    @Override
    public double calculateShippingFeeDiscount(Order order) {
        return 0;
    }
}
