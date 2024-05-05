package com.example;
import java.time.LocalDate;



public abstract class Customer {
    private String firstName;
    private String lastName;
    private boolean hasOrder; 

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasOrder = false; 
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getHasOrder(){
        return hasOrder;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setHasOrder(boolean hasOrder) {
        this.hasOrder = hasOrder;
    }

    public abstract String getFullName();

    public abstract void makeOrder();

    public abstract void confirmPay(int orderNumber);
}

class Guest extends Customer {
    public Guest(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public String getFullName() {
        if (getLastName() != null) {
            return "Customer Name: " + getFirstName() + " " + getLastName();
        } else {
            return "Customer Name: " + getFirstName();
        }
    }

    @Override
    public void makeOrder() {
        if (!getHasOrder()) {
            System.out.println("Guest makes an order");
            setHasOrder(true);
        } else {
            System.out.println("Guest already has an active order.");
        }
    }

    @Override
    public void confirmPay(int orderNumber) {
        if (getHasOrder()) {
            System.out.println("Guest confirms payment for order " + orderNumber);
            setHasOrder(false); 
        } else {
            System.out.println("Guest has no active order to confirm payment.");
        }
    }
}

class Member extends Customer {
    private String memberId;
    private LocalDate joinedDate;

    public Member(String firstName, String lastName, String memberId, LocalDate joinedDate) {
        super(firstName, lastName);
        this.memberId = memberId;
        this.joinedDate = joinedDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    @Override
    public String getFullName() {
        if (getLastName() != null) {
            return "Customer Name: " + getFirstName() + " " + getLastName();
        } else {
            return "Customer Name: " + getFirstName();
        }
    }

    @Override
    public void makeOrder() {
        if (!getHasOrder()) {
            System.out.println("Member makes an order");
            setHasOrder(true); 
        } else {
            System.out.println("Member already has an active order.");
        }
    }

    @Override
    public void confirmPay(int orderNumber) {
        if (getHasOrder()) {
            System.out.println("Member confirms payment for order " + orderNumber);
            setHasOrder(false);
        } else {
            System.out.println("Member has no active order to confirm payment.");
        }
    }

    public int getMembershipDuration() {
        long diff = LocalDate.now().toEpochDay() - joinedDate.toEpochDay();
        return (int) (diff / 365);
    }
}