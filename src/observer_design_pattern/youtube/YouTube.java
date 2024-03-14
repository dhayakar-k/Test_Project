package observer_design_pattern.youtube;


import java.util.ArrayList;
import java.util.List;

public class YouTube {

    public static void main(String[] args) {
        Channel channel = new Channel("USA telugu Vlogs");
        List<Subscriber> subscribersList = new ArrayList<>();
        Subscriber subscriber1 = new Subscriber(1, "Dhayakar");
        subscribersList.add(subscriber1);
        Subscriber subscriber2 = new Subscriber(2, "Eshwar");
        subscribersList.add(subscriber2);
        Subscriber subscriber3 = new Subscriber(3, "Naresh");
        subscribersList.add(subscriber3);
        Subscriber subscriber4 = new Subscriber(4, "Pruthvi");
        subscribersList.add(subscriber4);
        Subscriber subscriber5 = new Subscriber(5, "Mahesh");
        subscribersList.add(subscriber5);
        Subscriber subscriber6 = new Subscriber(6, "Jayashanker");
        subscribersList.add(subscriber6);
        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);
        channel.subscribe(subscriber3);
        channel.subscribe(subscriber4);
        channel.subscribe(subscriber5);
        channel.subscribe(subscriber6);
        String newVideo = "How to Apply for H1B Visa in USA";
        channel.notifySubscriber(newVideo);
        channel.unSubscribe(subscriber3);
        channel.unSubscribe(subscriber5);
        channel.unSubscribe(subscriber6);
        newVideo = "Software engineers salary in USA";
        channel.notifySubscriber(newVideo);
    }
}
