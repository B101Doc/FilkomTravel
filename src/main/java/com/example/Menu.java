package com.example;
import java.util.Arrays;
import java.util.Scanner;

import static com.example.TravelFilkom.*;

class Menu {
    static String startDateStr, startTimeStr, endDateStr, endTimeStr;

    public static String getStartDateStr() {return startDateStr;}
    public static String getStartTimeStr() {return startTimeStr;}
    public static String getEndDateStr() {return endDateStr;}
    public static String getEndTimeStr() {return endTimeStr;}

    public static void userType(Scanner in) {
        System.out.println("=======================");
        System.out.println("1. Masuk sebagai Guest");
        System.out.println("2. Masuk sebagai Member");
        System.out.println("3. Daftar Sebagai Member");
        System.out.println("=======================");

        int type = in.nextInt();
        in.nextLine();


        switch (type) {
            case 1: customer = Guest.guest(in);
                    orderVehicle(in);
            break;
            case 2: loginMember(in);
                break;
            case 3: registerMember(in);
            default : System.out.println("Pilihan tidak valid");
            break;
        }
    }


    public static void displayVehicles() {
        System.out.println("\nKendaraan yang tersedia:");

        for (int i = 0; i < TravelFilkom.vehicleCount; i++) {
            System.out.println(TravelFilkom.vehicles[i].getVehicleInfo());
        }
    }

    public static void orderVehicle(Scanner in) {
        System.out.println("\nPilih jenis kendaraan:");
        System.out.println("=======================");
        System.out.println("1. Mobil");
        System.out.println("2. Minibus");
        System.out.println("3. Bus");
        System.out.println("=======================");

        int vehicleType = in.nextInt();
        in.nextLine();

        System.out.print("Masukkan Merek Kendaraan: ");
        String brand = in.nextLine();
        System.out.print("Masukkan Nomer Plat Kendaraan: ");
        String plateNo = in.nextLine();

        System.out.print("Masukkan Harga Kendaraan per Jam: Rp");
        double price = in.nextDouble();

        System.out.println("Masukkan Tanggal Awal Penyewaan (dd-mm-yyyy): ");
        startDateStr = in.next();

        System.out.println("Masukan Waktu Awal Penyewaan (HH) ");
        startTimeStr = in.next();

        System.out.println("Masukkan Tanggal Pengembalian (dd-mm-yyyy): ");
        endDateStr = in.next();

        System.out.println("Masukkan Waktu Pengembalian (HH): ");
        endTimeStr = in.nextLine();

        Vehicle vehicle;

        switch (vehicleType) {
            case 1:
                vehicle = new Car("Mobil", brand, plateNo, price);
                break;
            case 2:
                vehicle = new Minibus("Minibus", brand, plateNo, price);
                break;
            case 3:
                vehicle = new Bus("Bus", brand, plateNo, price);
                break;
            default:
                System.err.println("Pilihan tidak valid");
                return;
        }

        vehicles[TravelFilkom.vehicleCount++] = vehicle;
        System.out.println("\nPesanan berhasil! Terima kasih, " + customer.getFirstName() + "!");

        if(customer instanceof Member) {
            String orderDetails = "Nama Pelanggan: " + customer.getFirstName() + "\nKendaraan: " + vehicle.getVehicleInfo() + "\nLama Penyewaan: " + vehicle.getRentDuration() + " jam" + "\nTanggal Awal Penyewaan: " + vehicle.getStartDate() + "\nWaktu Awal Penyewaan: " + vehicle.getStartTime() + "\nTanggal Akhir Penyewaan: " + vehicle.getEndDate() + "\nWaktu Akhir Penyewaan: " + vehicle.getEndTime();
            History.addOrderHistory(orderDetails);

            Order.printDetails(customer, vehicle);
        } else {
            Order.printDetails(customer, vehicle);
        }

    }

    public static void registerMember(Scanner in) {
        System.out.println("=======================");
        System.out.println("Masukkan nama depan anda:");
        String firstName = in.nextLine();
        System.out.println("Masukkan nama belakang anda: ");
        String lastName = in.nextLine();
        System.out.println("Masukkan nomor telepon anda: ");
        String phoneNumber = in.nextLine();
        System.out.println("Masukkan alamat email anda");
        String email = in.nextLine();
        System.out.println("Masukkan alamat kecamatan anda");
        System.out.println(Arrays.toString(Order.DistrictCity.values()));
        System.out.println(Arrays.toString(Order.DistrictRegency.values()));
        Customer.setDistrict(in.nextLine());
        System.out.println("Masukkan username anda: ");
        String username = in.nextLine();
        System.out.println("Masukkan password anda: ");
        String password = in.nextLine();

        Member.registerMember(firstName, lastName, phoneNumber, email, username, password);
    }
    public static void loginMember(Scanner in){
        System.out.println("Masukkan Email atau Username:");
        String emailOrPhone = in.nextLine();
        System.out.println("Masukkan Password:");
        String password = in.nextLine();

        Member member = Member.loginMember(emailOrPhone, password);

        if (member != null) {
            TravelFilkom.loggedInMembers.put(Member.getMemberUsername(), member);
            System.out.println("Login berhasil!");
            if (TravelFilkom.choice == 5){
                History.displayOrderHistory();
            } else if (TravelFilkom.choice == 2) {
                orderVehicle(in);
            }
            else {
                System.err.println("Pilihan tidak valid!");
            }
        }
        else {
            System.err.println("Email atau password tidak valid");
        }
    }

    public static Admin adminLogin(Scanner in) {
        System.out.print("Masukkan Username Admin: ");
        String username = in.nextLine();
        System.out.print("Masukkan Password Admin: ");
        String password = in.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login berhasil sebagai admin!");
            return new Admin(username);
        } else {
            System.out.println("Username atau password salah!");
            return null;
        }
    }

    public static void adminMenu(Scanner in, Customer customer) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\nMenu Admin:");
            System.out.println("===================================");
            System.out.println("1. Tambah Kendaraan dan Atur Harga");
            System.out.println("2. Lihat Data Pelanggan");
            System.out.println("3. Keluar (Logout)");
            System.out.println("===================================");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1: Admin.addVehicle(in);
                break;
                case 2: Admin.viewCustomerData();
                break;
                case 3: System.out.println("Logout berhasil!");
                           logout = true;
                           break;
            }
        }
    }
}
