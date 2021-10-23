import java.sql.Time;
import java.util.Date;

public class Origin {
    private Airport airport;
    private Date departureTime;
    private int parkingLot;

    public Origin(Airport airport, Date arrivalTime, int parkingLot) {
        this.airport = airport;
        this.departureTime = arrivalTime;
        this.parkingLot = parkingLot;
    }

    public Origin() {

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

    public int getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(int parkingLot) {
        this.parkingLot = parkingLot;
    }
}
