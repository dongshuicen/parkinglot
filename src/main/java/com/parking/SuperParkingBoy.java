package com.parking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParkingBoy extends ParkingBoy{
    private final List<ParkingLot> parkingLots;
    public SuperParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
        this.parkingLots = Arrays.asList(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        Optional<ParkingLot> parkingLot = searchParking();
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        }
        throw new ParkingFullException();
    }

    private Optional<ParkingLot> searchParking() {
        Optional<ParkingLot> parkingLot = this.parkingLots.stream().sorted(Comparator.comparingDouble(ParkingLot::calcVacancyRate).reversed())
                .findFirst();
        return parkingLot;
    }
}
