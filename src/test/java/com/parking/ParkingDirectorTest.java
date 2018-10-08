package com.parking;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ParkingDirectorTest {
    @Test
    public void should_park_one_car_when_parking_boy_park_one_car() {
        List<ParkingLot> parkingLots = Lists.newArrayList();
        parkingLots.add(new ParkingLot(5));
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingDirector director = new ParkingDirector(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        Car carOne = new Car("one");
        int size = director.calcAvaliableParkingLotsSize();
        director.park(carOne);
        int size2 = director.calcAvaliableParkingLotsSize();
        assertThat(size).isEqualTo(11);
        assertThat(size2).isEqualTo(10);
    }
}
