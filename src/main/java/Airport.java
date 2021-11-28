public class Airport {
    private String airportId;
    private String name;
    private String city;

    private String country;


    public Airport(String airportCode, String name, String city, String country) {
        this.airportId = airportCode;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getAirportCode() {
        return airportId;
    }

    public void setAirportCode(String airportCode) {
        this.airportId = airportCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country;
    }
}
