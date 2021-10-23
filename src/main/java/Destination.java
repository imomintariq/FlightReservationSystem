import java.util.Date;
import java.util.List;

public class Destination {
    private Airport airport;
    private Date arrivalTime;
    private List<String> nearbyHotels;
    private int parkingLot;

    public Destination(Airport airport, Date arrivalTime, List<String> nearbyHotels, int parkingLot) {
        this.airport = airport;
        this.arrivalTime = arrivalTime;
        this.nearbyHotels = nearbyHotels;
        this.parkingLot = parkingLot;
    }

    public Destination() {

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
