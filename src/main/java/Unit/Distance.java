package Unit;

import Utils.Utils;

public class Distance {

    int meter;

    public Distance(int meter) {
        this.meter = Utils.checkZeroValue(meter);
    }

    public int getMeter() {

        return meter;
    }

    public int getKilometer() {

        return meter/1000;
    }
}
