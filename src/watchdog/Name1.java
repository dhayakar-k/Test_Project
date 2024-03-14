package watchdog;

public class Name1 {
    private int id;
    private String name;

    public Name1(Name2 name2) {
        this.id = name2.getcId();
        this.name = name2.getcName();
        display();
    }

    @Override
    public String toString() {
        return "Name1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private void display() {

        System.out.println(this.toString());
    }
}
