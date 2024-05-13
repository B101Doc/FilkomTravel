package com.example;

import java.time.LocalDate;
import java.util.*;



public abstract class Customer {
    protected static List<Member> members = new ArrayList<>();
    private static String firstName;
    private static String lastName;
    private static String phoneNumber;
    private static String email;
    private static String district;
    private static boolean hasOrder;

    public Customer(String firstName, String lastName, String phoneNumber, String email) {
        Customer.firstName = firstName;
        Customer.lastName = lastName;
        Customer.phoneNumber = phoneNumber;
        Customer.email = email;
        Customer.hasOrder = false;
    }

    public static void setDistrict(String district) {
        Customer.district = district;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static String getFullName(){
        return firstName + " " + lastName;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static String getDistrict() {
        return district;
    }

    public boolean getHasOrder(){
        return hasOrder;
    }

    public static List<Member> getMembers() {
        return members;
    }



    public void setHasOrder(boolean hasOrder) {
        Customer.hasOrder = hasOrder;
    }


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
        System.out.println("Masukkan alamat kecamatan anda: ");
        System.out.println(Arrays.toString(Order.DistrictCity.values()));
        System.out.println(Arrays.toString(Order.DistrictRegency.values()));
        setDistrict(in.nextLine());


        return new Guest(firstName, lastName, phoneNumber, email);

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
    private static String memberUsername;
    private static String memberPassword;
    private static LocalDate joinedDate;

    public Member(String firstName, String lastName, String phoneNumber, String email, String memberUsername, String memberPassword, LocalDate joinedDate) {
        super(firstName, lastName, phoneNumber, email);
        Member.memberUsername = memberUsername;
        Member.memberPassword = memberPassword;
        Member.joinedDate = joinedDate;
    }

    public static String getMemberUsername() {
        return memberUsername;
    }

    public static String getMemberPassword() {
        return memberPassword;
    }

    public static int getMembershipDuration() {
        long diff = LocalDate.now().toEpochDay() - joinedDate.toEpochDay();
        return (int) (diff / 365);
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public static void registerMember(String firstName, String lastName, String phoneNumber, String email, String username, String password){

        LocalDate now = LocalDate.now();
        String formattedDateJoined = joinedDate.format(Order.formatter);

        storeMemberCredentials(firstName, lastName, phoneNumber, memberUsername, memberPassword, phoneNumber, joinedDate);

        Customer.members.add(new Member(firstName, lastName, phoneNumber, username, password, phoneNumber, joinedDate));
    }

    private static void storeMemberCredentials(String firstName, String lastName, String memberUsername, String memberPassword, String phoneNumber, String email, LocalDate joinedDate){

        System.out.println("Member credentials in database:");
        System.out.println("Full Name: " + getFullName());
        System.out.println("Last Name: " + memberUsername);
        System.out.println("Password: " + memberPassword);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Joined date: " + joinedDate );
        System.out.println("Membership duration: " + getMembershipDuration());
    }


    public static Member loginMember(String emailOrPhone, String password){
        Member member = getMemberByEmailOrPhone(emailOrPhone);

        if (member != null && password.equals(getMemberPassword())){
            return member;
        }
        return null;
    }

   static Member getMemberByEmailOrPhone(String emailOrPhone){
        for (Member member : Customer.members){
            if (member.getEmail().equals(emailOrPhone) || getPhoneNumber().equals(emailOrPhone)){
                return member;
            }
        }
       return null;
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

}