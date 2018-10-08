package com.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartParkingBoyTest {

    @Test
    public void  should_park_in_the_first_parking_lot_when_two_parking_lot_has_the_same_empty_room() {
        //given
        Parking firstParking = new Parking(1);
        Parking secondParking = new Parking(1);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(firstParking,secondParking);
        //when
        parkingBoy.park(new Car("12"));
        //then
        assertThat(firstParking.isFull()).isEqualTo(true);
        assertThat(secondParking.isFull()).isEqualTo(false);
    }
    @Test
    public void  should_park_in_the_last_parking_lot_when_last_parking_lot_has_the_more_empty_room() {
        //given
        Parking firstParking = new Parking(1);
        Parking secondParking = new Parking(2);
        int firstSize = firstParking.calcEmptyRoomSize();
        int secondSize = secondParking.calcEmptyRoomSize();
        SmartParkingBoy parkingBoy = new SmartParkingBoy(firstParking,secondParking);
        //when
        parkingBoy.park(new Car("12"));
        int aFirstSize = firstParking.calcEmptyRoomSize();
        int aSecondSize = secondParking.calcEmptyRoomSize();
        //then
        assertThat(aFirstSize).isEqualTo(firstSize);
        assertThat(aSecondSize).isLessThan(secondSize);
    }
}
