package designpatterns.builder_pattern.director;

import designpatterns.builder_pattern.builders.Builder;
import designpatterns.builder_pattern.cars.CarType;
import designpatterns.builder_pattern.components.Engine;
import designpatterns.builder_pattern.components.GPSNavigator;
import designpatterns.builder_pattern.components.Transmission;
import designpatterns.builder_pattern.components.TripComputer;

public class Director {
    public void constructSportsCar(final Builder sportsCar) {
        sportsCar.setCarType(CarType.SPORTS_CAR);
        sportsCar.setSeats(2);
        sportsCar.setEngine(new Engine(3.0, 0));
        sportsCar.setTransmission(Transmission.SEMI_AUTOMATIC);
        sportsCar.setTripComputer(new TripComputer());
        sportsCar.setGpsNavigator(new GPSNavigator());
    }

    public void constructCityCar(final Builder cityCar) {
        cityCar.setCarType(CarType.CITY_CAR);
        cityCar.setSeats(4);
        cityCar.setEngine(new Engine(1.2, 0));
        cityCar.setTransmission(Transmission.AUTOMATIC);
        cityCar.setTripComputer(new TripComputer());
        cityCar.setGpsNavigator(new GPSNavigator());
    }

    public void constructSUV(final Builder suv) {
        suv.setCarType(CarType.SUV);
        suv.setSeats(4);
        suv.setEngine(new Engine(2.5, 0));
        suv.setTransmission(Transmission.MANUAL);
        suv.setGpsNavigator(new GPSNavigator());
    }
}
