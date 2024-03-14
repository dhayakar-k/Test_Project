package acl;

import java.util.List;

public class Ammu {
    public static void main(String[] args) {
        List<String> names = List.of("Dhaya","Harika","Ammu","Pinky","Chinnari","Bhanu");
        names.forEach(name->{
            System.out.println("Name is :"+name);
        });
        int a = 5;
        int b = 6;
        System.out.println(a+b);
        String name = "ammu";
        String name1 = "dhaya";
        String name2 = "pinky";
        String name3 = "bhanu";
        names.forEach(name12-> {
            if (name12.equals("Ammu")) {
                System.out.println("I am Ammu");
            } else {
                System.out.println("Other people");
            }
        });
    }
}
