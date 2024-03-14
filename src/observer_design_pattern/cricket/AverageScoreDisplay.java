package observer_design_pattern.cricket;

public class AverageScoreDisplay implements Observer {

    private float runRate;
    private int predictedScore;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runRate = (float) runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();
    }
    private void display() {
        System.out.println("\n Average score display: \n"
                          +"Run rate "+runRate+"\n predicted score: "+predictedScore);
    }
}
