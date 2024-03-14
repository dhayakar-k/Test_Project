package observer_design_pattern.youtube;

public interface Observer {

    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscriber(String videoTitle);
}
