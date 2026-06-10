import java.util.*;

class Bus {
    int busId;
    String busName;
    String source;
    String destination;
    int availableSeats;

    Bus(int busId, String busName, String source,
        String destination, int availableSeats) {
        this.busId = busId;
        this.busName = busName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }
}

public class BusBookingSystem {

    static ArrayList<Bus> buses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        buses.add(new Bus(101, "Volvo", "Delhi", "Jaipur", 40));
        buses.add(new Bus(102, "AC Sleeper", "Delhi", "Chandigarh", 30));
        buses.add(new Bus(103, "Express", "Delhi", "Agra", 25));
        buses.add(new Bus(104, "Non-AC", "Delhi", "Lucknow", 50));
        buses.add(new Bus(105, "Luxury", "Delhi", "Mumbai", 20));
        buses.add(new Bus(106, "Semi-Sleeper", "Delhi", "Bangalore", 35));
        buses.add(new Bus(107, "AC Seater", "Delhi", "Pune", 45));

        while (true) {

            System.out.println("\n===== BUS BOOKING SYSTEM =====");
            System.out.println("1. View Buses");
            System.out.println("2. Search Bus");
            System.out.println("3. Book Ticket");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewBuses();
                    break;

                case 2:
                    searchBus();
                    break;

                case 3:
                    bookTicket();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void viewBuses() {
        System.out.println("\nAvailable Buses:");

        for (Bus bus : buses) {
            System.out.println(
                bus.busId + " | " +
                bus.busName + " | " +
                bus.source + " -> " +
                bus.destination + " | Seats: " +
                bus.availableSeats
            );
        }
    }

    static void searchBus() {

        System.out.print("Enter Source: ");
        String source = sc.next();

        System.out.print("Enter Destination: ");
        String destination = sc.next();

        boolean found = false;

        for (Bus bus : buses) {
            if (bus.source.equalsIgnoreCase(source)
                    && bus.destination.equalsIgnoreCase(destination)) {

                System.out.println(
                    bus.busId + " | " +
                    bus.busName + " | Seats: " +
                    bus.availableSeats
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Bus Found");
        }
    }

    static void bookTicket() {

        System.out.print("Enter Bus ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Number of Seats: ");
        int seats = sc.nextInt();

        for (Bus bus : buses) {

            if (bus.busId == id) {

                if (bus.availableSeats >= seats) {

                    bus.availableSeats -= seats;

                    System.out.println("Booking Successful!");
                    System.out.println("Remaining Seats: "
                            + bus.availableSeats);

                } else {
                    System.out.println("Seats Not Available");
                }
                return;
            }
        }

        System.out.println("Invalid Bus ID");
    }
}