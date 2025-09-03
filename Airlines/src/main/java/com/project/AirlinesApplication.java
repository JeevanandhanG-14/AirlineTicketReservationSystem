package com.project;


import java.util.Scanner;

public class AirlinesApplication {
    public static void main(String[] args) {
        Scanner choosing = new Scanner(System.in);

        AirIndia india1 = null;
        AirAsia asia1 = null;
        Indigo i1 = null;

        while (true) {
            System.out.println("\nChoose : \n 1.BookTicket  \n 2.DisplayTicket \n 3.ChangeDate \n 4.CancelTicket \n 5.Exit \n");
            System.out.print("Enter you choice: ");
            int choose = choosing.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Choose Airlines: AirIndia / AirAsia / Indigo");
                    String choosingAirlines = choosing.next();
                    if (choosingAirlines.equalsIgnoreCase("AirIndia")) {
                        india1 = new AirIndia();
                        india1.bookAirIndia();
                    } else if (choosingAirlines.equalsIgnoreCase("AirAsia")) {
                        asia1 = new AirAsia();
                        asia1.bookAirAsia();
                    } else if (choosingAirlines.equalsIgnoreCase("Indigo")) {
                        i1 = new Indigo();
                        i1.bookIndigo();
                    } else {
                        System.out.println("❌ Invalid Airline!");
                    }
                    break;

                case 2:
                    System.out.println("Enter your Airline: ");
                    String airline = choosing.next();
                    if (airline.equalsIgnoreCase("AirIndia") && india1 != null) india1.displayTicket();
                    else if (airline.equalsIgnoreCase("AirAsia") && asia1 != null) asia1.displayTicket();
                    else if (airline.equalsIgnoreCase("Indigo") && i1 != null) i1.displayTicket();
                    else System.out.println("❌ No booking found!");
                    break;

                case 3:
                    System.out.println("Enter Airline to Change the Date: ");
                    String checkAirline = choosing.next();
                    if (checkAirline.equalsIgnoreCase("AirIndia") && india1 != null) india1.changeDate();
                    else if (checkAirline.equalsIgnoreCase("AirAsia") && asia1 != null) asia1.changeDate();
                    else if (checkAirline.equalsIgnoreCase("Indigo") && i1 != null) i1.changeDate();
                    else System.out.println("❌ Ticket Not Booked Yet!");
                    break;

                case 4:
                    System.out.println("Enter your Airline: ");
                    String cancelTicket = choosing.next();
                    if (cancelTicket.equalsIgnoreCase("AirIndia") && india1 != null) india1.cancelBooking();
                    else if (cancelTicket.equalsIgnoreCase("AirAsia") && asia1 != null) asia1.cancelBooking();
                    else if (cancelTicket.equalsIgnoreCase("Indigo") && i1 != null) i1.cancelBooking();
                    else System.out.println("❌ No booking found to cancel.");
                    break;

                case 5:
                    System.out.println("🙏 Thank You!");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid Choice!");
            }
        }
    }
}