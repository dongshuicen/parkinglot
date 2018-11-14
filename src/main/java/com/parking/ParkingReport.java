package com.parking;

public class ParkingReport {


  private String reportContent;

  public ParkingReport(String reportContent) {
    this.reportContent = reportContent;
  }

  public void print() {
    System.out.println(this.reportContent);
  }
}
