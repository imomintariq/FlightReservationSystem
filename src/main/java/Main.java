import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args){
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.initialize();
/*        ReservationSystem reservationSystem = new ReservationSystem();
        CSVReader csvReader = new CSVReader();
        //csvReader.createRoute();
        reservationSystem.airplanes = csvReader.readAirplaneFromCSV("Airplane.csv");

        for(int i = 0 ; i < reservationSystem.airplanes.size() ; i++){

            System.out.println(reservationSystem.airplanes.get(i).getType());
        }

        reservationSystem.airports = csvReader.readAirport("Airport.csv");
        for(int i = 0 ; i < reservationSystem.airports.size() ; i++){

            System.out.println(reservationSystem.airports.get(i).getName()+ "       "+reservationSystem.airports.get(i).getCountry());
        }

        reservationSystem.flights = csvReader.readFlightsFromCSV("Flights.csv", reservationSystem.airplanes,reservationSystem.airports,"Route.csv","Intermediates.csv");
        for(int i = 0; i < reservationSystem.flights.size() ; i++){
            System.out.println(reservationSystem.flights.get(i).getFlightId()+" "+reservationSystem.flights.get(i).getFlightName()+" "+reservationSystem.flights.get(i).isDeparted()+" "+ reservationSystem.flights.get(i).isHasLanded());
            reservationSystem.flights.get(i).getRoute().displayRoute();
        }

        OpenCSVWriter csvWriter = new OpenCSVWriter();
        csvWriter.writeAirplaneToCSV("Airplane.csv", reservationSystem.airplanes);
        csvWriter.writeAirportToCSV("Airport.csv",reservationSystem.airports);
        csvWriter.writeFlightsToCSV("Flights.csv", reservationSystem.flights, "Route.csv", "Intermediates.csv");
        reservationSystem.users = csvReader.readUsersFromCSV("User.csv");
        csvWriter.writeUserToCSV("User.csv",reservationSystem.users);*/

    }
}
