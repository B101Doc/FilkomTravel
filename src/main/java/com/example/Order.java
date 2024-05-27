package com.example;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;


public class Order {

   protected static LocalDate dateOrdered;
   protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
   protected static String formattedDateOrdered = dateOrdered.format(formatter);
   protected int orderNumber;
   protected static double subTotal;
   protected static double shipCost;
   protected static double discount;


    public  double getSubTotal(){
        return subTotal;
    }


    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return subTotal + shipCost - getDiscountTotal();
    }

    public static double getShipCost() {
            if(Customer.getDistrict().equalsIgnoreCase(Arrays.toString(DistrictCity.values()))){
                return shipCost = 10000;
            } else if (Customer.getDistrict().equalsIgnoreCase(Arrays.toString(DistrictRegency.values()))) {
                return shipCost = 20000;
            }
            else {
                System.err.println("Kecamatan tidak ditemukan!");
                System.err.println("Hanya menerima pengantaran di Malang!");
            }

        return shipCost;
    }

    public static double getDiscountTotal() {
        return subTotal * discount;
    }

    public enum Status{
        UNPAID,
        SUCCESSFUL,
        CANCELLED
    }

    public enum DistrictCity {
            Blimbing,
            Kedungkandang,
            Klojen,
            Lowokwaru,
            Sukun
    }

    public enum DistrictRegency {
        Ampelgading,
        Bantur,
        Bululawang,
        Dampit,
        Dau,
        Donomulyo,
        Gedangan,
        Gondanglegi,
        Jabung,
        Kalipare,
        Karangploso,
        Kasembon,
        Kepanjen,
        Kromengan,
        Lawang,
        Ngajum,
        Ngantang,
        Pagak,
        Pagelaran,
        Pakis,
        Ppakisaji,
        Poncokusumo,
        Pujon,
        Singosari,
        SumbermanjingWetan,
        Sumberpucung,
        Tajinan,
        Tirtoyudo,
        Tumpang,
        Turen,
        Wagir,
        Wajak,
        Wonosari
    }
    
    

    public  int getOrderNumber() {
        orderNumber = 0;
        orderNumber++;
        return orderNumber;
    }



    public void checkOut(){
    }

    public static void printDetails(Customer customer, Vehicle vehicle){
        if (customer instanceof Member) {
            System.out.println("\nFilkom Travel");
            System.out.println("\nJl. Yang Lurus");
            System.out.println(formattedDateOrdered);
            System.out.println("===========================");
            System.out.println("Nama Pelanggan: " + customer.getFullName());
            System.out.println("Kendaraan yang Dipesan: " + vehicle.getVehicleInfo());
            System.out.println("Tanggal Awal Penyewaan: " + vehicle.getStartDate());
            System.out.println("Waktu Awal Penyewaan: " + vehicle.getStartTime());
            System.out.println("Tanggal Akhir Penyewaan: " + vehicle.getEndDate());
            System.out.println("Waktu Akhir Penyewaan: " + vehicle.getEndTime());
            System.out.println("Lama Penyewaan (Jam): " + vehicle.getRentDuration());
            System.out.println("---------------------------");
            System.out.println("Total Harga: Rp " + (vehicle.getPrice() * vehicle.getRentDuration() - (vehicle.getPrice() * vehicle.getRentDuration() * 20/100)));
            System.out.println("===========================");
        } else if (customer instanceof Guest) {
            System.out.println("\nNota Pembayaran:");
            System.out.println("===========================");
            System.out.println("Nama Pelanggan: " + customer.getFullName());
            System.out.println("Kendaraan yang Dipesan: " + vehicle.getVehicleInfo());
            System.out.println("Tanggal Awal Penyewaan: " + vehicle.getStartDate());
            System.out.println("Waktu Awal Penyewaan: " + vehicle.getStartTime());
            System.out.println("Tanggal Akhir Penyewaan: " + vehicle.getEndDate());
            System.out.println("Waktu Akhir Penyewaan: " + vehicle.getEndTime());
            System.out.println("Lama Penyewaan (Jam): " + vehicle.getRentDuration());
            System.out.println("---------------------------");
            System.out.println("Biaya Ongkir: " + getShipCost());
            System.out.println("Total Harga: Rp " + (vehicle.getPrice() * vehicle.getRentDuration()) + getShipCost());
            System.out.println("===========================");
        } else {
            System.err.println("Data yang anda masukkan tidak valid!");
        }
    }
            
        

    

    

    
    
        

   

    

    

    


}
