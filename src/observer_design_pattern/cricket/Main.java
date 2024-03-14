package observer_design_pattern.cricket;


public class Main {
    public static void main(String[] args) {
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
        // pass the displays to cricket data
        CricketData cricketData = new CricketData();

        // register display elements
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        // this can be added based on some dynamic data that changes
        cricketData.dataChanged();
        // remove an observer
        cricketData.unRegisterObserver(averageScoreDisplay);
        cricketData.dataChanged();
    }
}
