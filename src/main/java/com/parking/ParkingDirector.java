package com.parking;

public class ParkingDirector {

    private ParkingManager manager;

    public ParkingDirector(ParkingManager manager) {
        this.manager = manager;
    }
    public void printReport(){
        new ParkingReportBuilder().build(this.manager).print();
    }
}
