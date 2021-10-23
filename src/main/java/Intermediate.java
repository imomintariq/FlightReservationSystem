import java.util.Date;
import java.util.List;

public class Intermediate {
    private Airport airport;
    private Date arrivalTime;
    private Date departureTime;
    private List<String> nearbyHotels;
    private int parkingLot;

    public Intermediate(Airport airport, Date arrivalTime, Date departureTime, List<String> nearbyHotels, int parkingLot) {
        this.airport = airport;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.nearbyHotels = nearbyHotels;
        this.parkingLot = parkingLot;
    }

    public Intermediate() {

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

    public List<String> getNearbyHotels() {
        return nearbyHotels;
    }

    public void setNearbyHotels(List<String> nearbyHotels) {
        this.nearbyHotels = nearbyHotels;
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(int parkingLot) {
        this.parkingLot = parkingLot;
    }
}
