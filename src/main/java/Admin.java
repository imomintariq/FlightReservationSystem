import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Admin extends User{

    public Admin(String username, String password, String firstName, String lastName, String gender, Date dateOfBirth, String address, String email, String phoneNumber) {
        super(username, password, firstName, lastName, gender, dateOfBirth, address, email, phoneNumber);
    }
    public Date getDateAndTime() throws ParseException {
        //Exception handling daalni hai issmein abhi
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter date: dd/mm/yyyy");
        String date = sc.nextLine();
        System.out.println("Enter time: hh:mm:ss");
        String time = sc.nextLine();

        String sDate = date+ " "+ time;

        Date date1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(sDate);
        return date1;
    }

    public Flight addFlight(List<Airplane> airplaneList, List<Airport> airportList) throws ParseException {
        Flight _flight = new Flight();

        Scanner sc= new Scanner(System.in);

        //Setting Flight ID
        System.out.println("Enter A Flight ID:");
        String id= sc.nextLine();
        _flight.setFlightId(id);

        //Setting Flight Name
        System.out.println("Enter a Flight Name:");
        String fName = sc.nextLine();
        _flight.setFlightName(fName);


        //Setting Plane for flight
        int count = 1;
        System.out.println("Available Planes:");
        for(int i = 0; i < airplaneList.size(); i++ ){
            if(airplaneList.get(i).isAvailable()) {
                System.out.println(count + ". Plane ID: " + airplaneList.get(i).getPlaneId()+ ", Plane Type: "+ airplaneList.get(i).getType() + ", Plane Capacity: " + airplaneList.get(i).getSeatCapacity()+ "\n");
                count++;
            }
        }
        System.out.println("Select Any plane from above:");
        int plane = sc.nextInt();
        if (plane - 1 >= airplaneList.size()) {
            while (plane - 1 >= airplaneList.size()) {
                System.out.println("Select Any plane from above:\n");
                plane = sc.nextInt();
            }

        }
        _flight.setAirplane(airplaneList.get(plane - 1));
        airplaneList.get(plane - 1).setAvailable(false);

        //Creating Flight Route
        count = 1;
        System.out.println("Airports Available:");
        for(int i = 0; i < airportList.size(); i++ ){
            System.out.println(count + ". Airport ID: "+ airportList.get(i).getAirportCode() + ", Airport Name: "+ airportList.get(i).getName() + ", Airport City: " + airportList.get(i).getCity() + ", Airport State: "+ airportList.get(i).getState() + ", Airport Country: " + airportList.get(i).getCountry()+"\n");
            count++;
        }
        //Selecting Origin Airport
        System.out.println("Selecting Origin:");
        int originAirport = sc.nextInt();
        if (originAirport - 1 >= airportList.size()) {
            while (originAirport - 1 >= airportList.size()) {
                System.out.println("Select Any Airport for Origin:\n");
                originAirport = sc.nextInt();
            }
        }
        _flight.getRoute().getOrigin().setAirport(airportList.get(originAirport - 1));
        System.out.println("Enter Time for departure:");
        _flight.getRoute().getOrigin().setDepartureTime(getDateAndTime());
        System.out.println("Enter parkingSlots:");
        int parkingSlots = sc.nextInt();
        _flight.getRoute().getOrigin().setParkingLot(parkingSlots);





        //Selecting Destination Airport
        count = 1;
        System.out.println("Airports Available:");
        for(int i = 0; i < airportList.size(); i++ ) {
            if(i != originAirport-1) {
                System.out.println(count + ". Airport ID: " + airportList.get(i).getAirportCode() + ", Airport Name: " + airportList.get(i).getName() + ", Airport City: " + airportList.get(i).getCity() + ", Airport State: " + airportList.get(i).getState() + ", Airport Country: " + airportList.get(i).getCountry() + "\n");
            }
            count++;
        }
        System.out.println("Selecting Destination:");
        int destinationAirport = sc.nextInt();

        if (destinationAirport - 1 >= airportList.size() || destinationAirport == originAirport) {
            while (destinationAirport - 1 >= airportList.size() || destinationAirport != originAirport) {
                System.out.println("Select Any Airport for destination:");
                destinationAirport = sc.nextInt();
            }
        }
        _flight.getRoute().getDestination().setAirport(airportList.get(destinationAirport - 1));

        System.out.println("Enter Time for arrival:");
        _flight.getRoute().getDestination().setArrivalTime(getDateAndTime());
        System.out.println("Enter parking slots:");
        parkingSlots = sc.nextInt();
        _flight.getRoute().getDestination().setParkingLot(parkingSlots);

        System.out.println("Is the flight \n 1. direct\n 2.indirect");
        int isDirect = sc.nextInt();
        if(isDirect > 2 || isDirect > 2){
            while(isDirect>2 || isDirect < 1){
                System.out.println("Is the flight \n 1. direct\n 2.indirect");
                isDirect = sc.nextInt();
            }
        }
        if(isDirect == 2){
            _flight.getRoute().setDirect(false);
            count = 1;
            System.out.println("Airports Available:");
            for(int i = 0; i < airportList.size(); i++ ) {
                if(i != originAirport-1 && i!=destinationAirport-1) {
                    System.out.println(count + ". Airport ID: " + airportList.get(i).getAirportCode() + ", Airport Name: " + airportList.get(i).getName() + ", Airport City: " + airportList.get(i).getCity() + ", Airport State: " + airportList.get(i).getState() + ", Airport Country: " + airportList.get(i).getCountry() + "\n");
                }
                count++;
            }
            System.out.println("Selecting Intermediate:");
            int intermediateAirport = sc.nextInt();


            if (intermediateAirport - 1 >= airportList.size() || intermediateAirport == originAirport || intermediateAirport == destinationAirport) {
                while (intermediateAirport - 1 >= airportList.size() || intermediateAirport != originAirport || intermediateAirport == destinationAirport) {
                    System.out.println("Select Any Airport for Intermediate:\n");
                    intermediateAirport = sc.nextInt();
                }
            }
            Intermediate _intermediate  = new Intermediate();
            _intermediate.setAirport(airportList.get(intermediateAirport - 1));
            System.out.println("Enter Time for arrival:");
            _intermediate.setArrivalTime(getDateAndTime());

            System.out.println("Enter Time for departure:");
            _intermediate.setDepartureTime(getDateAndTime());


            System.out.println("Enter parking slots:");
            parkingSlots = sc.nextInt();

            _intermediate.setParkingLot(parkingSlots);

            _flight.getRoute().addIntermediate(_intermediate);



        }
        return _flight;
    }
    public void removeFlight(List<Flight> flightList){
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < flightList.size() ; i++){
            System.out.println("================================================================================================");
            System.out.println("1. ");
            flightList.get(i).displayFlight();
        }
        System.out.println("================================================================================================");

        System.out.println("Enter a flight ID You want to cancel");
        int _flightId = sc.nextInt();
        if(_flightId - 1 < flightList.size()){
            flightList.remove(_flightId-1);
        }
    }
    
}
