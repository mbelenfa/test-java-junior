package com.carscatalog.datamodel;

public class SportCar extends Car {

    private String secondsLimit;

    public SportCar(String color, int doors, int wheels, double mileage, String chassisNumber,
                    String brand, String typeCar, String secondsLimit) {
        super(color, doors, wheels, mileage, chassisNumber, brand, typeCar);
        this.secondsLimit = secondsLimit;

    }

    public String getSecondsLimit() {
        return secondsLimit;
    }

    public void setSecondsLimit(String secondsLimit) {
        this.secondsLimit = secondsLimit;
    }

    @Override
    public void speedUp() {
        System.out.println("Speeding up, in " + this.secondsLimit + " seconds " + "will reach to 100 km/h" );
    }

}
