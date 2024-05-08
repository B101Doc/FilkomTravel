package com.example;

import java.time.LocalDate;
import java.util.*;



public abstract class Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private boolean hasOrder; 

    public Customer(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hasOrder = false; 
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean getHasOrder(){
        return hasOrder;
    }
    
    public void setHasOrder(boolean hasOrder) {
        this.hasOrder = hasOrder;
    }

    public abstract String getFullName();

    public abstract void makeOrder();

    public abstract void confirmPay(int orderNumber);
}

class Guest extends Customer {
    public Guest(String firstName, String lastName, String phoneNumber, String email){
        super(firstName, lastName, phoneNumber, email);
    }

    public static Guest guest(Scanner in){
        System.out.println("Masukkan nama depan anda: ");
        String firstName = in.nextLine();
        System.out.println("Masukkan nama belakang anda: ");
        String lastName = in.nextLine();
        System.out.println("Masukkan nomor telepon anda: ");
        String phoneNumber = in.nextLine();
        System.out.println("Masukkan nama email anda: ");
        String email = in.nextLine();
        System.out.println("Masukkan alamat anda: ");

        return new Guest(firstName, lastName, phoneNumber, email);
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
    private static String memberUsername;
    private static String memberPassword;
    private LocalDate joinedDate;

    public Member(String firstName, String lastName, String phoneNumber, String email, String memberId, LocalDate joinedDate) {
        super(firstName, lastName, phoneNumber, email);
        this.memberId = memberId;
        this.joinedDate = joinedDate;
    }

    public void MemberLoginInfo(String memberUsername, String memberPassword){
    this.memberUsername = memberUsername;
    this.memberPassword = memberPassword;

    }

    public static Member memberLogin(Scanner in){
        System.out.println("Masukkan Username: ");
        String username = in.nextLine();
        System.out.println("Masukkan Password: ");
        String password = in.nextLine();

        if (username.equals(memberUsername) && password.equals(memberPassword)){
            System.out.println("Login berhasil!");
            return new Member("apa_iyh", "tch", "0812", "dev@" );
        }
        else {
            System.err.println("Username atau password anda salah!");
            return null;
        }
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