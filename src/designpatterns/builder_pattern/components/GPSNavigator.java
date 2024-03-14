package designpatterns.builder_pattern.components;

public class GPSNavigator {

    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(final String manualRoute) {
        this.route = manualRoute;
    }
}
