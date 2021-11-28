import java.util.Date;
import java.util.List;

public class Destination {
    private int airportID;
    private Airport airport;
    private Date arrivalTime;



    public Destination(int airportID, Airport airport, Date arrivalTime) {
        this.airportID = airportID;
        this.airport = airport;
        this.arrivalTime = arrivalTime;
    }

    public Destination() {

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

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
