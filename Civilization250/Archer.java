package Civilization250;

public class Archer extends MilitaryUnit{
    private int noOfArrows;
    public Archer(Tile position, double hp, String faction) {
        super(position, hp, 2, faction,15.0, 2, 0);
        this.noOfArrows = 5;

    }

    @Override
    public void takeAction(Tile position) {
        if (noOfArrows > 0) {
            super.takeAction(position);
            noOfArrows -= 1;

        }
        else {
            noOfArrows = 5;
        }
    }

    @Override
    public boolean equals(Object a) {
        return super.equals(a);
    }
}
