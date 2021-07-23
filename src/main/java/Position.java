import Unit.Altitude;
import Unit.Latitude;
import Unit.Longitude;

public class Position {

    Altitude altitude;
    Longitude longitude;
    Latitude      latitude;

    public Position(Altitude altitude, Longitude longitude, Latitude latitude) {
        this.altitude = altitude;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public Altitude getAltitude() {
        return altitude;
    }

    public void setAltitude(Altitude altitude) {
        this.altitude = altitude;
    }

    public Longitude getLongitude() {
        return longitude;
    }

    public void setLongitude(Longitude longitude) {
        this.longitude = longitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public void setLatitude(Latitude latitude) {
        this.latitude = latitude;
    }
}
