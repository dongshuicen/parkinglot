package com.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SuperParkingBoyTest {
    @Test
    public void should_park_in_second_parking_lot_when_second_parking_lot_vacancy_rate_high() {
        //given
        Parking parkingLotFirst = new Parking(2);
        Parking parkingLotLast  = new Parking(1);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLotFirst,parkingLotLast);
        //when
        Car car1 = new Car("first");
        parkingLotFirst.park(car1);
        Car car = new Car("20181008");
        ParkingTicket ticket = parkingBoy.park(car);
        int firstSize = parkingLotFirst.calcEmptyRoomSize();
        int secondSize = parkingLotLast.calcEmptyRoomSize();
        //then
        Car pickCar = parkingBoy.pick(ticket);
        assertThat(secondSize).isEqualTo(0);
        assertThat(firstSize).isEqualTo(1);
    }
    @Test
    public void should_park_in_first_parking_lot_when_two_parking_lot_vacancy_rate_equals() {
        //given
        Parking parkingLotFirst = new Parking(2);
        Parking parkingLotLast  = new Parking(2);
        SuperParkingBoy parkingBoy = new SuperParkingBoy(parkingLotFirst,parkingLotLast);
        //when
        Car car1 = new Car("first");
        parkingLotFirst.park(car1);
        parkingLotLast.park(new Car("second"));
        Car car = new Car("20181008");
        ParkingTicket ticket = parkingBoy.park(car);
        int firstSize = parkingLotFirst.calcEmptyRoomSize();
        int secondSize = parkingLotLast.calcEmptyRoomSize();
        //then
        Car pickCar = parkingBoy.pick(ticket);
        assertThat(firstSize).isEqualTo(0);
        assertThat(secondSize).isEqualTo(1);
    }


}
