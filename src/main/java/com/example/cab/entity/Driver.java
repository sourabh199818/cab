package com.example.cab.entity;


public class Driver {

    private String driverDetails;
    private String driverCar;

    private Location currentLocation;

    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Driver(String driverDetails, String driverCar, Location currentLocation) {
        this.driverDetails = driverDetails;
        this.driverCar = driverCar;
        this.currentLocation = currentLocation;
    }

    public String getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(String driverDetails) {
        this.driverDetails = driverDetails;
    }

    public String getDriverCar() {
        return driverCar;
    }

    public void setDriverCar(String driverCar) {
        this.driverCar = driverCar;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
