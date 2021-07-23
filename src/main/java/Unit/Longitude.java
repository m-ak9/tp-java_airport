package Unit;

public class Longitude {

    int longitude;

    public Longitude(int longitude) {
        setLongitude(longitude);
    }


    public void setLongitude(int longitude) {
        if (longitude <= -180) {
            this.longitude = -180;
        } else if (longitude >= 180) {
            this.longitude = 180;
        } else {
            this.longitude = longitude;
        }
    }
}
