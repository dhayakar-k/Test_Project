package acl;

public class Harika {
    public static void main(String[] args) {
        String actualName = "Dhayakar";
        String ExpectedName = "Harika";
        if (actualName.equalsIgnoreCase(ExpectedName)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(actualName.equalsIgnoreCase(ExpectedName));

    }
}
