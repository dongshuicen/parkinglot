package com.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SuperParkingBoyTest {
    @Test
    public void should_park_in_second_parking_lot_when_second_parking_lot_vacancy_rate_high() {
        //given
        ParkingLot parkingLotLotFirst = new ParkingLot(2);
        ParkingLot parkingLotLotLast = new ParkingLot(1);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLotLotFirst, parkingLotLotLast);
        //when
        Car car1 = new Car("first");
        parkingLotLotFirst.park(car1);
        Car car = new Car("20181008");
        ParkingTicket ticket = parkingBoy.park(car);
        int firstSize = parkingLotLotFirst.calcEmptyRoomSize();
        int secondSize = parkingLotLotLast.calcEmptyRoomSize();
        //then
        Car pickCar = parkingBoy.pick(ticket);
        assertThat(secondSize).isEqualTo(0);
        assertThat(firstSize).isEqualTo(1);
    }
    @Test
    public void should_park_in_first_parking_lot_when_two_parking_lot_vacancy_rate_equals() {
        //given
        ParkingLot parkingLotLotFirst = new ParkingLot(2);
        ParkingLot parkingLotLotLast = new ParkingLot(2);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLotLotFirst, parkingLotLotLast);
        //when
        Car car1 = new Car("first");
        parkingLotLotFirst.park(car1);
        parkingLotLotLast.park(new Car("second"));
        Car car = new Car("20181008");
        ParkingTicket ticket = parkingBoy.park(car);
        int firstSize = parkingLotLotFirst.calcEmptyRoomSize();
        int secondSize = parkingLotLotLast.calcEmptyRoomSize();
        //then
        Car pickCar = parkingBoy.pick(ticket);
        assertThat(firstSize).isEqualTo(0);
        assertThat(secondSize).isEqualTo(1);
    }


}
