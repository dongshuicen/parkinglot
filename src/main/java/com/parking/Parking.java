package com.parking;

public interface Parking {

    ParkingTicket park(Car car);
    Car pick(ParkingTicket ticket);
}
