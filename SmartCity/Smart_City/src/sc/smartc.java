package sc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class smartc {
    private List<Transportation> transportationList;
    private List<Accommodation> accommodationList;
    private List<TouristObjective> touristObjectiveList;
    private TicketPurchaseSystem ticketPurchaseSystem;

    public smartc() {
        transportationList = new ArrayList<>();
        accommodationList = new ArrayList<>();
        touristObjectiveList = new ArrayList<>();
        ticketPurchaseSystem = new TicketPurchaseSystem();
    }

    public void addTransportation(Transportation transportation) {
        transportationList.add(transportation);
    }

    public void addAccommodation(Accommodation accommodation) {
        accommodationList.add(accommodation);
    }

    public void addTouristObjective(TouristObjective touristObjective) {
        touristObjectiveList.add(touristObjective);
    }

    public void displayTransportationOptions() {
        System.out.println("Transportation Options:");
        for (int i = 0; i < transportationList.size(); i++) {
            System.out.println((i + 1) + ". " + transportationList.get(i));
        }
    }

    public void displayAccommodationOptions() {
        System.out.println("Accommodation Options:");
        for (int i = 0; i < accommodationList.size(); i++) {
            System.out.println((i + 1) + ". " + accommodationList.get(i));
        }
    }

    public void displayTouristObjectives() {
        System.out.println("Tourist Objectives:");
        for (int i = 0; i < touristObjectiveList.size(); i++) {
            System.out.println((i + 1) + ". " + touristObjectiveList.get(i));
        }
    }

    public void buyTransportationTicket(int option) {
        if (option > 0 && option <= transportationList.size()) {
            Transportation transportation = transportationList.get(option - 1);
            Ticket ticket = ticketPurchaseSystem.purchaseTicket(transportation.getName(), transportation.getDescription(), transportation.getPrice());
            generateBill(ticket);
        } else {
            System.out.println("Invalid transportation option.");
        }
    }

    public void buyAccommodationTicket(int option) {
        if (option > 0 && option <= accommodationList.size()) {
            Accommodation accommodation = accommodationList.get(option - 1);
            Ticket ticket = ticketPurchaseSystem.purchaseTicket(accommodation.getName(), accommodation.getDescription(), accommodation.getPrice());
            generateBill(ticket);
        } else {
            System.out.println("Invalid accommodation option.");
        }
    }

    public void buyTouristObjectiveTicket(int option) {
        if (option > 0 && option <= touristObjectiveList.size()) {
            TouristObjective touristObjective = touristObjectiveList.get(option - 1);
            Ticket ticket = ticketPurchaseSystem.purchaseTicket(touristObjective.getName(), touristObjective.getDescription(), touristObjective.getPrice());
            generateBill(ticket);
        } else {
            System.out.println("Invalid tourist objective option.");
        }
    }

    private void generateBill(Ticket ticket) {
        System.out.println("------ Ticket Bill ------");
        System.out.println("Item Name: " + ticket.getItemName());
        System.out.println("Item Description: " + ticket.getItemDescription());
        System.out.println("Price: $" + ticket.getPrice());
        System.out.println("-------------------------\n");
    }

    public static void main(String[] args) {
        smartc travelSystem = new smartc();

        // Adding transportation options
        travelSystem.addTransportation(new Transportation("Train", "Fast and convenient train transportation", 50.0));
        travelSystem.addTransportation(new Transportation("Bus", "Affordable and widely available bus transportation", 20.0));
        travelSystem.addTransportation(new Transportation("Taxi", "Convenient taxi service", 100.0));

        // Adding accommodation options
        travelSystem.addAccommodation(new Accommodation("Hotel A", "Luxurious 5-star hotel", 200.0));
        travelSystem.addAccommodation(new Accommodation("Hotel B", "Comfortable 4-star hotel", 150.0));
        travelSystem.addAccommodation(new Accommodation("Hotel C", "Budget-friendly hotel", 80.0));

        // Adding tourist objectives
        travelSystem.addTouristObjective(new TouristObjective("Landmark A", "Famous tourist landmark", 10.0));
        travelSystem.addTouristObjective(new TouristObjective("Landmark B", "Historical monument", 5.0));
        travelSystem.addTouristObjective(new TouristObjective("Landmark C", "Beautiful natural attraction", 8.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Smart City Travel System -----");
            System.out.println("1. Display Transportation Options");
            System.out.println("2. Display Accommodation Options");
            System.out.println("3. Display Tourist Objectives");
            System.out.println("4. Buy Transportation Ticket");
            System.out.println("5. Buy Accommodation Ticket");
            System.out.println("6. Buy Tourist Objective Ticket");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thank you for using the Smart City Travel System. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    travelSystem.displayTransportationOptions();
                    break;
                case 2:
                    travelSystem.displayAccommodationOptions();
                    break;
                case 3:
                    travelSystem.displayTouristObjectives();
                    break;
                case 4:
                    System.out.print("Enter the option number: ");
                    int transportationOption = scanner.nextInt();
                    travelSystem.buyTransportationTicket(transportationOption);
                    break;
                case 5:
                    System.out.print("Enter the option number: ");
                    int accommodationOption = scanner.nextInt();
                    travelSystem.buyAccommodationTicket(accommodationOption);
                    break;
                case 6:
                    System.out.print("Enter the option number: ");
                    int touristObjectiveOption = scanner.nextInt();
                    travelSystem.buyTouristObjectiveTicket(touristObjectiveOption);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

class Transportation {
    private String name;
    private String description;
    private double price;

    public Transportation(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + description + " - Price: $" + price;
    }
}

class Accommodation {
    private String name;
    private String description;
    private double price;

    public Accommodation(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + description + " - Price: $" + price;
    }
}

class TouristObjective {
    private String name;
    private String description;
    private double price;

    public TouristObjective(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + ": " + description + " - Price: $" + price;
    }
}

class Ticket {
    private String itemName;
    private String itemDescription;
    private double price;

    public Ticket(String itemName, String itemDescription, double price) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getPrice() {
        return price;
    }
}

class TicketPurchaseSystem {
    public Ticket purchaseTicket(String name, String description, double price) {
        System.out.println("Purchasing a ticket for: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
        System.out.println("Payment successful!\n");
        return new Ticket(name, description, price);
    }
}
