package com.example;
import java.util.*;


class Admin {

    private String username;

    public Admin(String username) {
        this.username = username;

    }



    public static void addVehicle(Scanner in) {

        System.out.println("\nMenambah Kendaraan:");

        System.out.print("Pilih jenis kendaraan (1. Mobil, 2. Minibus, 3. Bus): ");
        int vehicleType = in.nextInt();
        in.nextLine();

        if (vehicleType == 1) {
            Vehicle.setType("Mobil");
        } else if (vehicleType == 2) {
            Vehicle.setType("Minibus");
        } else if (vehicleType == 3) {
            Vehicle.setType("Bus");
        } else {
            System.err.println("Invalid Vehicle Type");
        }

        System.out.print("Masukkan Merek Kendaraan: ");
        String brand = in.nextLine();
        System.out.print("Masukkan Nomer Plat Kendaraan: ");
        String plateNo = in.nextLine();
        System.out.print("Masukkan Harga Kendaraan: Rp");
        double price = in.nextDouble();

        Vehicle newVehicle = new Vehicle(Vehicle.getType(), brand, plateNo, price);

        double priceNew = in.nextDouble();
        newVehicle.setPrice(priceNew);



        switch (vehicleType) {
            case 1:
                newVehicle = new Car("Mobil", brand, plateNo, price);
                break;
            case 2:
                newVehicle = new Minibus("Minibus", brand, plateNo, price);
                break;
            case 3:
                newVehicle = new Bus("Bus", brand, plateNo, price);
                break;
            default:
                System.err.println("Pilihan invalid.");
                return;
        }

        TravelFilkom.vehicles[TravelFilkom.vehicleCount++] = newVehicle;
        System.out.println("Kendaraan berhasil ditambahkan dengan harga: Rp" + price);
    }

    


    public static void viewCustomerData() {
        System.out.println("\nData Pelanggan:");
        if (TravelFilkom.customer != null) {
            System.out.println("=====================");
            System.out.println("Nama Depan: " + TravelFilkom.customer.getFirstName());
            System.out.println("Nama Belakang: " + TravelFilkom.customer.getLastName());
            System.out.println("Nomor Telepon: " + TravelFilkom.customer.getPhoneNumber());
            System.out.println("Email: " + TravelFilkom.customer.getEmail());
            System.out.println("=====================");
        } else {
            System.out.println("Tidak ada data pelanggan.");
        }
    }
}