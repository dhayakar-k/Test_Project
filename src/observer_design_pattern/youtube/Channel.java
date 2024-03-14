package observer_design_pattern.youtube;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Observer {

    private final String channelName;
    private final List<Subscriber> subscriberList ;

    public Channel(String channelName) {
        this.subscriberList = new ArrayList<>();
        this.channelName = channelName;
        displayChannelName();
    }

    public void displayChannelName() {
        System.out.println("-------- Welcome to  "+channelName+" ME TELUGU VARI CHANNEL--------");
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
       subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscriber(String videoTitle) {
        subscriberList.forEach(subscriber -> subscriber.update(videoTitle, this.channelName, this));
    }
}
