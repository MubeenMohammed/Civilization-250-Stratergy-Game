package Civilization250;
public abstract class MilitaryUnit extends Unit {
    private double attackDamage;
    private int attackRange;
    private int armor;
    public MilitaryUnit(Tile position, double hp, int movingRange, String faction, double attackDamage, int attackRange, int armor) {
        super(position,hp,movingRange,faction);
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.armor = armor;
    }

    @Override
    public void takeAction(Tile position) {
       if (Tile.getDistance(this.getPosition(),position) <= attackRange) {
           Unit enemy = position.selectWeakEnemy(this.getFaction());
           if (enemy != null) {
               if (this.getPosition().isImproved()) {
                   enemy.receiveDamage(attackDamage * 1.05);
               }
               enemy.receiveDamage(attackDamage);
           }
       }
    }

    @Override
    public void receiveDamage(double damage) {
        double multiplier = 100.0/(100+armor);
        double newDamage = damage * multiplier;
        super.receiveDamage(newDamage);
    }
}
