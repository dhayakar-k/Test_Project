package designpatterns.prototype;


public class Rectangle extends Shape {

    public int width;
    public int height;

    public Rectangle(final Rectangle rectangle) {
        super(rectangle);
        if (rectangle != null) {
            this.width = rectangle.width;
            this.height = rectangle.height;
        }
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Rectangle) || !super.equals(o)) {
            return false;
        }
        final Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width:" + width +
                ", height:" + height +
                ", x:" + x +
                ", y:" + y +
                ", color:'" + color + '\'' +
                '}';
    }
}
