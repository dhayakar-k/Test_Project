package designpatterns.builder_pattern;

import designpatterns.builder_pattern.builders.CarBuilder;
import designpatterns.builder_pattern.builders.CarManualBuilderPattern;
import designpatterns.builder_pattern.cars.Car;
import designpatterns.builder_pattern.cars.Manual;
import designpatterns.builder_pattern.director.Director;

public class Demo {

    public static void main(String[] args) {

        final Director director = new Director();

        final CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);

        final Car car = carBuilder.getResult();
        System.out.println("Car built:\n "+car.getCarType());

        final CarManualBuilderPattern carManualBuilderPattern = new CarManualBuilderPattern();
        director.constructSportsCar(carManualBuilderPattern);

        final Manual manualCar = carManualBuilderPattern.getResult();
        System.out.println("\n Car manual built: \n"+manualCar.print());

    }
}
