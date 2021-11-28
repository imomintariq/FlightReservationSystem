import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {

    List<Airplane> airplanes;
    List<Airport> airports;
    List<Flight> flights;
    List<User> users;

    public ReservationSystem() {
        airplanes = new ArrayList<>();
        airports = new ArrayList<>();
        flights = new ArrayList<>();
        users = new ArrayList<>();

    }
    public void initialize(){
        loadData();
        StartingPage startingPage = new StartingPage();
        startingPage.menu();

    }
    public void loadData(){
        CSVReader csvReader = new CSVReader();
        airplanes = csvReader.readAirplaneFromCSV("Airplane.csv");
        airports = csvReader.readAirport("Airport.csv");
        flights = csvReader.readFlightsFromCSV("Flights.csv", airplanes,airports,"Route.csv","Intermediates.csv");
        users = csvReader.readUsersFromCSV("User.csv");
    }

}