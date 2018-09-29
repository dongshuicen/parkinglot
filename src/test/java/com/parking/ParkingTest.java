package com.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParkingTest {
    @Test
    void should_get_ticket_when_park_one_car(){
        //given
        int capacity = 100;
        Parking parking = new Parking(capacity);
        Car car = new Car("1111");
        //when
        ParkingTicket result = parking.park(car);
        //then
        assertThat(result).isNotNull();
    }

    @Test
    void should_throw_full_exception_when_parking_is_full() {
        //given
        int capacity = 1;
        Parking parking = new Parking(capacity);
        Car car = new Car("1111");
        //when
        ParkingTicket result = parking.park(car);
        //then
        assertThrows(ParkingFullException.class,()->parking.park(car));
    }
    @Test
    void should_pickup_one_car_when_one_car_parked() {
        //given
        int capacity = 1;
        Parking parking = new Parking(capacity);
        Car car = new Car("1111");
        ParkingTicket parkingTicket = parking.park(car);
        //when
        Car pickUpCar = parking.pickUp(parkingTicket);
        //then
        assertThat(pickUpCar).isEqualTo(car);
    }

    @Test
    void should_pickup_one_car_when_two_car_parked() {
        //given
        int capacity = 2;
        Parking parking = new Parking(capacity);
        Car car1 = new Car("1111");
        Car car2 = new Car("1111");
        //when
        parking.park(car1);
        ParkingTicket parkingTicket2 = parking.park(car2);
        Car pickUpCar = parking.pickUp(parkingTicket2);
        //then
        assertThat(pickUpCar).isEqualTo(car2);
    }

}
