package application;

public class Flight {
   private String airlineName;
   private String airlineNum;
   private String departureAirport;
   private String arrivalAirport;

   public Flight(String airline, String numr, String departure_airport, String arrival_airport) {
      this.airlineName = airline;
      this.airlineNum = numr;
      this.departureAirport = departure_airport;
      this.arrivalAirport = arrival_airport;
   }

   public String getAirlineName() {
      return this.airlineName;
   }

   public void setAirlineName(String airline) {
      this.airlineName = airline;
   }

   public String getAirlineNum() {
      return this.airlineNum;
   }

   public void setAirlineNum(String numr) {
      this.airlineNum = numr;
   }

   public String getDepartureAirport() {
      return this.departureAirport;
   }

   public void setDepartureAirport(String departure_airport) {
      this.departureAirport = departure_airport;
   }

   public String getArrivalAirport() {
      return this.arrivalAirport;
   }

   public void setArrival_airport(String arrival_airport) {
      this.arrivalAirport = arrival_airport;
   }

   public String toString() {
      return this.airlineName + "\t" + this.airlineNum + "\t \t" + this.departureAirport + "\t \t" + this.arrivalAirport;
   }
}
