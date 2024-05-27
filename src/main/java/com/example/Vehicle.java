package com.example;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Vehicle {
    private static String type;
    private String brand;
    private String plateNo;
    private double price;
    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private long rentDuration;


    public Vehicle(String type, String brand, String plateNo, double price, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, long rentDuration) {
        this.type = type;
        this.brand = brand;
        this.plateNo = plateNo;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentDuration = rentDuration;
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

    public long getRentDuration() {
        LocalDateTime startDateTime = LocalDateTime.of(getStartDate(), getStartTime());
        LocalDateTime endDateTime = LocalDateTime.of(getEndDate(), getEndTime());
        Duration duration = Duration.between(startDateTime, endDateTime);
        return rentDuration = duration.toHours();
    }

    public LocalDate getStartDate() {
        return startDate = LocalDate.parse(Menu.getStartDateStr(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate getEndDate() {
        return endDate = LocalDate.parse(Menu.getEndDateStr(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalTime getStartTime() {
        return startTime = LocalTime.parse(Menu.getStartTimeStr());
    }
    public LocalTime getEndTime() {
        return endTime = LocalTime.parse(Menu.getEndTimeStr());
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Vehicle.type = type;
    }
}

class Car extends Vehicle {
    public Car(String type, String brand, String plateNo, double price) {
        super(type, brand, plateNo, price);
    }

    public Car(String type, String brand, String plateNo, double price, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, long rentDuration) {
        super(type, brand, plateNo, price, startDate, startTime, endDate, endTime, rentDuration);
    }

    @Override
    public String getVehicleInfo() {
        return "\n---------------------------" + "\nMerek Mobil  " + getBrand() + "\nNomor Plat " + getPlateNo() + "\nHarga per jam " + getPrice() + "\n---------------------------";
    }
}

class Minibus extends Vehicle {
    public Minibus(String type, String brand, String plateNo, double price) {
        super(type, brand, plateNo, price);
    }

    public Minibus(String type, String brand, String plateNo, double price, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, long rentDuration) {
        super(type, brand, plateNo, price, startDate, startTime, endDate, endTime, rentDuration);
    }

    @Override
    public String getVehicleInfo() {
        return "\n---------------------------" + "\nMerek Minibus  " + getBrand() + "\nNomor Plat " + getPlateNo() + "\nHarga per jam " + getPrice() + "\n---------------------------";
    }
}

class Bus extends Vehicle {
    public Bus(String type, String brand, String plateNo, double price) {
        super(type, brand, plateNo, price);
    }

    public Bus(String type, String brand, String plateNo, double price, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, long rentDuration) {
        super(type, brand, plateNo, price, startDate, startTime, endDate, endTime, rentDuration);
    }

    @Override
    public String getVehicleInfo() {
        return "\n---------------------------" + "\nMerek Bus  " + getBrand() + "\nNomor Plat " + getPlateNo() + "\nHarga per jam " + getPrice() + "\n---------------------------";
    }
}
