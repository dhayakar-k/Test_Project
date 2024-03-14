package designpatterns.prototype;

import java.util.Objects;

public abstract class Shape {

    public int x;
    public int y;
    public String color;

    public Shape(final Shape target) {
        if (target != null) {
            this.x = target.x;
            this.y = target.y;
            this.color = target.color;
        }
    }

    public abstract Shape clone();

    @Override
    public boolean equals(final Object shape) {
        if (!(shape instanceof Shape)) {
            return false;
        }
        final Shape shape2 = (Shape) shape;
        return x == shape2.x && y == shape2.y && Objects.equals(color, shape2.color);
    }

}
