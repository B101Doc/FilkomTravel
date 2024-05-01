package com.example;
import java.util.Scanner;

public class TravelFilkom {
    static Vehicle[] vehicles = new Vehicle[100];
    static int vehicleCount = 0;
    static Customer customer = null;
    private static Admin admin = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Selamat datang di Filkom Travel App!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("===================================");
            System.out.println("1. Masuk sebagai Admin");
            System.out.println("2. Masuk sebagai Customer");
            System.out.println("3. Lihat kendaraan yang tersedia");
            System.out.println("4. Pesan Kendaraan");
            System.out.println("5. Histori pemesanan (Member Only)");
            System.out.println("6. Keluar");
            System.out.println("===================================");

            int choice = in.nextInt();
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
                        Menu.orderVehicle(in, customer, vehicles, vehicleCount);
                    } else {
                        System.out.println("Pilih jenis pengguna terlebih dahulu!");
                    }
                    break;
                case 5:
                    Member loggedInMember = Member.memberLogin(in);
                    if (loggedInMember != null) {
                        TravelFilkom.customer = loggedInMember;
                        History.displayOrderHistory();
                    }
                    break;
                case 6:
                    return;

            }
        }
    }
}