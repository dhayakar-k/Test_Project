package designpatterns.builder_pattern.builders;

import designpatterns.builder_pattern.cars.CarType;
import designpatterns.builder_pattern.components.Engine;
import designpatterns.builder_pattern.components.GPSNavigator;
import designpatterns.builder_pattern.components.Transmission;
import designpatterns.builder_pattern.components.TripComputer;

public interface Builder {
   void setCarType(final CarType type);
   void setSeats(final int seats);
   void setEngine(final Engine engine);
   void setTransmission(final Transmission transmission);
   void setTripComputer(final TripComputer tripComputer);
   void setGpsNavigator(final GPSNavigator gpsNavigator);
}
