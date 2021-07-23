import Unit.Altitude;
import Unit.Latitude;
import Unit.Longitude;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {

    Position position;
    Position fakePosition;

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
}
