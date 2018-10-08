package com.parking;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(Parking... parkings) {
        super(parkings);
    }

    @Override
    public ParkingTicket park(Car car) {
        List<Parking> bakList = this.getParkings().stream().sorted(Comparator.comparingInt(Parking::calcEmptyRoomSize).reversed())
                .collect(Collectors.toList());
        Parking parking = bakList.get(0);
        return parking.park(car);
    }
}
