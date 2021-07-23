import Unit.Utils;

import java.time.LocalDateTime;

public class Airplane {
    String FlightNumber;
    Position currentPosition;
    LocalDateTime finishTime;
    int Weight;
    int fuelLevel;


    public Airplane(String flightNumber, Position currentPosition, LocalDateTime finishTime, int weight, int fuelLevel) {
        FlightNumber = flightNumber;
        this.currentPosition = currentPosition;
        this.finishTime = finishTime;
        this.Weight = Utils.checkZeroValue(weight);
        this.fuelLevel = Utils.checkZeroValue(fuelLevel);
    }



}
