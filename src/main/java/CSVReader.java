import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVReader {

    public List<User> readUsersFromCSV(String filename){
        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                User user = createUser(attributes);
                users.add(user);
                line = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return users;
    }

    private User createUser(String[] attributes) {
        String username = attributes[0];
        String password = attributes[1];
        String passportNumber = attributes[2];
        String firstName = attributes[3];
        String lastName = attributes[4];
        String gender = attributes[5];
        String address = attributes[7];
        String email = attributes[8];
        String phoneNumber = attributes[9];
        Boolean isAdmin = Boolean.parseBoolean(attributes[10]);
        try {
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter1.parse(attributes[6]);
            return new User(username,password,passportNumber,firstName,lastName,gender,date,address,email,phoneNumber,isAdmin);
        }catch (Exception e){
            System.out.println("Date of Birth is not Correct");
        }
        return new User(username,password,passportNumber,firstName,lastName,gender,address,email,phoneNumber,isAdmin);

    }

    public List<Airplane> readAirplaneFromCSV(String filename){
        List<Airplane> airplanes = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                Airplane airplane = createAirplane(attributes);
                airplane.setSeatsInfo(new ArrayList<>());
                loadSeats(airplane);
                airplanes.add(airplane);
                line = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return airplanes;
    }

    private void loadSeats(Airplane airplane) {
        List<Seat> seats = new ArrayList<>();
        Path pathToFile = Paths.get(String.valueOf(airplane.getPlaneId()+"_"+airplane.getType()+"_seats.csv"));

        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                Seat seat = createSeat(attributes);
                airplane.getSeatsInfo().add(seat);

                line = br.readLine();
            }
            //System.out.print("Seats Loaded From "+ String.valueOf(airplane.getPlaneId()+"_"+airplane.getType()+"_seats.csv") + "\n");
        }catch(IOException ioe){
            System.out.print("No File For Seats\n");
        }
    }

    private Seat createSeat(String[] attributes) {
        String id = attributes[0];
        Boolean isOccupied = Boolean.parseBoolean(attributes[1]);
        String passportNumber = attributes[2];
        String classType = attributes[3];
        int luggageCapacity = Integer.parseInt(attributes[4]);
        return new Seat(id,isOccupied,passportNumber,classType,luggageCapacity);
    }

    private Airplane createAirplane(String[] metaData) {

        String type = metaData[0];
        int planeID = Integer.parseInt(metaData[1]);
        Boolean isAvailable = Boolean.parseBoolean(metaData[2]);
        return new Airplane(type, planeID, isAvailable);
    }


    public List<Airport> readAirport(String filename){
        List<Airport> airports = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                Airport airport = createAirport(attributes);
                airports.add(airport);
                line = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return airports;
    }

    private Airport createAirport(String[] metaData) {

        String airportCode = metaData[0];
        String name = metaData[1];
        String city = metaData[2];
        String country = metaData[3];
        //String airportCode, String name, String city, String country
        return new Airport(airportCode,name,city,country);
    }

    public List<Flight> readFlightsFromCSV(String filename, List<Airplane> airplanes, List<Airport> airports, String routeFilename, String intermediateFilename){
        List<Route> routes = new ArrayList<>();
        readRouteFromCSV(routeFilename,intermediateFilename ,routes,airports);
        List<Flight> flights = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                Flight flight = createFlight(attributes,airplanes,routes);
                flights.add(flight);
                line = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return flights;
    }

    public void readRouteFromCSV(String filename, String intermediateFilename,List<Route> routes, List<Airport> airports) {

        Path pathToFile = Paths.get(filename);

        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                Route route = createRoute(attributes, airports, intermediateFilename);
                routes.add(route);
                line = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    private Route createRoute(String[] attributes, List<Airport> airports, String intermediateFile) {
        Route route = new Route();

        try {

            int routeID = Integer.parseInt(attributes[0]);
            route.setRouteId(routeID);



            SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date departureDate=formatter.parse(attributes[2]);

            //Date departureDate = getValidDate(attributes[2]);


                Origin origin = new Origin(Integer.parseInt(attributes[1]),airports.get(Integer.parseInt(attributes[1])) ,departureDate);
                route.setOrigin(origin);

                List<Intermediate> intermediate = readIntermediateFromCSV(Integer.parseInt(attributes[3]),intermediateFile,airports);
                route.setIntermediateId(Integer.parseInt(attributes[3]));
                route.setIntermediate(intermediate);


                Date arrivalDate=formatter.parse(attributes[5]);
                //Date arrivalDate = getValidDate(attributes[5]);

                Destination destination = new Destination(Integer.parseInt(attributes[4]), airports.get(Integer.parseInt(attributes[4])),arrivalDate);
                route.setDestination(destination);


            //System.out.println("Date inserted");
            if (departureDate != null || arrivalDate != null) {
                //System.out.println("Arrival Date : " + arrivalDate);
                //System.out.println("Departure Date: " + departureDate);
            } else {
                System.out.println("Date is invalid.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.print("Departure Date not added");
        } finally {

        }
        return route;
    }

    private List<Intermediate> readIntermediateFromCSV(int attribute, String filename, List<Airport> airports) {
        Path pathToFile = Paths.get(filename);
        List<Intermediate> intermediates = new ArrayList<>();
        try(BufferedReader br  = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                String[] attributes = line.split(",");

                Intermediate intermediate = createIntermediate(attributes,airports );
                intermediates.add(intermediate);
                line = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        List<Intermediate> intermediateList = new ArrayList<>();
        for(int i = 0; i < intermediates.size(); i++){
            if(attribute == intermediates.get(i).getId()){
                intermediateList.add(intermediates.get(i));
            }
        }
        return intermediateList;
    }

    private Intermediate createIntermediate(String[] attributes, List<Airport> airports) {
        int ID = Integer.parseInt(attributes[0]);
        try {
            Airport airport = airports.get(Integer.parseInt(attributes[1]));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date departureDate = formatter.parse(attributes[3]);
            Date arrivalDate = formatter.parse(attributes[2]);
            return new Intermediate(Integer.parseInt(attributes[1]),ID,airport,arrivalDate,departureDate);
        }
        catch(Exception e){
            System.out.print("Date not parsed in createIntermediate()");
        }
        //Date departureDate = getValidDate(attributes[3]);
        return new Intermediate();

    }

    public Flight createFlight(String[] metaData, List<Airplane> airplanes,List<Route> routes ) {
        String flightID = metaData[0];
        String flightName = metaData[1];
        Airplane airplane = new Airplane();
        for(int i = 0; i < airplanes.size(); i++){
            if(airplanes.get(i).getPlaneId() == Integer.parseInt(metaData[2])){
                airplane = airplanes.get(i);
            }
        }

        Route route = new Route();
        int routeID = 0;
        try{
            //for(int i = 0 ; i< routes.size() ; i++){
                //System.out.print("Route:");
                 //routes.get(i).displayRoute();
            //}
            routeID = Integer.parseInt(metaData[3]);
            for(int i = 0; i < routes.size(); i++){
                if(routes.get(i).getRouteId()== routeID){
                    route = routes.get(i);
                }
            }
            //route = routes.get(Integer.parseInt(metaData[3]));


        }
        catch(Exception e){
            System.out.println("Route not loaded");
        }
        Boolean isDeparted = Boolean.parseBoolean(metaData[4]);
        Boolean hasLanded = Boolean.parseBoolean(metaData[5]);

        //String airportCode, String name, String city, String country
        return new Flight(flightID,routeID,flightName,airplane,route,isDeparted, hasLanded);
    }
    /*private static Date getValidDate(String date) {

        Date mydate = null;
        if (isValidDateFormat(date)) {

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            dateFormat.setLenient(false);
            try {
                mydate = dateFormat.parse(date);
            } catch (ParseException e) {
                mydate = null;
            }
        }
        return mydate;
    }*/

 /*   private static boolean isValidDateFormat(String date) {

        String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean result = false;
        if (date.matches(pattern)) {
            result = true;
        }
        return result;
    }*/
}
