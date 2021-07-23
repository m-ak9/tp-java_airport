import Unit.FlightIdentifier;
import Unit.FuelLevel;
import Unit.Weight;

import java.time.LocalDateTime;

public class Airplane {
    FlightIdentifier flightIdentifier;
    Position currentPosition;
    LocalDateTime finishTime;
    Weight weight;
    FuelLevel fuelLevel;

    public Airplane(FlightIdentifier flightNumber, Position currentPosition, LocalDateTime finishTime, Weight weight, FuelLevel fuelLevel) {
        this.flightIdentifier = flightNumber;
        this.currentPosition = currentPosition;
        this.finishTime = finishTime;
        this.weight = weight;
        this.fuelLevel = fuelLevel;
    }

    public FlightIdentifier getFlightIdentifier() {
        return flightIdentifier;
    }

    public void setFlightIdentifier(FlightIdentifier flightIdentifier) {
        this.flightIdentifier = flightIdentifier;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public FuelLevel getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(FuelLevel fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
}
