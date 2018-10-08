package com.parking;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        List<ParkingLot> bakList = this.getParkingLots().stream().sorted(Comparator.comparingInt(ParkingLot::calcEmptyRoomSize).reversed())
                .collect(Collectors.toList());
        ParkingLot parkingLot = bakList.get(0);
        return parkingLot.park(car);
    }
}
