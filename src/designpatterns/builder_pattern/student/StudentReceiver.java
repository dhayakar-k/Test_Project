package designpatterns.builder_pattern.student;

public class StudentReceiver {
    // Volatile student instance to ensure visibility
    // Of shared reference to immutable objects
    private volatile Student student;

    public StudentReceiver() {
        Thread t1 = new Thread(() -> student = Student.Builder.getInstance().setId(10).setName("Dhayakar").setAddress("Wanaparthy").build());
        Thread t2 = new Thread(() -> student = Student.Builder.getInstance().setId(20).setName("Viru").setAddress("Delhi").build());
        t1.start();
        t2.start();
    }
    public Student getStudent() {
        return student;
    }
}
