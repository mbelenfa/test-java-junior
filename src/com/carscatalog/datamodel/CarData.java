package com.carscatalog.datamodel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class CarData {

    private static CarData instance = new CarData();
    private static final String CATALOG_FILE = "catalog.txt";
    private ArrayList<Car> cars;
    private  ArrayList<SportCar> sportCars;


    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addSportCar(SportCar sportCar){
        sportCars.add(sportCar);
    }

    public void loadCars() throws IOException {
        cars = new ArrayList<>();
        sportCars = new ArrayList<>();

        Path path = Paths.get(CATALOG_FILE);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while ((input = br.readLine()) != null) {
                String[] carsItems = input.split("  ");

                String color = carsItems[0];
                String door = carsItems[1];
                String wheels = carsItems[2];
                String mileage = carsItems[3];
                String chassisNumber = carsItems[4];
                String brand = carsItems[5];
                String typeCar = carsItems[6];
                String speedLimit = carsItems[7];

                    Car car = new Car(color,
                            Integer.valueOf(door),
                            Integer.valueOf(wheels),
                            Double.valueOf(mileage),
                            chassisNumber,
                            brand,
                            typeCar);
                    cars.add(car);

                if(typeCar.contains("is")){
                    SportCar sportCar = new SportCar(color,
                            Integer.valueOf(door),
                            Integer.valueOf(wheels),
                            Double.valueOf(mileage),
                            chassisNumber,
                            brand,
                            typeCar,
                            speedLimit);
                    sportCars.add(sportCar);
                }
            }
        } finally {
          if(br != null){
              br.close();
          }
        }
    }
    public ArrayList<SportCar> getSportCars(){
        return sportCars;
    }

    public void storeCars() throws IOException{
        Path path = Paths.get(CATALOG_FILE);
        BufferedWriter bw = Files.newBufferedWriter(path);


        try{
            Iterator<Car> iterator = cars.iterator();

            while(iterator.hasNext()){
                Car car = iterator.next();
                if(car.getTypeCar().equals("not a sport car")){
                    bw.write(String.format("%s  %s  %s  %s  %s  %s  %s  %s",
                            car.getColor(),
                            car.getDoors(),
                            car.getWheels(),
                            car.getMileage(),
                            car.getChassisNumber(),
                            car.getBrand(),
                            car.getTypeCar(),
                            "0")
                            );
                    bw.newLine();
                }
            }
            if(!sportCars.isEmpty()){
                Iterator<SportCar> sportIterator = sportCars.iterator();

                while(sportIterator.hasNext()){
                    SportCar car = sportIterator.next();

                        bw.write(String.format("%s  %s  %s  %s  %s  %s  %s",
                                car.getColor(),
                                car.getDoors(),
                                car.getWheels(),
                                car.getMileage(),
                                car.getChassisNumber(),
                                car.getBrand(),
                                car.getTypeCar(),
                                car.getSecondsLimit())
                        );
                        bw.newLine();
                    }
            }
        } finally{
            if(bw != null){
                bw.close();
            }
        }

    }
}
