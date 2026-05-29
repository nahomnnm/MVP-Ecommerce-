import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("P-001", "Wireless Headphones", 120.0, 5.5));
        catalog.add(new Product("P-002", "Phone Case",          15.0,  1.2));
        catalog.add(new Product("P-003", "Laptop Bag",          45.0,  8.0));
        catalog.add(new Product("D-001", "Java eBook",          25.0,  "http://download.items/java.pdf"));
        catalog.add(new Product("D-002", "Python Course",       60.0,  "http://download.items/python.zip"));
        catalog.add(new Product("D-003", "Resume Template",     10.0,  "http://download.items/resume.docx"));

        List<Order> systemOrders = new ArrayList<>();
        int orderCounter = 1;

        System.out.println("=== E-Commerce System ===\n");

        System.out.println("Available Products:");
        for (int i = 0; i < catalog.size(); i++) {
            catalog.get(i).display(i + 1);
        }

        System.out.print("\nYour name: ");
        String customerName = scanner.nextLine().trim();

        String choice = "yes";
        while (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
            System.out.print("\nEnter product number (1-" + catalog.size() + "): ");
            int pick = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (pick < 0 || pick >= catalog.size()) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Product selected = catalog.get(pick);
            String orderId = "ORD-" + (orderCounter++);

            if (selected.getType().equals("physical")) {
                systemOrders.add(new PhysicalOrder(orderId, customerName, selected.getPrice(), selected.getWeight()));
            } else {
                systemOrders.add(new DigitalOrder(orderId, customerName, selected.getPrice(), selected.getDownloadLink()));
            }

            System.out.println(" \"" + selected.getName() + "\" added to your orders.");
            System.out.print("Add another product? (yes/no): ");
            choice = scanner.nextLine().trim();
        }

        System.out.println("\n=== Your Order Summary, " + customerName + " ===");
        for (Order order : systemOrders) {
            order.displayOrderSummary();
            System.out.println("Total: $" + order.calculateTotal());

           
            sendNotification(order);

            if (order instanceof DigitalOrder) {
                DigitalOrder d = (DigitalOrder) order;
                System.out.println("Download link: " + d.getDownloadLink());
            } else if (order instanceof PhysicalOrder) {
                PhysicalOrder p = (PhysicalOrder) order;
                if (p.getShippingWeight() > 5.0) {
                    
                    sendNotification(p, "HEAVY FREIGHT");
                }
            }
            System.out.println("----------");
        }

        scanner.close();
    }

 
    static void sendNotification(Order order) {
        System.out.println("Email receipt sent to " + order.getCustomerName() + " for Order #" + order.getOrderId());
    }


    static void sendNotification(Order order, String priorityMessage) {
        System.out.println("[" + priorityMessage + "] Urgent notification dispatched to " + order.getCustomerName() + "!");
    }
}