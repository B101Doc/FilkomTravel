package com.example;
import com.example.GUI.StartGUI;

import javax.swing.*;
import java.util.*;

public class TravelFilkom extends JFrame {
    static Map<String, Member> loggedInMembers = new HashMap<>();
    static Vehicle[] vehicles = new Vehicle[100];
    static int vehicleCount = 0;
    static int choice;
    static Customer customer = null;
    private static Admin admin = null;


    public static void main(String[] args) {
        boolean isRunning = true;
        Scanner in = new Scanner(System.in);

        StartGUI start = new StartGUI();
        start.setContentPane(start.mainPanel);
        start.setTitle("Filkom Travel");
        start.setSize(400, 500);
        start.setVisible(true);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        System.out.println("Selamat datang di Filkom Travel App!");

        while (isRunning) {
            System.out.println("\nMenu:");
            System.out.println("===================================");
            System.out.println("1. Masuk sebagai Admin");
            System.out.println("2. Masuk sebagai Customer");
            System.out.println("3. Lihat kendaraan yang tersedia");
            System.out.println("4. Pesan Kendaraan");
            System.out.println("5. Histori pemesanan (Member Only)");
            System.out.println("6. Keluar");
            System.out.println("===================================");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    if (admin == null) {
                        admin = Menu.adminLogin(in);
                        if (admin != null) {
                            Menu.adminMenu(in, customer);
                            admin = null;
                        }
                    } else {
                        System.out.println("Anda sudah login sebagai admin.");
                    }
                    break;
                case 2:
                    Menu.userType(in);
                    break;
                case 3:
                    Menu.displayVehicles();
                    break;
                case 4:
                    if (customer != null) {
                        Menu.orderVehicle(in);
                    } else {
                        System.out.println("Pilih jenis pengguna terlebih dahulu!");
                    }
                    break;
                case 5:
                    Menu.loginMember(in);
                    break;
                case 6:
                    isRunning = false;
                    in.close();
                break;
                default:
                    System.err.println("Pilihan anda salah!");
                    return;


            }
        }
    }
}