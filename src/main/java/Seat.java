public class Seat {
    private String seatId;
    private boolean seatOccupied;
    private String passportNumber;
    private String classType;
    private int luggageInPounds;

    public Seat(String seatId, boolean seatOccupied, String passportNumber, String classType, int luggageInPounds) {
        this.seatId = seatId;
        this.seatOccupied = seatOccupied;
        this.passportNumber = passportNumber;
        this.classType = classType;
        this.luggageInPounds = luggageInPounds;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public boolean isSeatOccupied() {
        return seatOccupied;
    }

    public void setSeatOccupied(boolean seatOccupied) {
        this.seatOccupied = seatOccupied;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getLuggageInPounds() {
        return luggageInPounds;
    }

    public void setLuggageInPounds(int luggageInPounds) {
        this.luggageInPounds = luggageInPounds;
    }

}
