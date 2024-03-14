package designpatterns.prototype;

public class Demo1 {
    public static void main(String[] args) {
        BundledShapeCache cache = new BundledShapeCache();
        Shape shape1 = cache.getShape("cir");
        Shape shape2 = cache.getShape("rect");
        Shape shape3 = cache.getShape("rect");

        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Big Yellow Circle != Medium Red rectangle (yay!)");
        } else {
            System.out.println("Big Yellow Circle != Medium Red rectangle (boo!)");
        }

        if (shape2 != shape3) {
            System.out.println("Medium Red rectangles are two different objects (yay!)");
            if (shape2.equals(shape3)) {
                System.out.println("And they are identical (yay!)");
            } else {
                System.out.println("But they are not identical (booo!)");
            }
        } else {
            System.out.println("Rectangle objects are the same (booo!)");
        }
    }
}
