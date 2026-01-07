package model;

import java.util.Random;
import java.util.Date;

public class Ticket {
    private static int idCounter = 1000;
    private int ticketId;
    private String pnr;
    private Train train;
    private Passenger passenger;
    private String bookingDate;
    private int seatNumber;
    private String status;

    public Ticket(Passenger passenger, Train train, String bookingDate, int seatNumber) {
        this.ticketId = idCounter++;
        this.passenger = passenger;
        this.train = train;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.status = "CONFIRMED";
        generatePNR();
    }

    public void generatePNR() {
        Random r = new Random();
        this.pnr = "PNR" + (r.nextInt(9000) + 1000);
    }

    public String getPnr() { return pnr; }
    public Train getTrain() { return train; }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calculateRefund() {
        return status.equals("CANCELLED") ? train.getTicketPrice() * 0.8 : 0.0;
    }

    public void displayTicket() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("PNR: " + pnr);
        passenger.displayPassengerInfo();
        System.out.println("Train: " + train.getTrainName());
        System.out.println("Seat No: " + seatNumber);
        System.out.println("Status: " + status);
    }
}