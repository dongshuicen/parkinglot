package com.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartParkingBoyTest {

    @Test
    public void  should_park_in_the_first_parking_lot_when_two_parking_lot_has_the_same_empty_room() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(firstParkingLot, secondParkingLot);
        //when
        parkingBoy.park(new Car("12"));
        //then
        assertThat(firstParkingLot.isFull()).isEqualTo(true);
        assertThat(secondParkingLot.isFull()).isEqualTo(false);
    }
    @Test
    public void  should_park_in_the_last_parking_lot_when_last_parking_lot_has_the_more_empty_room() {
        //given
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        int firstSize = firstParkingLot.calcEmptyRoomSize();
        int secondSize = secondParkingLot.calcEmptyRoomSize();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(firstParkingLot, secondParkingLot);
        //when
        parkingBoy.park(new Car("12"));
        int aFirstSize = firstParkingLot.calcEmptyRoomSize();
        int aSecondSize = secondParkingLot.calcEmptyRoomSize();
        //then
        assertThat(aFirstSize).isEqualTo(firstSize);
        assertThat(aSecondSize).isLessThan(secondSize);
    }
}
