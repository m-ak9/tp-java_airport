import Unit.Distance;
import Unit.FlightIdentifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LandingRules {


    public Airplane evaluate(Airport airport, List<Airplane> airplanes) {
        FlightIdentifier firstToLand = findFirstAirplaneToLand(airplanes);
        List<Airplane> airplaneList = airplanes.stream().filter(airplane -> !airplane.getFlightIdentifier().equals(firstToLand)).collect(Collectors.toList());

        FlightIdentifier secondToland = findFirstAirplaneToLand(airplaneList);

        Airplane a1 = airplanes.stream().filter( airplane -> airplane.getFlightIdentifier().equals(firstToLand)).collect(Collectors.toList()).get(0);
        Airplane a2 = airplanes.stream().filter( airplane -> airplane.getFlightIdentifier().equals(secondToland)).collect(Collectors.toList()).get(0);

        if (a1.getFinishTime().equals(a2.finishTime)) {
            approach(airport,airplanes);
            return airport.getProximityAirplane().get(0);
        } else {
            return a1;
        }
    }

    public void approach(Airport airport, List<Airplane> airplanes) {
        List<Airplane> proximityList = new ArrayList<>();
        List<Airplane> result = new ArrayList<>();
        Distance rule = new Distance(5000);
        for (Airplane airplane : airplanes) {
            if (airplane.getCurrentPosition().distance(airport.getPosition()).getKilometer() <= rule.getKilometer())
                result.add(airplane);
        }
        // sort plane in proximity zone
        for (int i = 0 ; i < result.size(); i++) {
            Airplane temp = result.get(0);
            for (Airplane airplane : result) {
                if (airplane.getCurrentPosition().distance(airport.getPosition()).getMeter() < temp.getCurrentPosition().distance(airport.getPosition()).getMeter()) {
                    temp = airplane;
                }
            }
            proximityList.add(temp);
            result.remove(temp);
        }
        airport.setProximityAirplane(proximityList);
    }
    
    private FlightIdentifier findFirstAirplaneToLand(List<Airplane> airplanes) {
        if (airplanes.size() == 0) return null;

        Airplane result = airplanes.get(0);

        for (Airplane airplane : airplanes) {
            if (airplane.getFinishTime().isAfter(LocalDateTime.now()) && airplane.getFinishTime().isBefore(result.getFinishTime())) {
                result = airplane;
            }
        }
        return result.flightIdentifier;
    }
}
