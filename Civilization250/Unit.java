package Civilization250;
public abstract class Unit {
    private Tile position;
    private double hp;
    private int movingRange;
    private String faction;
    public Unit(Tile position, double hp, int movingRange, String faction) {
        this.position = position;
        this.hp = hp;
        this.movingRange = movingRange;
        this.faction = faction;
        if (!(position.addUnit(this))) {
            throw new IllegalArgumentException("There is an Enemy faction already stationed on the tile");
        }

    }
    public final Tile getPosition() {
        return position;
    }
    public final double getHP() {
        return hp;
    }
    public final String getFaction() {
        return faction;
    }
    public boolean moveTo(Tile newPosition) {
        double distance = Tile.getDistance(position,newPosition);
        if (distance <= movingRange) {
            if (newPosition.addUnit(this)){
                position.removeUnit(this);
                return true;
            }
            return false;
        }
        return false;
    }
    public void receiveDamage(double damage) {
        if (damage > 0) {
            if (position.isCity()) {
                hp = hp - (0.9 * damage);
            }
            else if (!(position.isCity())) {
                hp = hp - damage;
            }
            if (hp < 0) {
                position.removeUnit(this);
            }
        }

    }
    public abstract void takeAction(Tile position);

    public boolean equals(Object a) {
        if (a instanceof Unit) {
            Unit b = (Unit) a;
            if (b.getClass().equals(this.getClass())) {
                if (b.getPosition().equals(this.position) && Math.pow((b.getHP() - hp), 2) < 0.001 && b.getFaction().equals(faction)) {
                    return true;
                }
            }
        }
        return false;
    }
}
