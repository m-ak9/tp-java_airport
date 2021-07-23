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

    public Distance calculateDistance(Position to) {
            if ((this.latitude == to.latitude) && (this.longitude == to.longitude)) {
                return new Distance(0) ;
            }
            else {
                double theta = lon1 - lon2;
                double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
                dist = Math.acos(dist);
                dist = Math.toDegrees(dist);
                dist = dist * 60 * 1.1515;
                if (unit.equals("K")) {
                    dist = dist * 1.609344;
                } else if (unit.equals("N")) {
                    dist = dist * 0.8684;
                }
                return (dist);
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
