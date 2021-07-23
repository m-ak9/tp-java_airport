import Unit.FlightIdentifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    String name;
    Position position;
    LandingStripe landingStripe;
    List<Airplane> proximityAirplane;
    LandingRules landingRules;

    public Airport(String name, Position position, LandingStripe landingStripe) {
        this.name = name;
        this.position = position;
        this.landingStripe = landingStripe;
        this.proximityAirplane = new ArrayList<>();
        this.landingRules = new LandingRules();
    }

    public FlightIdentifier nextLanding(List<Airplane> airplanes) {
        return landingRules.evaluate(this,airplanes).getFlightIdentifier();
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

    public List<Airplane> getProximityAirplane() {
        return proximityAirplane;
    }

    public Position getPosition() {
        return position;
    }
}
