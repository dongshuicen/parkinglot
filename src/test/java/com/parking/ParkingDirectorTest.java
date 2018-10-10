package com.parking;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ParkingDirectorTest {
    @Test
    public void out_put_receipt() {
        List<ParkingLot> parkingLots = Lists.newArrayList();
        ParkingLot manageParkingLot = new ParkingLot(10);
        parkingLots.add(manageParkingLot);
        ParkingLot smartParkLot = new ParkingLot(5);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkLot);
        ParkingLot superFirstParkingLot = new ParkingLot(3);
        ParkingLot superLastParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(superFirstParkingLot,superLastParkingLot);
        ParkingManager manager = new ParkingManager(parkingLots,smartParkingBoy,superParkingBoy);
        ParkingTicket firstTicket = manager.park(new Car("first car"));
        ParkingTicket secondTicket = manager.park(new Car("second car"));
        ParkingTicket thirdTicket = manager.park(smartParkingBoy, new Car("third car"));
        ParkingTicket fouthTicket = manager.park(superParkingBoy, new Car("fouth car"));
        Car fiveCar = new Car("five car");
        ParkingTicket fiveTicket = manager.park(smartParkingBoy, fiveCar);
        System.out.println("M  "+manager.calcParkingBoyAvaliableParkingLotsSize());
        Car pickUpCar = manager.pickUpCarParkingBoy(fiveTicket);
        assertThat(pickUpCar).isEqualTo(fiveCar);

    }
}
