import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents a Flight
class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private String date;

    // Constructor
    public Flight(String flightNumber, String departure, String destination, String date) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    // Getters and toString method
    public String getFlightNumber() { return flightNumber; }
    public String getDeparture() { return departure; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

// Represents a Hotel
class Hotel {
    private String name;
    private String location;
    private int pricePerNight;

    // Constructor
    public Hotel(String name, String location, int pricePerNight) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    // Getters and toString method
    public String getName() { return name; }
    public String getLocation() { return location; }
    public int getPricePerNight() { return pricePerNight; }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}

// Represents Transportation
class Transportation {
    private String type;
    private int price;

    // Constructor
    public Transportation(String type, int price) {
        this.type = type;
        this.price = price;
    }

    // Getters and toString method
    public String getType() { return type; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return "Transportation{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

// Represents a Booking
class Booking {
    private Flight flight;
    private Hotel hotel;
    private Transportation transportation;

    // Constructor
    public Booking(Flight flight, Hotel hotel, Transportation transportation) {
        this.flight = flight;
        this.hotel = hotel;
        this.transportation = transportation;
    }

    public void printBookingDetails() {
        System.out.println("Booking Details:");
        System.out.println(flight);
        System.out.println(hotel);
        System.out.println(transportation);
    }
}

// Represents a User
class User {
    private String name;
    private List<Booking> bookings;

    public User(String name) {
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void showBookings() {
        for (Booking booking : bookings) {
            booking.printBookingDetails();
            System.out.println("---------------");
        }
    }
}

// Main class
public class TravelBookingSystem {
    private List<Flight> flights;
    private List<Hotel> hotels;
    private List<Transportation> transportations;
    private User user;

    public TravelBookingSystem() {
        flights = new ArrayList<>();
        hotels = new ArrayList<>();
        transportations = new ArrayList<>();
        user = new User("Guest");
    }

    // Load some initial data
    private void loadData() {
        flights.add(new Flight("AA123", "Shaka Marine", "OR Tambo", "12/15/2024"));
        flights.add(new Flight("DL456", "OR Tambo", "Shaka Marine", "12/20/2024"));
        hotels.add(new Hotel("The Westcliff", "Johannesburg", 200));
        hotels.add(new Hotel("Royal Malewane", "Kruger National Park", 180));
        transportations.add(new Transportation("Car Rental", 50));
        transportations.add(new Transportation("Airport Shuttle", 25));
    }

    // Display available options
    private void displayOptions() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }

        System.out.println("\nAvailable Hotels:");
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }

        System.out.println("\nAvailable Transportations:");
        for (Transportation transport : transportations) {
            System.out.println(transport);
        }
    }

    // Book a trip
    public void bookTrip() {
        displayOptions();
        Scanner scanner = new Scanner(System.in);

        // Choose flight
        System.out.print("Select flight by number: ");
        String flightNumber = scanner.nextLine();
        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        // Choose hotel
        System.out.print("Select hotel by name: ");
        String hotelName = scanner.nextLine();
        Hotel selectedHotel = null;
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        // Choose transportation
        System.out.print("Select transportation type: ");
        String transportType = scanner.nextLine();
        Transportation selectedTransport = null;
        for (Transportation transportation : transportations) {
            if (transportation.getType().equalsIgnoreCase(transportType)) {
                selectedTransport = transportation;
                break;
            }
        }

        // Create a booking
        if (selectedFlight != null && selectedHotel != null && selectedTransport != null) {
            Booking booking = new Booking(selectedFlight, selectedHotel, selectedTransport);
            user.addBooking(booking);
            System.out.println("Booking successful!");
        } else {
            System.out.println("Invalid selection, please try again.");
        }
    }

    public static void main(String[] args) {
        TravelBookingSystem system = new TravelBookingSystem();
        system.loadData();
        system.bookTrip();
        system.user.showBookings();
    }
}
