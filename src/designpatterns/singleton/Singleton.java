package designpatterns.singleton;

public class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(final String value) {
        if(value != null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception at Singleton "+e);
            }
            this.value = value;
        }
    }

    public static Singleton getInstance(final String value) {
        if(instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
