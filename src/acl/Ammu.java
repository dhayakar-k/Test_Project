package acl;

import java.util.List;

public class Ammu {
    public static void main(String[] args) {
        List<String> names = List.of("Dhaya","Harika","Ammu","Pinky","Chinnari","Bhanu");
        names.forEach(name->{
            System.out.println("Name is :"+name);
        });
        names.forEach(name1-> {
            if (name1.equals("Ammu")) {
                System.out.println("I am Ammu");
            } else {
                System.out.println("Other people");
            }
        });
    }
}
