package designpatterns.builder_pattern.components;

public class Engine {
    private final double volume;
    private double mileage;
    private boolean started;

    public Engine(final double volume, final double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        this.started = true;
    }

    public void off() {
        this.started = false;
    }

    public double getMileage() {
        return mileage;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isStarted() {
        return started;
    }

    public void go(final double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            System.out.println("Cannot go, you must start the engine first");
        }
    }
}
