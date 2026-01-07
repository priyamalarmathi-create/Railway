package model;

public class Train {
    private String trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private double ticketPrice;

    public Train(String trainNumber, String trainName, String source, String destination,
                 int totalSeats, int availableSeats, double ticketPrice) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public String getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }
    public double getTicketPrice() { return ticketPrice; }

    public void bookSeat() {
        if (availableSeats > 0) availableSeats--;
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) availableSeats++;
    }

    public void displayTrainInfo() {
        System.out.println(trainNumber + " - " + trainName + " | From: " + source + " To: " + destination +
                " | Seats: " + availableSeats + "/" + totalSeats + " | Price: " + ticketPrice);
    }
}