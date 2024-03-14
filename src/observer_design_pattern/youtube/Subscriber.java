package observer_design_pattern.youtube;

public class Subscriber implements Subject {
    private Integer id;
    private String subName;

    public Subscriber(Integer id, String subName) {
        this.id = id;
        this.subName = subName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public void update(String title, String cName, Channel str) {
        System.out.println("Hey "+subName+" a new video, "+title+" has uploaded in "+cName);
    }
}
