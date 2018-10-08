package com.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingBoy {
    private final List<Parking> parkings ;

    public ParkingBoy(Parking... parkings) {
        this.parkings = Arrays.asList(parkings);
    }

    public ParkingTicket park(Car car) {
        Optional<Parking> firstParking = this.parkings.stream().filter(lot -> !lot.isFull()).findFirst();
        if (firstParking.isPresent()) {
            return firstParking.get().park(car);
        }
        throw new ParkingFullException();
    }

    public Car pick(ParkingTicket ticket) {
        /*for (Parking parking : parkings) {
            Car car = parking.pickUp(ticket);
            if (car != null) {
                return car;
            }
        }*/
        Optional<Parking> park = searchParkingByTicket(ticket);
        if (park.isPresent()) {
            return park.get().pickUp(ticket);
        }
        throw new NoSuchCarException();
    }

    public Optional<Parking> searchParkingByTicket(ParkingTicket parkingTicket) {
        for (Parking parking : parkings) {
            if (parking.hasCar(parkingTicket)) {
                return Optional.of(parking);
            }
        }
        return Optional.empty();
    }



    public List<Parking> getParkings() {
        return parkings;
    }
}
