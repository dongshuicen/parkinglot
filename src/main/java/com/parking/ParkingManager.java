package com.parking;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ParkingManager extends SuperParkingBoy{
    private final List<ParkingBoy> parkingBoys;

    public ParkingManager(List<ParkingLot> parkingLots, ParkingBoy... parkingBoys) {
        super(parkingLots.toArray(new ParkingLot[parkingLots.size()]));
        this.parkingBoys = Arrays.asList(parkingBoys);
    }

    @Override
    public ParkingTicket park(Car car) {
        return super.park(car);
    }

    public ParkingTicket park(ParkingBoy parkingBoy, Car car) {
        boolean isContain = this.parkingBoys.contains(parkingBoy);
        if (isContain) {
            return parkingBoy.park(car);
        }
        throw new NoSuchParkingBoyExcepion();
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

    public int calcParkingBoyAvaliableParkingLotsSize() {
        int sumParkingSize = this.parkingBoys.stream().mapToInt(parkingBoy -> parkingBoy.getParkingLots().stream()
                .mapToInt(ParkingLot::calcEmptyRoomSize).sum()).sum();
        return sumParkingSize;
    }
    public int calcAllAvaliableParkingLotsSize() {
        int sumParkingSize = this.parkingBoys.stream().mapToInt(parkingBoy -> parkingBoy.getParkingLots().stream()
                .mapToInt(ParkingLot::calcEmptyRoomSize).sum()).sum();
        int selfParkingLotSize = this.parkingLots.stream().mapToInt(ParkingLot::calcEmptyRoomSize).sum();
        return sumParkingSize + selfParkingLotSize;
    }
    public int calcAllParkingCarNum() {
        int sumParkingSize = this.parkingBoys.stream().mapToInt(parkingBoy -> parkingBoy.getParkingLots().stream()
            .mapToInt(ParkingLot::calcParkingCarNumber).sum()).sum();
        int selfParkingLotSize = this.parkingLots.stream().mapToInt(ParkingLot::calcParkingCarNumber).sum();
        return sumParkingSize + selfParkingLotSize;
    }
    public int calcAllParkingLotsSize() {
        int parkingBoyParkingLotsSize = this.parkingBoys.stream().mapToInt(parkingBoy -> parkingBoy.getParkingLots().stream()
                .mapToInt(ParkingLot::getCapacity).sum()).sum();
        int selfParkingLotSize = this.parkingLots.stream().mapToInt(ParkingLot::getCapacity).sum();
        return parkingBoyParkingLotsSize + selfParkingLotSize;
    }
    public String report() {
        long parkingCarNum = this.calcAllParkingCarNum();
        long allParkingLotCapacity = this.calcAllParkingLotsSize();
        long selfParkingLotParkingCarNum = super.calcParkingCarNum();
        long selfParkingLotCapacity = super.calcParkingLotSize();
        StringBuilder sb = new StringBuilder();
        this.parkingBoys.stream().forEach(parkingBoy -> {
            sb.append(String.format("  B %d %d\n",parkingBoy.calcParkingCarNum(),parkingBoy.calcParkingLotSize()));
            parkingBoy.parkingLots.stream().forEach(parkingLot -> {
                sb.append(String.format("    P %d %d\n",parkingLot.calcParkingCarNumber(),parkingLot.getCapacity()));
            });
        });
        String sumary = String.format("M %d %d\n  P %d %d\n%s",
            parkingCarNum,
            allParkingLotCapacity,
            selfParkingLotParkingCarNum,
            selfParkingLotCapacity,
            sb.toString());
        return sumary;
    }
}
