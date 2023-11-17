package Civilization250;
public class Worker extends Unit {
    private int jobsPerformed;
    public Worker(Tile position, double hp, String faction) {
        super(position,hp,2,faction);
        jobsPerformed = 0;
    }

    @Override
    public void takeAction(Tile position) {
        if (this.getPosition().equals(position)) {
            if (!(position.isImproved())) {
                position.buildImprovement();
                jobsPerformed += 1;
                if (jobsPerformed == 10) {
                    position.removeUnit(this);
                }
            }
        }
    }

    @Override
    public boolean equals(Object a) {
        return super.equals(a);
    }
}
