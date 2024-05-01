package com.example;

import java.util.Date;


public class Order {

    Date date;
    int orderNumber = 123;    
    double subTotal;
    double shipCost;
    double discounted;
    double total = subTotal + shipCost - discounted;


    public enum Status{
        UNPAID,
        SUCCESSFUL,
        CANCELLED
    }

    public Date getDate() {
        return date;
    }

    public int getOrderNumber() {
        int i = 0;
        i++;
        return i;
    }

    public void printDetails(){
        
    }
            
        

    

    

    
    
        

   

    

    

    


}
