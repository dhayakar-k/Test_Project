package designpatterns.builder_pattern.builders;

import designpatterns.builder_pattern.cars.Car;
import designpatterns.builder_pattern.cars.CarType;
import designpatterns.builder_pattern.components.Engine;
import designpatterns.builder_pattern.components.GPSNavigator;
import designpatterns.builder_pattern.components.Transmission;
import designpatterns.builder_pattern.components.TripComputer;

public class CarBuilder implements Builder {
    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(final CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(final int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(final Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(final Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(final TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGpsNavigator(final GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(carType, seats, engine, transmission, tripComputer, gpsNavigator);
    }

}
