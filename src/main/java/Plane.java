import java.time.LocalDateTime;

public class Plane {
    String FlightNumber;
    Position currentPosition;
    LocalDateTime finishTime;
    int Weight;
    int fuelLevel;


    public Plane(String flightNumber, Position currentPosition, LocalDateTime finishTime, int weight, int fuelLevel) {
        FlightNumber = flightNumber;
        this.currentPosition = currentPosition;
        this.finishTime = finishTime;
        this.Weight = checkZeroValue(weight);
        this.fuelLevel = checkZeroValue(fuelLevel);
    }


    private int checkZeroValue(int value) {
        return Math.max(value, 0);
    }
}
