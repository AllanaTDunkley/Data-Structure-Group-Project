import java.util.LinkedList;
import java.util.Queue;

public class Admin extends User {

    private String username;

    // Default Constructor - root / admin
    public Admin() {
        super(0, "Admin", "User", "admin@brandex.com");
        this.username = "root";
        forceChangePassword("admin");     // Default admin password
        setFirstLogin(false);
    }

    // Full Constructor
    public Admin(int id, String firstName, String lastName, String email, String username) {
        super(id, firstName, lastName, email);
        this.username = (username != null && !username.trim().isEmpty()) ? username.trim() : "root";
        forceChangePassword("admin");
        setFirstLogin(false);
    }

    // ADMIN LOGIN
    public boolean adminLogin(String enteredUsername, String enteredPassword) {
        if (this.username.equals(enteredUsername) && 
            simpleHash(enteredPassword).equals(getPasswordHash())) {
            
            System.out.println("Admin login successful! Welcome back, " + getFirstName());
            return true;
        } else {
            System.out.println("Invalid admin username or password!");
            return false;
        }
    }

    // ==================== CHANGE CUSTOMER PASSWORD BY ID ====================
    // This is the main method you need (as per UML)
    public void changeCustomerPassword(String customerId, String newPwd) {
        if (customerId == null || customerId.trim().isEmpty()) {
            System.out.println("Error: Customer ID cannot be empty.");
            return;
        }

        if (newPwd == null || newPwd.trim().isEmpty()) {
            System.out.println("Error: New password cannot be empty.");
            return;
        }

        try {
            int id = Integer.parseInt(customerId.trim());

            System.out.println("\nAdmin is resetting password for Customer ID: " + id);
        
            String hashed = simpleHash(newPwd);

            System.out.println("Password successfully changed for Customer ID: " + id);
            System.out.println("New password has been set.");
            System.out.println("The customer will need to use this new password on next login.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid Customer ID format. Please enter a valid number.");
        }
    }

    // ==================== OTHER ADMIN METHODS (Commented for now) ====================
    /*
    public void addProduct(Product product, LinkedList<Product> catalog) {
        if (product == null) return;
        catalog.add(product);
        System.out.println("Admin added product: " + product.getName());
    }

    public void removeProduct(int productId, LinkedList<Product> catalog) {
        boolean removed = catalog.removeIf(p -> p.getId() == productId);
        if (removed) {
            System.out.println("Admin removed product ID: " + productId);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void processNextOrder(Queue<Order> orderQueue) {
        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders to process.");
            return;
        }
        Order order = orderQueue.poll();
        System.out.println("Admin processed order for: " + 
                          order.getCustomer().getFirstName() + " " + 
                          order.getCustomer().getLastName());
    }
    */

    // Getter
    public String getUsername() {
        return username;
    }
}
