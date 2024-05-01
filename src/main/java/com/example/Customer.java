package com.example;
import java.util.Scanner;

abstract class Customer{
    
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