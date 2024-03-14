package acl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Car {
    private static final int CRTL_CHAR = 32;
    public static void main(String[] args) {
        int ch = -1;
        int expected = 1024;
        checkAndExit(ch, expected);
        List<String> values = new ArrayList<>();
        values.add("Orange");
        values.add("Banana");
        values.add("Grapes");
        List<String> valuesCopy = new ArrayList<>();
        valuesCopy.add("Orange");
        valuesCopy.add("Banana");
        valuesCopy.add("Grapes");
        List<String> commonList = new ArrayList<>(values);
        commonList.retainAll(valuesCopy);
        System.out.println(values);
        System.out.println(commonList);
    }

    private static void checkAndExit(int ch, int expected) {
        while (expected > 0) {
            if (ch < CRTL_CHAR) {
                break;
            }
            expected --;
        }
    }
}
