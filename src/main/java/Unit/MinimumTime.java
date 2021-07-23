package Unit;

import Utils.Utils;

public class MinimumTime {
    
    int second;

    public MinimumTime(int second) {
        this.second = Utils.checkZeroValue(second);
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
