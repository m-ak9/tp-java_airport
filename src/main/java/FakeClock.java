import java.time.LocalDateTime;

public class FakeClock implements Clock {
    LocalDateTime date;

    public FakeClock(LocalDateTime date) {
        this.date =  LocalDateTime.of(2021, 07, 23, 14, 05);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
