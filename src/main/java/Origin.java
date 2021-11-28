import java.sql.Time;
import java.util.Date;

public class Origin {
    private Airport airport;
    private int airportID;
    private Date departureTime;

    public Origin(int airportID, Airport airport, Date arrivalTime) {
        this.airportID = airportID;
        this.airport = airport;
        this.departureTime = arrivalTime;

    }

    public Origin() {
    }

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date arrivalTime) {
        this.departureTime = arrivalTime;
    }
}
