package Civilization250;
public class Tile {
    private int xCoordinate;
    private int yCoordinate;
    private boolean cityBuilt;
    private boolean improvements;
    private ListOfUnits allUnits;
    public Tile(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.allUnits = new ListOfUnits();
    }
    public int getX() {
        return xCoordinate;
    }
    public int getY() {
        return yCoordinate;

    }
    public boolean isCity() {
        return cityBuilt;
    }
    public boolean isImproved() {
        return improvements;

    }
    public void buildCity() {
        this.cityBuilt = true;
    }
    public void buildImprovement() {
        this.improvements = true;
    }
    public boolean addUnit(Unit a) {
        if (a instanceof MilitaryUnit){
            MilitaryUnit[] armyList = allUnits.getArmy();
            for (int i =0; i < armyList.length; i++ ) {
                if (!(a.getFaction().equals(armyList[i].getFaction()))) {
                    return false;
                }
            }
        }
        allUnits.addUnit(a);
        return true;

    }
    public boolean removeUnit(Unit a) {
        return allUnits.removeUnit(a);
    }
    public Unit selectWeakEnemy(String faction) {
        int index = 0;
        double lowestHp = 100;
        lowestHp = allUnits.getList()[0].getHP();
        for (int i = 0; i < allUnits.getSize(); i++) {
            if (!(allUnits.getList()[i].getFaction().equals(faction))){
                if (allUnits.getList()[i].getHP() < lowestHp) {
                    index = i;
                    lowestHp = allUnits.getList()[i].getHP();
                }
            }
        }
        return allUnits.getUnit(index);

    }
    public static double getDistance(Tile a, Tile b) {
        int x1 = a.xCoordinate;
        int y1 = a.yCoordinate;
        int x2 = b.xCoordinate;
        int y2 = b.yCoordinate;
        double distance = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
        return distance;
    }


}
