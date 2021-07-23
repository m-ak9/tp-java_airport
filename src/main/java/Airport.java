import Unit.Distance;
import Unit.FlightIdentifier;

import java.time.LocalDateTime;
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

    public FlightIdentifier nextLanding(List<Airplane> airplanes) {
        if (airplanes.size() == 0) return null;

        Airplane result = airplanes.get(0);

        for (Airplane airplane : airplanes) {
            if (airplane.getFinishTime().isAfter(LocalDateTime.now()) && airplane.getFinishTime().isBefore(result.getFinishTime()))
                result = airplane;
        }

        return result.flightIdentifier;
    }

    public void approach(Airplane airplane) {
        Distance rule = new Distance(5000);
        if (airplane.getCurrentPosition().distance(this.position).getKilometer() <= rule.getKilometer())
            this.proximityAirplane.add(airplane);
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
