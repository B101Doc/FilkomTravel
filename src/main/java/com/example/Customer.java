package com.example;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class customer{

    protected String firstName = null;
    protected String lastName = null;
    


    protected customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    
    }

    public abstract void getFullName();
    public static abstract void makeOrder();
    public abstract void confirmPay();
   
}

class Guest extends customer{

    public Guest(String firstName, String lastName) {
        super(firstName, lastName);
    }



   @Override
   public void getFullName(){
    if(lastName != null){
        System.out.println("Customer Name: " + getFirstName() + " " + getLastName());
    }
    else{
        System.out.println("Customer Name: " + getFirstName());
    }
   }

   @Override
   public static void makeOrder() {
       Order.getOrderNumber();
       
   }

}

 class Member extends customer{
    private String memberId;
    private LocalDate joinedDate;

    private Member(String firstName, String lastName, String memberId, LocalDate joinedDate){
        super(firstName, lastName);
        this.memberId = memberId;
        this.joinedDate = joinedDate;
    }

    private LocalDate getJoinedDate() {
        return joinedDate;
    }

    public static Guest guest(Scanner in){
        
    }
    

    @Override
    public void getFullName(){
        if (getLastName() != null){
            System.out.println("Customer Name: " + getFirstName() + " " + getLastName());
        }
        else{
            System.out.println("Customer Name: " + getFirstName());
        }
    }

    
}

    
    

 
// class Customer {
//     private String firstName;
//     private String lastName;
//     private String id;
//     private String phoneNumber;
//     private String email;

//     public Customer(String firstName, String lastName, String id, String phoneNumber, String email) {
//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.id = id;
//         this.phoneNumber = phoneNumber;
//         this.email = email;
//     }

//     public String getFirstName() {
//         return firstName;
//     }

//     public String getLastName() {
//         return lastName;
//     }    

//     public String getId() {
//         return id;
//     }

//     public String getPhoneNumber() {
//         return phoneNumber;
//     }

//     public String getEmail() {
//         return email;
//     }
// }

// class Guest extends Customer {
//     public Guest(String firstName, String lastName, String id, String phoneNumber, String email) {
//         super(firstName, lastName, id, phoneNumber, email);
//     }

//     public static Guest guest(Scanner in) {
//         System.out.print("Masukkan nama depan anda: ");
//         String firstName = in.nextLine();
//         System.out.println("Masukkan nama belakang anda: ");
//         String lastName = in.next();
//         System.out.print("Masukkan ID: ");
//         String id = in.nextLine();
//         System.out.print("Masukkan Nomor Telepon: ");
//         String phoneNumber = in.nextLine();
//         System.out.print("Masukkan Email: ");
//         String email = in.nextLine();
//         return new Guest(firstName, lastName, id, phoneNumber, email);
//     }
// }

// class Member extends Customer {
//     private static final String memberUsername = "apa_iyh";
//     private static final String memberPassword = "tch";

//     public Member(String firstName, String lastName, String id, String phoneNumber, String email) {
//         super(firstName, lastName, id, phoneNumber, email);
//     }

//     public static Member memberLogin(Scanner in) {
//         System.out.print("Masukkan Username: ");
//         String username = in.nextLine();
//         System.out.print("Masukkan Password: ");
//         String password = in.nextLine();

//         if (username.equals(memberUsername) && password.equals(memberPassword)) {
//             System.out.println("Login berhasil!");
//             return new Member("apa_iyh", "tch", "0812", "dev@");
//         } else {
//             System.out.println("Username atau password salah!");
//             return null;
//         }
//     }
// }