import java.util.Scanner;

import exception.InvalidPNRException;
import exception.TrainNotFoundException;
import model.Passenger;
import model.Ticket;
import model.Train;
import service.BookingSystem;

public class RailwayReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.addTrain(new Train("12301", "Rajdhani Express", "Delhi", "Mumbai", 100, 100, 1500));
        bookingSystem.addTrain(new Train("12302", "Shatabdi Express", "Delhi", "Agra", 50, 50, 800));
        bookingSystem.addTrain(new Train("12303", "Duronto Express", "Kolkata", "Delhi", 150, 150, 2000));

        while (true) {
            System.out.println("\n===== RAILWAY RESERVATION SYSTEM =====");
            System.out.println("1. View All Trains");
            System.out.println("2. Search Train");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Check PNR");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookingSystem.displayAllTrains();
                    break;

                case 2:
                    System.out.print("Enter Source: ");
                    String src = sc.next();
                    System.out.print("Enter Destination: ");
                    String dest = sc.next();
                    try {
                        Train train = bookingSystem.searchTrain(src, dest);
                        System.out.println("Train Found: ");
                        train.displayTrainInfo();
                    } catch (TrainNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Gender: ");
                    String gender = sc.next();
                    System.out.print("Enter Phone: ");
                    String phone = sc.next();

                    Passenger p = new Passenger(name, age, gender, phone);
                    System.out.print("Enter Source: ");
                    src = sc.next();
                    System.out.print("Enter Destination: ");
                    dest = sc.next();

                    try {
                        Train train = bookingSystem.searchTrain(src, dest);
                        Ticket ticket = bookingSystem.bookTicket(p, train);
                        System.out.println("Booking successful!");
                        ticket.displayTicket();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;

                case 4:
                    System.out.print("Enter PNR to cancel: ");
                    String pnr = sc.next();
                    try {
                        bookingSystem.cancelTicket(pnr);
                    } catch (InvalidPNRException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter PNR to check: ");
                    pnr = sc.next();
                    try {
                        bookingSystem.checkPNRStatus(pnr);
                    } catch (InvalidPNRException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Railway Reservation System!");
                    
                    System.exit(0);

                default:
                    System.out.println("Valid choice!");
            }
        }
    }
}