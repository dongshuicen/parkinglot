package com.parking;

import java.util.Arrays;
import java.util.List;

public class ParkingDirector extends SuperParkingBoy{
    private final List<ParkingBoy> parkingBoys;
    private final List<ParkingLot> parkingLots;

    public ParkingDirector(List<ParkingLot> parkingLots, ParkingBoy... parkingBoys) {
        this.parkingLots = parkingLots;
        this.parkingBoys = Arrays.asList(parkingBoys);
    }

    @Override
    public ParkingTicket park(Car car) {
        for (ParkingBoy parkingBoy : this.parkingBoys) {
            ParkingTicket ticket = parkingBoy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        ParkingTicket ticket = super.park(car);
        if (ticket != null) {
            return ticket;
        }
        throw new ParkingFullException();
    }

    public int calcAvaliableParkingLotsSize() {
        int sumParkingSize = this.parkingBoys.stream().mapToInt(parkingBoy -> parkingBoy.getParkingLots().stream()
                .mapToInt(ParkingLot::calcEmptyRoomSize).sum()).sum();
        int parkingLotSize = this.parkingLots.stream().mapToInt(ParkingLot::calcEmptyRoomSize).sum();
        return sumParkingSize + parkingLotSize;
    }
}
