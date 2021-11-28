import java.util.Date;
import java.util.List;

public class Intermediate {
    private int id;
    private int airportID;
    private Airport airport;
    private Date arrivalTime;
    private Date departureTime;

    public Intermediate(int airportID, int id, Airport airport, Date arrivalTime, Date departureTime) {
        this.airport = airport;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.id = id;
        this.airportID = airportID;

    }

    public Intermediate() {

    }

    public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


}
