package designpatterns.singleton;

public class DemoSingleThread {
    public static void main(String[] args) {
        System.out.println("If you see the same value then, singleton was reused (yay!)" + "\n" +
                "If you see 2 different values, then two singletons were created (booo!!) "+ "\n\n"+
                "Result:"+"\n");
        final Singleton singleton = Singleton.getInstance("FOO");
        final Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
