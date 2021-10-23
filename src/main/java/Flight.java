public class Flight {
    private String flightId;
    private String flightName;
    private Airplane airplane;
    private Route route;
    private boolean isDeparted;
    private boolean hasLanded;


    public Flight() {
        route = new Route();
    }

    public Flight(String flightId, String flightName, Airplane airplane, Route route) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.airplane = airplane;
        this.route = route;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public boolean isDeparted() {
        return isDeparted;
    }

    public void setDeparted(boolean departed) {
        isDeparted = departed;
    }

    public boolean isHasLanded() {
        return hasLanded;
    }

    public void setHasLanded(boolean hasLanded) {
        this.hasLanded = hasLanded;
    }

    public void displayFlight(){
        System.out.println("Flight ID: "+ flightId + ", Flight Name: "+ flightName + ", Airplane: "+ airplane.getPlaneId() );
        route.displayRoute();
        System.out.println("Is departed" + isDeparted);
        System.out.println("has Landed" + hasLanded);
    }


}
