import java.util.List;

public class Airplane {
    private String type;
    private String planeId;
    private boolean isAvailable;
    private int seatCapacity;
    private List<Seat> seatsInfo;


    public Airplane(String type, String planeId, boolean isAvailable, int seatCapacity, List<Seat> seatsInfo) {
        this.type = type;
        this.planeId = planeId;
        this.isAvailable = isAvailable;
        this.seatCapacity = seatCapacity;
        this.seatsInfo = seatsInfo;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public List<Seat> getSeatsInfo() {
        return seatsInfo;
    }

    public void setSeatsInfo(List<Seat> seatsInfo) {
        this.seatsInfo = seatsInfo;
    }
}
