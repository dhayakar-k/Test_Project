package designpatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class BundledShapeCache {

    private final Map<String, Shape> cache = new HashMap<>();

    public BundledShapeCache() {
        final Circle circle = new Circle(null);
        circle.x = 5;
        circle.y = 10;
        circle.radius = 20;
        circle.color = "Yellow";

        final Rectangle rectangle = new Rectangle(null);
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 10;
        rectangle.height = 10;
        rectangle.color = "Red";

        cache.put("cir", circle);
        cache.put("rect", rectangle);
    }

    public Shape put(final String key, final Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape getShape(final String objKey) {
        return cache.get(objKey).clone();
    }

}
