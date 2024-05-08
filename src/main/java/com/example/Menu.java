package com.example;
import java.time.LocalDate;
import java.util.Scanner;

class Menu {
    public static void userType(Scanner in) {
        System.out.println("Pilih jenis Customer: ");
        System.out.println("=======================");
        System.out.println("1. Guest");
        System.out.println("2. Member");
        System.out.println("3. Daftar Sebagai Member");
        System.out.println("=======================");

        int type = in.nextInt();
        in.nextLine();

        Customer customer;

        switch (type) {
            case 1: TravelFilkom.customer = Guest.guest(in);
            break;
            case 2: Member loggedInMember = Member.memberLogin(in);
                if (loggedInMember != null) {
                    TravelFilkom.customer = loggedInMember;
                }
                break;
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

    public static void orderVehicle(Scanner in, Customer customer, Vehicle[] vehicles, int vehicleCount) {
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

        System.out.print("Masukkan Lama Penyewaan (Jam): ");
        int rentDuration = in.nextInt();
        in.nextLine();

        System.out.print("Masukkan Tanggal Awal Penyewaan (yyyy-mm-dd): ");
        String start = in.nextLine();
        LocalDate startRent = LocalDate.parse(start);

        System.out.print("Masukkan Tanggal Akhir Penyewaan (yyyy-mm-dd): ");
        String end = in.nextLine();
        LocalDate endRent = LocalDate.parse(end);

        Vehicle vehicle = null;

        switch (vehicleType) {
            case 1:
                vehicle = new Car("Mobil", brand, plateNo, price, rentDuration, startRent, endRent);
                break;
            case 2:
                vehicle = new Minibus("Minibus", brand, plateNo, price, rentDuration, startRent, endRent);
                break;
            case 3:
                vehicle = new Bus("Bus", brand, plateNo, price, rentDuration, startRent, endRent);
                break;
            default:
                System.err.println("Pilihan tidak valid");
                return;
        }

        vehicles[TravelFilkom.vehicleCount++] = vehicle;
        System.out.println("\nPesanan berhasil! Terima kasih, " + customer.getFirstName() + "!");

        if(customer instanceof Member) {
            String orderDetails = "Nama Pelanggan: " + customer.getFirstName() + "\nKendaraan: " + vehicle.getVehicleInfo() + "\nLama Penyewaan: " + rentDuration + " jam" + "\nTanggal Awal Penyewaan: " + startRent + "\nTanggal Akhir Penyewaan: " + endRent;
            History.addOrderHistory(orderDetails);

            Order.printDetails(customer, vehicle);
        } else {
            Order.printDetails(customer, vehicle);
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
