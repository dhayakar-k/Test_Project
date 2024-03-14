package designpatterns.builder_pattern.cars;

import designpatterns.builder_pattern.components.Engine;
import designpatterns.builder_pattern.components.GPSNavigator;
import designpatterns.builder_pattern.components.Transmission;
import designpatterns.builder_pattern.components.TripComputer;

public class Manual {
    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public Manual(final CarType carType, final int seats, final Engine engine, final Transmission transmission,
                  final TripComputer tripComputer, final GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "Type of Car - "+ this.carType + "\n";
        info += "Number of Seats - "+ this.seats + "\n";
        info += "Engine: volume - "+ this.engine.getVolume() +"; mileage -" + this.engine.getMileage() + "\n";
        info += "Transmission - "+ this.transmission +"\n";
        if(this.tripComputer != null) {
            info += "Trip Computer: functional "+ "\n";
        } else {
            info += "Trip Computer: N/A"+ "\n";
        }
       if (this.gpsNavigator != null) {
           info += "Gps Navigator is functional "+ "\n";
       } else {
           info += "GPS Navigator: N/A" + "\n";
       }
       return info;
    }
}
