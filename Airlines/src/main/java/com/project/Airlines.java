package com.project;

import java.util.Scanner;

public class Airlines {
    private int id;
    private String name;
    private String source;
    private String destination;
    private double price;

    protected String departure;
    protected String arrivalDestination;
    protected String date;

    public Airlines() {
        // default constructor for child classes
    }

    public Airlines(String name, String source, String destination, double price) {
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    // getters & setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSource(String source) { this.source = source; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setPrice(double price) { this.price = price; }

    // Common method for all airlines
    public void bookArrival() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Departure: ");
        departure = sc.next();
        System.out.println("Enter Destination: ");
        arrivalDestination = sc.next();
        System.out.println("Enter Journey Date(YYYY-MM-DD): ");
        date = sc.next();
    }
}
