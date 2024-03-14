package designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        final Circle circle = new Circle(null);
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "Green";
        shapes.add(circle);

        final Circle circleCopy = (Circle) circle.clone();
        shapes.add(circleCopy);

        final Rectangle rectangle = new Rectangle(null);
        rectangle.height = 5;
        rectangle.width = 5;
        rectangle.color = "Red";
        shapes.add(rectangle);

        final Rectangle rectangleCopy = (Rectangle) rectangle.clone();
        shapes.add(rectangleCopy);

        compareAndClone(shapes, shapesCopy);
    }

    private static void compareAndClone(final List<Shape> shapes, final List<Shape> shapesCopy) {
        shapesCopy.addAll(shapes);
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}
