package com.project;

import java.util.Scanner;

public class AirAsia extends Airlines {
    String name;
    int age;
    String gender;
    String emailId;
    long mobNo;
    long aadharNo;

    Scanner sc = new Scanner(System.in);

    AirAsia() {
        super();
    }

    void bookAirAsia() {
        System.out.println("Vaccinated or Not?");
        String confirmation = sc.next();
        if (confirmation.equalsIgnoreCase("Yes")) {
            System.out.println("Welcome to AirAsia!");
            bookArrival();

            System.out.print("Enter Name: ");
            this.name = sc.next();
            System.out.print("Enter Age: ");
            this.age = sc.nextInt();
            System.out.print("Enter Gender: ");
            this.gender = sc.next();
            System.out.print("Enter EmailId: ");
            this.emailId = sc.next();
            System.out.print("Enter MobileNo: ");
            this.mobNo = sc.nextLong();
            System.out.print("Enter Aadhar Number: ");
            this.aadharNo = sc.nextLong();

            DBUtil.saveBooking("AirAsia", name, age, gender, emailId, mobNo, aadharNo,
                    departure, arrivalDestination, date);

        } else {
            System.out.println("❌ Cannot Book Ticket. Please get vaccinated first!");
        }
    }

    boolean cancelBooking() {
        System.out.print("Enter your Booked Mobile Number: ");
        long enteredMobNo = sc.nextLong();
        DBUtil.cancelBooking(enteredMobNo);   // ✅ matches DBUtil
        return true;
    }

    void changeDate() {
        System.out.print("Enter your Booked Mobile Number: ");
        long enteredMobNo = sc.nextLong();
        System.out.print("Enter New Date (YYYY-MM-DD): ");
        String changedDate = sc.next();
        DBUtil.changeDate(enteredMobNo, changedDate);   // ✅ matches DBUtil
    }

    void displayTicket() {
        System.out.print("Enter your Booked Mobile Number: ");
        long enteredMobNo = sc.nextLong();
        DBUtil.displayBooking(enteredMobNo);   // ✅ matches DBUtil
    }
}
