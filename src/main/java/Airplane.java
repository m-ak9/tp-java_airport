import Unit.FuelLevel;
import Unit.Weight;

import java.time.LocalDateTime;

public class Airplane {
    String FlightNumber;
    Position currentPosition;
    LocalDateTime finishTime;
    Weight weight;
    FuelLevel fuelLevel;


    public Airplane(String flightNumber, Position currentPosition, LocalDateTime finishTime, Weight weight, FuelLevel fuelLevel) {
        FlightNumber = flightNumber;
        this.currentPosition = currentPosition;
        this.finishTime = finishTime;
        this.weight = weight;
        this.fuelLevel = fuelLevel;
    }



}
