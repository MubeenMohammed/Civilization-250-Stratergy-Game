package Civilization250;
public class Warrior extends MilitaryUnit{
    public Warrior(Tile position, double hp, String faction) {
        super(position, hp, 1, faction, 20.0,1,25);

    }

    @Override
    public boolean equals(Object a) {
        return super.equals(a);
    }

    @Override
    public void takeAction(Tile position) {

    }
}
