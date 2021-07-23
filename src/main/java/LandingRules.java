import Unit.FlightIdentifier;

import java.util.List;
import java.util.stream.Collectors;

public class LandingRules {


    public Airplane evaluate(Airport airport, List<Airplane> airplanes) {
        FlightIdentifier firstToLand = airport.nextLanding(airplanes);
        List<Airplane> airplaneList = airplanes.stream().filter(airplane -> !airplane.getFlightIdentifier().equals(firstToLand)).collect(Collectors.toList());

        FlightIdentifier secondToland = airport.nextLanding(airplaneList);

        Airplane a1 = airplanes.stream().filter( airplane -> airplane.getFlightIdentifier().equals(firstToLand)).collect(Collectors.toList()).get(0);
        Airplane a2 = airplanes.stream().filter( airplane -> airplane.getFlightIdentifier().equals(secondToland)).collect(Collectors.toList()).get(0);

        if (a1.getFinishTime().equals(a2.finishTime)) {
            airport.approach(airplanes);
            return airport.getProximityAirplane().get(0);
        } else {
            return a1;
        }
    }
}
