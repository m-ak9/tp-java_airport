package Unit;

public class Latitude {
    int latitude;

    public Latitude(int latitude) {
        setLatitude(latitude);
    }

    public void setLatitude(int latitude) {
        if (latitude <= -90) {
            this.latitude = -90;
        } else if (latitude >= 90) {
            this.latitude = 90;
        } else {
            this.latitude = latitude;
        }
    }
}
