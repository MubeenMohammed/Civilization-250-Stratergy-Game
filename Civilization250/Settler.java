package Civilization250;
public class Settler extends Unit{
    public Settler(Tile position, double hp, String faction) {
        super(position,hp,2,faction);
    }

    @Override
    public void takeAction(Tile position) {
        if (this.getPosition().equals(position)) {
            if (!(position.isCity())) {
                position.buildCity();
                position.removeUnit(this);
            }
        }
    }

    @Override
    public boolean equals(Object a) {
        return super.equals(a);
    }
}
