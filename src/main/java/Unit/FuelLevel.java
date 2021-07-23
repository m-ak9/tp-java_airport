package Unit;

import Utils.Utils;

public class FuelLevel {

    int liter;

    public FuelLevel(int liter) {
        this.liter = Utils.checkZeroValue(liter);
    }

    public int getLiter() {
        return liter;
    }
}
