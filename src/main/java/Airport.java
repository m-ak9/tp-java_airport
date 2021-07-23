import Unit.Distance;
import Unit.FlightIdentifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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
        this.proximityAirplane = new ArrayList<>();
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

    public void approach((List<Airplane> airplanes) {
        Distance rule = new Distance(5000);
        for (Airplane airplane: airplanes) {
            if (airplane.getCurrentPosition().distance(this.position).getKilometer() <= rule.getKilometer())
                this.proximityAirplane.add(airplane);
        }
        List<Airplane> result = new ArrayList<>();
        for (Airplane airplane: this.proximityAirplane) {
            Airplane temp;
            if (airplane.getCurrentPosition().distance(this.))

        }
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
}
