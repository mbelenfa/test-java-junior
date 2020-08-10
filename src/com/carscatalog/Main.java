package com.carscatalog;

import com.carscatalog.datamodel.Car;
import com.carscatalog.datamodel.CarData;
import com.carscatalog.datamodel.SportCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<SportCar> sportCars = new ArrayList<>();
    static CarData carData = new CarData();
    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        createListCars();
        printList();

        System.out.println("Welcome to CARS Catalog");
        System.out.println("please enter the chassis number to select a car:");
        String chassis = scanner.nextLine();
        Integer key = searchChassis(chassis.toUpperCase());
        SportCar sportCar = null;



        while (key == null){
            System.out.println("Wrong chassis number, not found. Please enter the correct chassis number");
            printList();
            chassis = scanner.nextLine();
            key = searchChassis(chassis.toUpperCase());
        }
        Car selectedCar = cars.get(key);

        if(selectedCar.getTypeCar().equals("is a sport car")){
            for( int i=0; i<sportCars.size(); i++ ){
                if(sportCars.get(i).getChassisNumber().equals(chassis.toUpperCase())){
                    sportCar = sportCars.get(i);
                    break;
                }
            }
        }

        System.out.println("Car selected is: "+
                            "Brand: " + selectedCar.getBrand() +
                            ", color: " + selectedCar.getColor() +
                            ", chassis: " + selectedCar.getChassisNumber() +
                            ", type car: " + selectedCar.getTypeCar());

        System.out.println("please select a function:");
        functions();

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    selectedCar.powerUp();
                    break;
                case 1:
                    selectedCar.powerOff();
                    break;
                case 2:
                    if(selectedCar.getTypeCar().equals("is a sport car")){
                        sportCar.speedUp();
                    }else{
                        selectedCar.speedUp();
                    }
                    break;
                case 3:
                    selectedCar.brake();
                    break;
                case 4:
                    quit=true;
                    break;
                default:
                    break;
            }
        }

    }

    public static void createListCars(){
        try {
            carData.loadCars();
            cars.addAll(carData.getCars());
            sportCars.addAll(carData.getSportCars());

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void printList(){
        for(Car car : cars){
            System.out.print("Brand: "+ car.getBrand());
            System.out.print(", color: "+ car.getColor());
            System.out.print(", chassis number: "+ car.getChassisNumber());
            System.out.println(", type car: " + car.getTypeCar());
        }
    }
    public static Integer searchChassis(String chassis){
        for(int i=0; i<cars.size();i++){
            if(chassis.equals(cars.get(i).getChassisNumber())){
                return i;
            }
        }
        return null;
    }

    public static void functions(){
        System.out.println("0- power On");
        System.out.println("1- power off");
        System.out.println("2- speed up");
        System.out.println("3- break");
        System.out.println("4- exit");
    }
}
