package com.parking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParkingBoy extends ParkingBoy{
    private final List<Parking> parkingLots;
    public SuperParkingBoy(Parking... parkingLots) {
        super(parkingLots);
        this.parkingLots = Arrays.asList(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Optional<Parking> parkingLot = searchParking();
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new ParkingFullException();
    }

    private Optional<Parking> searchParking() {
        Optional<Parking> parkingLot = this.parkingLots.stream().sorted(Comparator.comparingDouble(Parking::calcVacancyRate).reversed())
                .findFirst();
        return parkingLot;
    }
}
