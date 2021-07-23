package Unit;

import Utils.Utils;

public class Weight {

    int weight;

    public Weight(int weight) {
        this.weight = Utils.checkZeroValue(weight);
    }

    public int getWeight() {
        return weight;
    }
}
