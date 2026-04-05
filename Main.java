import java.util.Scanner;

public class Main {

    public static void displayMenu() {
        System.out.println("\n========== SHOPPING CART MENU ==========");
        System.out.println("1. Add Item to Cart");
        System.out.println("2. Remove Item from Cart");
        System.out.println("3. Update Item Quantity");
        System.out.println("4. View Cart");
        System.out.println("5. Undo Last Action");
        System.out.println("6. Redo Last Action");
        System.out.println("7. Checkout");
        System.out.println("8. Exit");
        System.out.print("Please enter your choice: ");
    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        ShoppingCart cart = new ShoppingCart();
        OrderQueue orderQueue = new OrderQueue();
        java.util.Vector<Order> existingOrders = new java.util.Vector<>();

        int choice;

        do {
            displayMenu();
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int addID = input.nextInt();

                    System.out.print("Enter Quantity: ");
                    int qty = input.nextInt();

                    product prod = catalog.searchByID(addID);

                    if (prod != null) {
                        cart.addItem(prod, qty);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeID = input.nextInt();
                    cart.removeItem(removeID);
                    break;

                case 3:
                    System.out.print("Enter Product ID to update Quantity: ");
                    int updateID = input.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = input.nextInt();

                    cart.updateQuantity(updateID, newQty);
                    break;

                case 4:
                    cart.viewCart();
                    break;

                case 5:
                    cart.undo();
                    break;

                case 6:
                    cart.redo();
                    break;

                case 7:
                    Order order = cart.checkout("", customer);

                    if (order != null) {
                        order.generateOrderID(existingOrders);
                        existingOrders.add(order);
                        orderQueue.Enqueue(order);

                        System.out.println("Checkout successful.");
                        System.out.println("Order ID: " + order.GetOrderID());
                    }
                    break;

                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        input.close();
    }
}