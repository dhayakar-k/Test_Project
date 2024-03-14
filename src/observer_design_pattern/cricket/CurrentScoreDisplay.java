package observer_design_pattern.cricket;

public class CurrentScoreDisplay implements Observer {

    private int runs, wickets;
    private float overs;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }

    private void display() {
        System.out.println("\n Current score display:\n"+
                "Score : "+this.runs+" Wickets: "+wickets+" overs:"+this.overs);
    }
}
