package com.carscatalog.datamodel;

import com.carscatalog.CarFunctions;

public class Car implements CarFunctions {
    private String color;
    private int doors;
    private int wheels;
    private double mileage;
    private String chassisNumber;
    private String brand;
    private String typeCar;
    private boolean isOn;


    public Car(String color, int doors, int wheels, double mileage, String chassisNumber, String brand, String typeCar) {
        this.color = color;
        this.doors = doors;
        this.wheels = wheels;
        this.mileage = mileage;
        this.chassisNumber = chassisNumber;
        this.brand = brand;
        this.typeCar = typeCar;
        this.isOn=false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void speedUp() {
        if (isOn) {
            System.out.println("Speeding up...");
        }else{
            System.out.println("the car is turned off, you can't speed");
        }
    }

    @Override
    public void brake() {
        if (isOn) {
            System.out.println("slowing down");
        }else{
            System.out.println("the car is turned off, you can't brake");
        }
    }

    @Override
    public void powerUp() {
        if(isOn){
            System.out.println("The car is alredy turned on");
        }else{
            this.isOn=true;
            System.out.println("The car is turning on...");
        }
    }

    @Override
    public void powerOff() {
        if(isOn){
            isOn=false;
            System.out.println("The car is turning of...");
        }else{
            System.out.println("The car is alredy turned off");
        }
    }

    @Override
    public String toString() {
        return "Car{"+
                "color:" + color +
                ", doors:" + doors +
                ", wheels:" + wheels +
                ", milieage:" + mileage +
                ", chassis number:" + chassisNumber +
                ", brand:" + brand +
                '}';
    }
}
