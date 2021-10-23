import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args){

        List<Airplane> airplaneList = new ArrayList<>();
        List<Airport> airportList = new ArrayList<>();
        List<Flight> flightList = new ArrayList<>();
        List<Seat> seats = new ArrayList<>();
        Airplane plane = new Airplane("A320", "1234", true, 123, seats);
        airplaneList.add(plane);
        Airport a1 = new Airport("SFO", "Islamabad International Airport", "Islamabad", "ICT", "Pakistan");
        Airport a2 = new Airport("AMI", "Islamabad International Airport", "Islamabad", "ICT", "Pakistan");
        Airport a3 = new Airport("MOM", "Islamabad International Airport", "Islamabad", "ICT", "Pakistan");
        airportList.add(a1);
        airportList.add(a2);
        airportList.add(a3);

        String sDate1="31/12/1998";
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            Admin admin =  new Admin("imomintariq", "1234", "Momin", "Tariq", "Gender", date1,"Islamabad", "imomintariq@gmail.com", "0310-5446436" );
            flightList.add(admin.addFlight(airplaneList,airportList));
            admin.removeFlight(flightList);
         }
        catch (Exception e){
            System.out.println("exception Thrown");
        }

    }
}
