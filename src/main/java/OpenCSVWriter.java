import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {

    public void writeUserToCSV(String filePath, List<User> users){
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);


            List<String[]> list = new ArrayList<>();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for(int i = 0; i < users.size(); i++){
                String[] data1 = {users.get(i).getUsername(),
                        users.get(i).getPassword(),
                        users.get(i).getPassportNumber(),
                        users.get(i).getFirstName(),
                        users.get(i).getLastName(),
                        users.get(i).getGender(),
                        dateFormat.format(users.get(i).getDateOfBirth()),
                        users.get(i).getAddress(),
                        users.get(i).getEmail(),
                        users.get(i).getPhoneNumber(),
                        String.valueOf(users.get(i).getAdmin())
                            };
                list.add(data1);
            }
            try {
                writer.writeAll(list);
                System.out.print("Users Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Users Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void writeFlightsToCSV(String filePath, List<Flight> flights,String routeFilename, String intermediateFilename){
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);


            List<String[]> flightData = new ArrayList<>();
            List<String[]> routesData = new ArrayList<>();
            List<String[]> intermediateData = new ArrayList<>();

            String[] header = {"Flight ID", "Flight Name", "Airplane ID","Route ID", "Is Departed", "Has Landed"};
            for(int i = 0; i < flights.size(); i++){
                String[] data1 = {flights.get(i).getFlightId(), flights.get(i).getFlightName(),String.valueOf(flights.get(i).getAirplane().getPlaneId()),String.valueOf(flights.get(i).getRouteID()),String.valueOf(flights.get(i).isDeparted()),String.valueOf(flights.get(i).isHasLanded())};
                flightData.add(data1);
                DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                //String strDate = dateFormat.format(date);
                String[] data2 = {String.valueOf(flights.get(i).getRoute().getRouteId()),String.valueOf(flights.get(i).getRoute().getOrigin().getAirportID()),dateFormat.format(flights.get(i).getRoute().getOrigin().getDepartureTime()),String.valueOf(flights.get(i).getRoute().getIntermediateId()),String.valueOf(flights.get(i).getRoute().getDestination().getAirportID()),dateFormat.format(flights.get(i).getRoute().getDestination().getArrivalTime())};
                routesData.add(data2);

                for(int j = 0; j <flights.get(i).getRoute().getIntermediate().size(); j++ ){
                    String[] data3 = {String.valueOf(flights.get(i).getRoute().getIntermediateId()),String.valueOf(flights.get(i).getRoute().getIntermediate().get(j).getAirportID()),dateFormat.format(flights.get(i).getRoute().getIntermediate().get(j).getArrivalTime()), dateFormat.format(flights.get(i).getRoute().getIntermediate().get(j).getDepartureTime())};
                    intermediateData.add(data3);
                }


            }
            writeRoutesToCSV(routesData, routeFilename);
            writeIntermediateDataToCSV(intermediateData,intermediateFilename);
            try {
                writer.writeAll(flightData);
                System.out.print("flight Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Flight Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void writeIntermediateDataToCSV(List<String[]> intermediateData, String filePath) {
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter

            CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);
            try {
                writer.writeAll(intermediateData);
                System.out.print("Intermediate Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Intermediate Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void writeRoutesToCSV(List<String[]> routesData, String filePath) {
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter

            CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);
            try {
                writer.writeAll(routesData);
                System.out.print("Routes Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Routes Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void writeAirportToCSV(String filePath, List<Airport> airports){
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);


            List<String[]> list = new ArrayList<>();


            for(int i = 0; i < airports.size(); i++){
                String[] data1 = {airports.get(i).getAirportCode(), airports.get(i).getName(), airports.get(i).getCity(), airports.get(i).getCountry()};
                list.add(data1);
            }
            try {
                writer.writeAll(list);
                System.out.print("Airport Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Airport Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void writeAirplaneToCSV(String filePath, List<Airplane> airplanes)
    {

        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);


            List<String[]> list = new ArrayList<>();


            for(int i = 0; i < airplanes.size(); i++){
                String[] data1 = {airplanes.get(i).getType(), String.valueOf(airplanes.get(i).getPlaneId()), String.valueOf(airplanes.get(i).isAvailable())};
                writeSeatsIntoCSV(airplanes.get(i));
                list.add(data1);
            }


            try {
                writer.writeAll(list);
                System.out.print("Airplane Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Airplane Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void writeSeatsIntoCSV(Airplane airplane) {

        File file = new File(String.valueOf(airplane.getPlaneId()+"_"+airplane.getType()+"_seats.csv"));
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(airplane.getPlaneId()+"_"+airplane.getType()+"_seats.csv")),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);


            List<String[]> list = new ArrayList<>();


            for(int i = 0; i < airplane.getSeatsInfo().size(); i++){
                String[] data1 = {airplane.getSeatsInfo().get(i).getSeatId(), String.valueOf(airplane.getSeatsInfo().get(i).isSeatOccupied()),airplane.getSeatsInfo().get(i).getPassportNumber(),airplane.getSeatsInfo().get(i).getClassType(),String.valueOf(airplane.getSeatsInfo().get(i).getLuggageInPounds())};

                list.add(data1);
            }


            try {
                writer.writeAll(list);
                System.out.print("Seat Data Successfully written\n");
            }
            catch(Exception e){
                System.out.print("Seat Data is not written\n");

            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
