import java.util.ArrayList;
import java.util.List;

public class Route {
    private int routeId;
    private Origin origin;
    private List<Intermediate> intermediate;
    private int intermediateId;
    private Destination destination;
    private boolean isDirect;

    public Route(int routeId, Origin origin, int intermediateId,List<Intermediate> intermediate, Destination destination, boolean isDirect) {
        this.origin = origin;
        this.intermediate = intermediate;
        this.destination = destination;
        this.isDirect = isDirect;
        this.intermediateId = intermediateId;
        this.routeId = routeId;

    }

    public Route() {
        origin = new Origin();
        intermediate = new ArrayList<>();
        destination = new Destination();

    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getIntermediateId() {
        return intermediateId;
    }

    public void setIntermediateId(int intermediateId) {
        this.intermediateId = intermediateId;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public List<Intermediate> getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(List<Intermediate> intermediate) {
        this.intermediate = intermediate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public boolean isDirect() {
        if(intermediate.size() == 0){
            isDirect = true;

        }
        else{
            isDirect = false;
        }
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public void addIntermediate(Intermediate _intermediate){
        intermediate.add(_intermediate);
    }
    public void displayRoute(){
        System.out.println("ORIGIN:  Airport: "+origin.getAirport().getName() + ", Departure Time: " +origin.getDepartureTime() );
        System.out.println("DESTINATION:  Airport: "+destination.getAirport().getName() + ", Arrival Time: " +destination.getArrivalTime() );
        if(isDirect() == false){
            System.out.println("INTERMEDIATE AIRPORTS");
            for(int i = 0 ; i < intermediate.size(); i++){
                System.out.println("Airport: "+ intermediate.get(i).getAirport().getName() + ", Arrival Time: " +intermediate.get(i).getArrivalTime() );
            }

        }
    }
}
