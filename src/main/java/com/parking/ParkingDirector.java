package com.parking;

import java.util.Arrays;
import java.util.List;

public class ParkingDirector extends SuperParkingBoy{
    private final List<ParkingBoy> parkingBoys;

    public ParkingDirector(List<ParkingLot> parkingLots, ParkingBoy... parkingBoys) {
        super(parkingLots.toArray(new ParkingLot[parkingLots.size()]));
        this.parkingBoys = Arrays.asList(parkingBoys);
    }

    public ParkingTicket manageParkingBoyParCar(Car car) {
        for (ParkingBoy parkingBoy : this.parkingBoys) {
            ParkingTicket ticket = parkingBoy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        throw new ParkingFullException();
    }
    public Car pickUpCarParkingBoy(ParkingTicket parkingTicket) {
        for (ParkingBoy parkingBoy : this.parkingBoys) {
            Car car = parkingBoy.pick(parkingTicket);
            if (car != null) {
                return car;
            }
        }
        throw new NoSuchCarException();
    }

    public int calcAvaliableParkingLotsSize() {
        int sumParkingSize = this.parkingBoys.stream().mapToInt(parkingBoy -> parkingBoy.getParkingLots().stream()
                .mapToInt(ParkingLot::calcEmptyRoomSize).sum()).sum();
        /*int parkingLotSize = this.parkingLots.stream().mapToInt(ParkingLot::calcEmptyRoomSize).sum();*/
        return sumParkingSize /*+ parkingLotSize*/;
    }
}
