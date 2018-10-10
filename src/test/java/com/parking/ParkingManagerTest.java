package com.parking;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ParkingManagerTest {
    @Test
    public void should_park_one_car_when_parking_director_park_one_car() {
        //given
        List<ParkingLot> parkingLots = Lists.newArrayList();
        ParkingLot firstParkingLot = new ParkingLot(5);
        parkingLots.add(firstParkingLot);
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(2));
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(new ParkingLot(2));
        ParkingManager director = new ParkingManager(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        Car carOne = new Car("one");
        int size = director.calcParkingBoyAvaliableParkingLotsSize();
        //when
        director.park(carOne);
        director.park(parkingBoy, new Car("two"));
        int parkingLotSize = parkingLot.calcEmptyRoomSize();
        int size2 = director.calcParkingBoyAvaliableParkingLotsSize();
        //then
        assertThat(size).isEqualTo(6);
        assertThat(size2).isEqualTo(5);
        assertThat(firstParkingLot.calcEmptyRoomSize()).isEqualTo(4);
        assertThat(parkingLotSize).isEqualTo(1);
    }

    @Test
    public void should_park_one_car_when_director_manage_parking_boy_parking_car() {
        //given
        List<ParkingLot> parkingLots = Lists.newArrayList();
        parkingLots.add(new ParkingLot(5));
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLot smartParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingLot);
        ParkingLot superParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(superParkingLot);
        ParkingManager director = new ParkingManager(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        int size = director.calcParkingBoyAvaliableParkingLotsSize();
        //when
        director.park(smartParkingBoy, new Car("two"));
        int smartParkingLotSize = smartParkingLot.calcEmptyRoomSize();
        int size2 = director.calcParkingBoyAvaliableParkingLotsSize();
        //then
        assertThat(size).isEqualTo(6);
        assertThat(size2).isEqualTo(5);
        assertThat(smartParkingLotSize).isEqualTo(1);
    }
    @Test
    public void should_park_one_car_when_manager_manage_super_parking_boy_parking_car() {
        //given
        List<ParkingLot> parkingLots = Lists.newArrayList();
        parkingLots.add(new ParkingLot(5));
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLot smartParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(smartParkingLot);
        ParkingLot superParkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(superParkingLot);
        ParkingManager director = new ParkingManager(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        int size = director.calcParkingBoyAvaliableParkingLotsSize();
        int superParkingLotSize = superParkingLot.calcEmptyRoomSize();
        //when
        director.park(superParkingBoy, new Car("two"));
        int size2 = director.calcParkingBoyAvaliableParkingLotsSize();
        int superParkingLotSizeL = superParkingLot.calcEmptyRoomSize();
        //then
        assertThat(superParkingLotSizeL).isEqualTo(1);
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
        ParkingManager director = new ParkingManager(parkingLots,
                parkingBoy,
                smartParkingBoy,
                superParkingBoy);
        //when
        Car oneCar = new Car("one");
        ParkingTicket parkingTicket = director.park(parkingBoy, oneCar);
        Car simpleCar = director.pickUpCarParkingBoy(parkingTicket);
        assertThat(simpleCar).isEqualTo(oneCar);

    }
}