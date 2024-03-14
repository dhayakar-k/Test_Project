package designpatterns.prototype;


public class Circle extends Shape {
    public int radius;

    public Circle(final Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Circle) || !super.equals(o)) {
            return false;
        }
        final Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius:" + radius +
                ", x:" + x +
                ", y:" + y +
                ", color:'" + color + '\'' +
                '}';
    }
}
