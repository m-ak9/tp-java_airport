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
            if (airplane.getFinishTime().isAfter(LocalDateTime.now()) && airplane.getFinishTime().isBefore(result.getFinishTime())) {
                result = airplane;
            }
        }
        return result.flightIdentifier;
    }

    public void approach(List<Airplane> airplanes) {
        List<Airplane> result = new ArrayList<>();
        Distance rule = new Distance(5000);
        for (Airplane airplane : airplanes) {
            if (airplane.getCurrentPosition().distance(this.position).getKilometer() <= rule.getKilometer())
                result.add(airplane);
        }
        // sort plane in proximity zone
        for (int i = 0 ; i < result.size(); i++) {
            Airplane temp = result.get(0);
            for (Airplane airplane : result) {
                if (airplane.getCurrentPosition().distance(this.position).getMeter() < temp.getCurrentPosition().distance(this.position).getMeter()) {
                    temp = airplane;
                }
            }
            this.proximityAirplane.add(temp);
            result.remove(temp);
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
