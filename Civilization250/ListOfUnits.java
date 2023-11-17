package Civilization250;
public class ListOfUnits {
    private Unit[] listOfUnits;
    private int sizeOfList;
    public ListOfUnits() {
        listOfUnits = new Unit[sizeOfList];
    }
    public int getSize() {
        return sizeOfList;
    }
    public Unit[] getList() {
        Unit[] newList = new Unit[sizeOfList];
        for (int i = 0; i < sizeOfList; i++) {
            newList[i] = this.listOfUnits[i];
        }
        return newList;
    }
    public Unit getUnit(int a) {
        if (a < 0 || a >= sizeOfList) {
            throw new IndexOutOfBoundsException();
        }
        else {
            return listOfUnits[a];
        }
    }
    public void addUnit(Unit a) {
        sizeOfList += 1;
        Unit[] newList = new Unit[sizeOfList];
        if (listOfUnits.length > 0) {
            for (int i = 0; i < listOfUnits.length; i++) {
                newList[i] = listOfUnits[i];
            }
        }
        newList[sizeOfList-1] = a;
        listOfUnits = newList;


    }
    public int indexOf(Unit a){
        for (int i = 0; i < sizeOfList; i++) {
            if (listOfUnits[i].equals(a)) {
                return i;
            }
        }
        return -1;
    }
    public boolean removeUnit(Unit a) {
        int firstOccurrence = indexOf(a);
        if (firstOccurrence != -1) {
            Unit[] newList = new Unit[sizeOfList - 1];
            for (int i = 0; i < sizeOfList; i++) {
                if (i != firstOccurrence) {
                    newList[i] = listOfUnits[i];
                }
            }
            listOfUnits = newList;
            sizeOfList -= 1;
            return true;

        }
        else {
            return false;
        }
    }
    public MilitaryUnit[] getArmy() {
        int noOfMilitaryUnits = 0;
        for ( int i = 0; i < sizeOfList; i++) {
            if (listOfUnits[i] instanceof MilitaryUnit) {
                noOfMilitaryUnits++;

            }
        }
        MilitaryUnit[] militaryList = new MilitaryUnit[noOfMilitaryUnits];
        int y = 0;
        for ( int i = 0; i < sizeOfList; i++) {
            if (listOfUnits[i] instanceof MilitaryUnit) {
                militaryList[y] = (MilitaryUnit) listOfUnits[i];
                y++;

            }
        }
        return militaryList;

    }

}
