package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Order {

    LocalDate dateOrdered;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mmmm-yyyy");
    String formattedDateOrdered = dateOrdered.format(formatter);
    int orderNumber;
    double subTotal;
    double shipCost;
    double discount;

    public String getFormattedDateOrdered() {
        return formattedDateOrdered;
    }

    public  double getSubTotal(){
        return subTotal;
    }

    public double getTotal() {
        return subTotal + shipCost - getDiscountTotal();
    }

    public double getShipCost() {
        return shipCost;
    }

    public double getDiscountTotal() {
        return subTotal * discount;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public enum Status{
        UNPAID,
        SUCCESSFUL,
        CANCELLED
    }

    public enum District{
            Blimbing,
            Kedungkandang,
            Klojen,
            Lowokwaru,
            Sukun,
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

    ;
    }
    
    

    public  int getOrderNumber() {
        orderNumber = 0;
        orderNumber++;
        return orderNumber;
    }



    public void checkOut(){
    }

    public void printDetails(Customer customer, Vehicle vehicle){
        if (customer instanceof Member) {
            System.out.println("\nFilkom Travel");
            System.out.println("\nJl. Yang Lurus");
            System.out.println(formattedDateOrdered);
            System.out.println("===========================");
            System.out.println("Nama Pelanggan: " + customer.getFullName());        
            System.out.println("Kendaraan yang Dipesan: " + vehicle.getVehicleInfo());
            System.out.println("Lama Penyewaan (Jam): " + vehicle.getRentDuration());
            System.out.println("Tanggal Awal Penyewaan: " + vehicle.getStartRent());
            System.out.println("Tanggal Akhir Penyewaan: " + vehicle.getEndRent());
            System.out.println("---------------------------");
            System.out.println("Total Harga: Rp " + (vehicle.getPrice() * vehicle.getRentDuration() - (vehicle.getPrice() * vehicle.getRentDuration() * 20/100)));
            System.out.println("===========================");
        } else if (customer instanceof Guest) {
            System.out.println("\nNota Pembayaran:");
            System.out.println("===========================");
            System.out.println("Nama Pelanggan: " + customer.getFullName());            
            System.out.println("Kendaraan yang Dipesan: " + vehicle.getVehicleInfo());
            System.out.println("Lama Penyewaan (Jam): " + vehicle.getRentDuration());
            System.out.println("Tanggal Awal Penyewaan: " + vehicle.getStartRent());
            System.out.println("Tanggal Akhir Penyewaan: " + vehicle.getEndRent());
            System.out.println("---------------------------");
            System.out.println("Total Harga: Rp " + (vehicle.getPrice() * vehicle.getRentDuration()));
            System.out.println("===========================");
        } else {
            System.err.println("Data yang anda masukkan tidak valid!");
        }
    }
            
        

    

    

    
    
        

   

    

    

    


}
