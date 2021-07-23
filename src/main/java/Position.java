import Unit.Altitude;
import Unit.Distance;
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

    public Distance distance(Position to) {
            if ((this.latitude.getLatitude() == to.latitude.getLatitude()) && (this.longitude.getLongitude() == to.longitude.getLongitude())) {
                return new Distance(0) ;
            }
            else {
                double theta = this.longitude.getLongitude() - to.longitude.getLongitude();
                double dist = Math.sin(Math.toRadians(this.latitude.getLatitude())) * Math.sin(Math.toRadians(to.latitude.getLatitude())) + Math.cos(Math.toRadians(this.latitude.getLatitude())) * Math.cos(Math.toRadians(to.latitude.getLatitude())) * Math.cos(Math.toRadians(theta));
                dist = Math.acos(dist);
                dist = Math.toDegrees(dist);
                dist = dist * 60 * 1.1515;
                return new Distance((int) Math.floor(dist));
            }
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
