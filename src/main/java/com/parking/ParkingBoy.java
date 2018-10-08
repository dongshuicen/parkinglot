package com.parking;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ParkingBoy implements Parking{
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Optional<ParkingLot> firstParking = this.parkingLots.stream().filter(lot -> !lot.isFull()).findFirst();
        if (firstParking.isPresent()) {
            return firstParking.get().park(car);
        }
        throw new ParkingFullException();
    }

    @Override
    public Car pick(ParkingTicket ticket) {
        Optional<ParkingLot> park = searchParkingByTicket(ticket);
        if (park.isPresent()) {
            return park.get().pickUp(ticket);
        }
        throw new NoSuchCarException();
    }

    public Optional<ParkingLot> searchParkingByTicket(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasCar(parkingTicket)) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }



    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
