package com.parking;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ParkingDirectorTest {
    @Test
    public void should_park_one_car_when_parking_director_park_one_car() {
        //given
        List<ParkingLot> parkingLots = Lists.newArrayList();
        ParkingLot firstParkingLot = new ParkingLot(5);
        parkingLots.add(firstParkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingDirector director = new ParkingDirector(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        Car carOne = new Car("one");
        int size = director.calcAvaliableParkingLotsSize();
        //when
        director.park(carOne);
        director.manageParkingBoyParCar(new Car("two"));
        int size2 = director.calcAvaliableParkingLotsSize();
        //then
        assertThat(size).isEqualTo(6);
        assertThat(size2).isEqualTo(5);
        assertThat(firstParkingLot.calcEmptyRoomSize()).isEqualTo(4);
    }

    @Test
    public void should_park_one_car_when_director_manage_parking_boy_parking_car() {
        //given
        List<ParkingLot> parkingLots = Lists.newArrayList();
        parkingLots.add(new ParkingLot(5));
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingDirector director = new ParkingDirector(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        int size = director.calcAvaliableParkingLotsSize();
        //when
        director.manageParkingBoyParCar(new Car("two"));
        int size2 = director.calcAvaliableParkingLotsSize();
        //then
        assertThat(size).isEqualTo(6);
        assertThat(size2).isEqualTo(5);
    }
    @Test
    public void should_pick_up_one_car_when_director_manage_parking_boy_park_one_car() {
        //pickUpCarParkingBoy
        //given
        List<ParkingLot> parkingLots = Lists.newArrayList();
        parkingLots.add(new ParkingLot(5));
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(2));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingDirector director = new ParkingDirector(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        //when
        Car oneCar = new Car("one");
        ParkingTicket parkingTicket = director.manageParkingBoyParCar(oneCar);
        Car simpleCar = director.pickUpCarParkingBoy(parkingTicket);
        assertThat(simpleCar).isEqualTo(oneCar);

    }
}