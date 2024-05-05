package com.example;

import java.util.Date;


public class Order {

    Date date;
    int orderNumber;    
    double subTotal;
    double shipCost;
    double discounted;
    double total;
    

    public enum Status{
        UNPAID,
        SUCCESSFUL,
        CANCELLED
    }
    

    public Date getDate() {
        return date;
    }

    public  int getOrderNumber() {
        orderNumber = 0;
        orderNumber++;
        return orderNumber;
    }

    public  double getSubTotal(){
        return subTotal;
    }

    public void printDetails(Customer customer, Vehicle vehicle){
        System.out.println("===================================");
        System.out.println("Filkom Travel");
        System.out.println("Jl. Perjuangan Masih Panjang");
        System.out.println("");
        System.out.println("Nama Pelanggan: ");
        
        int n = 1;    
        while (orderNumber<n) { 
            System.out.println();            
            n++;
        }        
        System.out.println("___________________________________");
        System.out.println();

        
    }
            
        

    

    

    
    
        

   

    

    

    


}
