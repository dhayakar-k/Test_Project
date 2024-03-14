package jobs;

import java.util.ArrayList;

public class RetainAllExamples {
    public static void main(String[] args) {
        ArrayList<String> bags = new ArrayList<String>();

        // Add values in the bags list.
        bags.add("pen");
        bags.add("pencil");
        bags.add("paper");

        // Creating another array list
        ArrayList<String> boxes = new ArrayList<String>();

        // Add values in the boxes list.
        boxes.add("pen");
        boxes.add("paper");
        boxes.add("books");
        boxes.add("rubber");

        boxes.retainAll(bags);
        System.out.println("Boxes list: "+boxes);
        System.out.println("Bags list: "+bags);
    }
}
