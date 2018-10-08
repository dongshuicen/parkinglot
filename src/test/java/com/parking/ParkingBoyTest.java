package com.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {
    @Test
    public void should_park_car_into_first_parking_lot_when_first_parking_is_not_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        parkingBoy.park(new Car("12"));
        assertThat(firstParkingLot.isFull()).isEqualTo(true);
        assertThat(secondParkingLot.isFull()).isEqualTo(false);

    }
    @Test
    public void should_park_car_into_second_parking_lot_when_first_parking_is_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        parkingBoy.park(new Car("12"));
        parkingBoy.park(new Car("13"));
        assertThat(firstParkingLot.isFull()).isEqualTo(true);
        assertThat(secondParkingLot.isFull()).isEqualTo(true);

    }

    @Test
    public void should_throw_parking_lot_full_exception_when_all_parking_is_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        parkingBoy.park(new Car("12"));
        parkingBoy.park(new Car("13"));
        assertThrows(ParkingFullException.class,()->parkingBoy.park(new Car("15")));
    }

    @Test
    public void should_picked_a_car_when_parked_in_parking_lot() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car1 = new Car("12");
        parkingBoy.park(car1);
        ParkingTicket ticket = parkingBoy.park(car1);
        Car car2=parkingBoy.pick(ticket);
        assertThat(car1).isEqualTo(car2);
    }





}
