package com.example;
import java.time.LocalDate;

class Vehicle {
    private String type;
    private String brand;
    private String plateNo;
    private double price;
    private int rentDuration;
    private LocalDate startRent;
    private LocalDate endRent;


    public Vehicle() {
    }

    public Vehicle(String type, String brand, String plateNo, double price, int rentDuration, LocalDate startRent, LocalDate endRent) {
        this.type = type;
        this.brand = brand;
        this.plateNo = plateNo;
        this.price = price;
        this.rentDuration = rentDuration;
        this.startRent = startRent;
        this.endRent = endRent;
    }

    public Vehicle(String type, String brand, String plateNo, double price) {
        this.type = type;
        this.brand = brand;
        this.plateNo = plateNo;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public String getVehicleInfo() {
        return "Jenis: " + type + "\nMerek: " + brand + "/nNomer Plat: " + plateNo;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public LocalDate getStartRent() {
        return startRent;
    }

    public LocalDate getEndRent() {
        return endRent;
    }
}

class Car extends Vehicle {

    public Car(String type, String brand, String plateNo, double price, int rentDuration, LocalDate startRent, LocalDate endRent) {
        super(type, brand, plateNo, price, rentDuration, startRent, endRent);
    }

    public Car(String type, String brand, String plateNo, double price) {
        super(type, brand, plateNo, price);
    }


    @Override
    public String getVehicleInfo() {
        return "\n---------------------------" + "\nMerek Mobil  " + getBrand() + "\nNomor Plat " + getPlateNo() + "\nHarga per jam " + getPrice() + "\n---------------------------";
    }
}

class Minibus extends Vehicle {

    public Minibus(String type, String brand, String plateNo, double price, int rentDuration, LocalDate startRent, LocalDate endRent) {
        super(type, brand, plateNo, price, rentDuration, startRent, endRent);
    }

    public Minibus(String type, String brand, String plateNo, double price) {
        super(type, brand, plateNo, price);
    }

    @Override
    public String getVehicleInfo() {
        return "\n---------------------------" + "\nMerek Minibus  " + getBrand() + "\nNomor Plat " + getPlateNo() + "\nHarga per jam " + getPrice() + "\n---------------------------";
    }
}

class Bus extends Vehicle {

    public Bus(String type, String brand, String plateNo, double price, int rentDuration, LocalDate startRent, LocalDate endRent) {
        super(type, brand, plateNo, price, rentDuration, startRent, endRent);
    }

    public Bus(String type, String brand, String plateNo, double price) {
        super(type, brand, plateNo, price);
    }

    @Override
    public String getVehicleInfo() {
        return "\n---------------------------" + "\nMerek Bus  " + getBrand() + "\nNomor Plat " + getPlateNo() + "\nHarga per jam " + getPrice() + "\n---------------------------";
    }
}
