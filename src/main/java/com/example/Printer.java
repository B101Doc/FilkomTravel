package com.example;

public class Printer {

    public static void printReceipt(Customer customer, Vehicle vehicle) {
        if (customer instanceof Member) {
            System.out.println("\nNota Pembayaran:");
            System.out.println("===========================");
            System.out.println("Nama Pelanggan: " + customer.getFirstName());
            System.out.println("ID Pelanggan: " + customer.getId());
            System.out.println("Kendaraan yang Dipesan: " + vehicle.getVehicleInfo());
            System.out.println("Lama Penyewaan (Jam): " + vehicle.getRentDuration());
            System.out.println("Tanggal Awal Penyewaan: " + vehicle.getStartRent());
            System.out.println("Tanggal Akhir Penyewaan: " + vehicle.getEndRent());
            System.out.println("---------------------------");
            System.out.println("Total Harga: Rp " + (vehicle.getPrice() * vehicle.getRentDuration() - (vehicle.getPrice() * vehicle.getRentDuration() * 20/100)));
            System.out.println("===========================");
        } else {
            System.out.println("\nNota Pembayaran:");
            System.out.println("===========================");
            System.out.println("Nama Pelanggan: " + customer.getFirstName());
            System.out.println("ID Pelanggan: " + customer.getId());
            System.out.println("Kendaraan yang Dipesan: " + vehicle.getVehicleInfo());
            System.out.println("Lama Penyewaan (Jam): " + vehicle.getRentDuration());
            System.out.println("Tanggal Awal Penyewaan: " + vehicle.getStartRent());
            System.out.println("Tanggal Akhir Penyewaan: " + vehicle.getEndRent());
            System.out.println("---------------------------");
            System.out.println("Total Harga: Rp " + (vehicle.getPrice() * vehicle.getRentDuration()));
            System.out.println("===========================");
        }
    }
}