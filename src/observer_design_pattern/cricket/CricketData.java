package observer_design_pattern.cricket;

import java.util.ArrayList;

public class CricketData implements Subject {

    int runs;
    int wickets;
    float overs;
    ArrayList<Observer> observerList;

    public CricketData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
         observerList.forEach(observer -> observer.update(runs, wickets, overs));
    }
    private int getLatestRuns() {
        // In real world scenario get dynamic data and return
        return 100;
    }
    private int getLatestWickets() {
        // In real world scenario get dynamic data and return
        return 2;
    }
    private float getLatestOvers() {
        // In real world scenario get dynamic data and return
        return (float) 10.2;
    }
    public void dataChanged() {
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
        notifyObservers();
    }
}
