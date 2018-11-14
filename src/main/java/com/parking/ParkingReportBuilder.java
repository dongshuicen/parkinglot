package com.parking;

public class ParkingReportBuilder {

  public ParkingReport build(ParkingManager manager) {
    String str = manager.report();
    ParkingReport report = new ParkingReport(str);
    return report;
  }

}
