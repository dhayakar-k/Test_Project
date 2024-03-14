package designpatterns.builder_pattern.student;

public class BuilderDemo {
    public static void main(String[] args) {
        final StudentReceiver studentReceiver = new StudentReceiver();
        System.out.println(studentReceiver.getStudent());
    }
}
