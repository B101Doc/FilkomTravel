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
    protected double promoShipCost;


    public Promotion(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent, double promoShipCost) {
        this.promoCode = promoCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumOrderTotal = minimumOrderTotal;
        this.discountPercent = discountPercent;
        this.promoShipCost = promoShipCost;
    }


    public double getPromoShipCost() {
        return promoShipCost;
    }

    public void setPromoShipCost(double promoShipCost) {
        this.promoShipCost = promoShipCost;
    }

    @Override
    public int compareTo(Promotion promo) {
        return Double.compare(this.calculateDiscount(), promo.calculateDiscount());
    }

    @Override
    public boolean isCustomerEligible(Customer customer) {
        if (customer instanceof Member) {
            int membershipDuration = Member.getMembershipDuration();
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


    public PercentOffPromo(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent, double promoShipCost) {
        super(promoCode, startDate, endDate, minimumOrderTotal, discountPercent, promoShipCost);
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
    public Cashback(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent, double promoShipCost) {
        super(promoCode, startDate, endDate, minimumOrderTotal, discountPercent, promoShipCost);
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

    public DeliveryFeePromo(String promoCode, Date startDate, Date endDate, double minimumOrderTotal, double discountPercent, double promoShipCost) {
        super(promoCode, startDate, endDate, minimumOrderTotal, discountPercent, promoShipCost);
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
    public double calculateShippingFeeDiscount(Order order, Member member, Customer customer) {
        if(order.getShipCost() == 10000 && customer instanceof Member){
            promoShipCost = 5000;
        } else if (order.getShipCost() == 20000 && customer instanceof Member) {
            promoShipCost = 7500;
        }
        return 0;
    }
}
