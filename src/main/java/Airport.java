import java.util.List;

public class Airport {
    String name;
    Position position;
    LandingStripe landingStripe;
    List<Airplane> proximityAirplane;

    public Airport(String name, Position position, LandingStripe landingStripe) {
        this.name = name;
        this.position = position;
        this.landingStripe = landingStripe;
    }

    private void detectProximityAirplane(List<Airplane> allAirplane) {
        allAirplane.forEach( plane -> {
            if (plane.currentPosition.)
        });

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setLandingStripe(LandingStripe landingStripe) {
        this.landingStripe = landingStripe;
    }

    public void setProximityAirplane(List<Airplane> proximityAirplane) {
        this.proximityAirplane = proximityAirplane;
    }
}
