package com.parking;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<ParkingTicket, Car> parkingTicketCarMap;



    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkingTicketCarMap = new HashMap<>();
    }

    public ParkingTicket park(Car car) {
        ParkingTicket ticket = new ParkingTicket();
        if (parkingTicketCarMap.keySet().size() == capacity) {
            throw new ParkingFullException();
        }
        parkingTicketCarMap.put(ticket, car);
        return ticket;
    }

    public Car pickUp(ParkingTicket parkingTicket) {
        return parkingTicketCarMap.remove(parkingTicket);
    }

    public boolean isFull() {
        return capacity == parkingTicketCarMap.size();
    }

    public boolean hasCar(ParkingTicket parkingTicket) {
        return parkingTicketCarMap.keySet().contains(parkingTicket);
    }

    public int calcEmptyRoomSize() {
        return capacity - this.parkingTicketCarMap.size();
    }

    public double calcVacancyRate() {
        return new BigDecimal(capacity - this.parkingTicketCarMap.size()).divide(new BigDecimal(capacity)).doubleValue();
    }

    public int getCapacity() {
        return capacity;
    }

    public int calcParkingCarNumber() {
        return this.parkingTicketCarMap.size();
    }
}
