import Unit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AirportTest {

    LandingRules rules = new LandingRules();

    List<Airplane> airplanes;

    Airplane fighterJet;
    Airplane airbus;

    Airport airport;
    LandingStripe landingStripe;
    Distance distance;
    MinimumTime minimumTime;

    Position position;
    Position fakePosition;
    Position newPosition;

    Altitude altitude;
    Latitude latitude;
    Longitude longitude;

    @BeforeEach
    void setUp() {
        this.altitude = new Altitude(25_000);
        this.latitude = new Latitude(45);
        this.longitude = new Longitude(150);
        this.position = new Position(this.altitude, this.longitude, this.latitude);

        this.altitude = new Altitude(10_000);
        this.latitude = new Latitude(65);
        this.longitude = new Longitude(130);
        this.fakePosition = new Position(this.altitude, this.longitude, this.latitude);

        this.altitude = new Altitude(40000);
        this.latitude = new Latitude(-90);
        this.longitude = new Longitude(-180);
        this.newPosition = new Position(this.altitude, this.longitude, this.latitude);

        this.distance = new Distance(500);
        this.minimumTime = new MinimumTime(120);

        this.landingStripe = new LandingStripe(this.distance, this.minimumTime);
        this.airport = new Airport("mexico", this.position, this.landingStripe);

        this.airplanes = new ArrayList<>();


        FlightIdentifier flightIdentifier = new FlightIdentifier("AB5859");
        LocalDateTime finishDate = LocalDateTime.of(2021, 07, 23, 15, 35);
        Weight weight = new Weight(8);
        FuelLevel fuelLevel = new FuelLevel(500);
        this.airbus = new Airplane(flightIdentifier, this.fakePosition, finishDate, weight, fuelLevel);

        flightIdentifier = new FlightIdentifier("FG896");
        finishDate = LocalDateTime.of(2021, 07, 23, 16, 35);
        weight = new Weight(5);
        fuelLevel = new FuelLevel(400);
        this.fighterJet = new Airplane(flightIdentifier, this.newPosition, finishDate, weight, fuelLevel);

    }

    @Test
    void distanceTest() {
        this.altitude = new Altitude(25_000);
        this.latitude = new Latitude(45);
        this.longitude = new Longitude(150);

        this.position = new Position(this.altitude, this.longitude, this.latitude);

        this.altitude = new Altitude(10_000);
        this.latitude = new Latitude(65);
        this.longitude = new Longitude(130);

        this.fakePosition = new Position(this.altitude, this.longitude, this.latitude);

        Assertions.assertEquals(1577, this.position.distance(this.fakePosition).getMeter());
    }

    @Test
    void should_add_airbus_because_of_the_proximity_to_the_airport() {

        this.airplanes.add(this.airbus);
        rules.approach(airport,airplanes);
        Assertions.assertEquals(this.airplanes.get(0).flightIdentifier.getValue(), this.airport.getProximityAirplane().get(0).flightIdentifier.getValue());
    }

    @Test
    void should_not_add_fighter_because_of_the_proximity_to_the_airport() {
        this.airplanes.add(this.fighterJet);


        rules.approach(airport,airplanes);

        List<Airplane> emptyList = new ArrayList<>();
        Assertions.assertEquals(emptyList, this.airport.getProximityAirplane());
    }

}
