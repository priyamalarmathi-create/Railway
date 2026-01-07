package service;

import java.util.*;

import exception.InvalidPNRException;
import exception.SeatNotAvailableException;
import exception.TrainNotFoundException;
import model.Passenger;
import model.Ticket;
import model.Train;

public class BookingSystem {
    private List<Train> trains = new ArrayList<>();
    private List<Ticket> bookings = new ArrayList<>();
    private Map<String, Ticket> pnrMap = new HashMap<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void displayAllTrains() {
        System.out.println("\nAvailable Trains:");
        for (Train t : trains) t.displayTrainInfo();
    }

    public Train searchTrain(String source, String destination) throws TrainNotFoundException {
        for (Train t : trains) {
            if (t.getSource().equalsIgnoreCase(source) && t.getDestination().equalsIgnoreCase(destination)) {
                return t;
            }
        }
        throw new TrainNotFoundException();
    }

    public synchronized Ticket bookTicket(Passenger passenger, Train train)
            throws SeatNotAvailableException {
        if (train.getAvailableSeats() > 0) {
            train.bookSeat();
            Ticket ticket = new Ticket(passenger, train, new Date().toString(), train.getAvailableSeats());
            bookings.add(ticket);
            pnrMap.put(ticket.getPnr(), ticket);
            return ticket;
        } else {
            throw new SeatNotAvailableException();
        }
    }

    public synchronized void cancelTicket(String pnr) throws InvalidPNRException {
        Ticket ticket = pnrMap.get(pnr);
        if (ticket == null) throw new InvalidPNRException();

        ticket.getTrain().cancelSeat();
        ticket.setStatus("CANCELLED");
        System.out.println("Ticket cancelled successfully. Refund: " + ticket.calculateRefund());
    }

    public void checkPNRStatus(String pnr) throws InvalidPNRException {
        Ticket ticket = pnrMap.get(pnr);
        if (ticket == null) throw new InvalidPNRException();
        ticket.displayTicket();
    }
}