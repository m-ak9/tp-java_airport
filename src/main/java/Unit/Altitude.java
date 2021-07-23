package Unit;

public class Altitude {

    int altitude;

    public Altitude(int altitude) {
        setAltitude(altitude);
    }

    public void setAltitude(int altitude) {
        if (altitude <= 0) {
            this.altitude = 0;
        } else if (altitude >=40000) {
            this.altitude = 40000;
        } else {
            this.altitude = altitude;
        }
    }

    public int getAltitude() {
        return altitude;
    }
}
