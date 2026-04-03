package ds_Group_Project;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        // ---------------------------------------
        // 1. Create sample products
        // ---------------------------------------
        Product p1 = new Product("Laptop", 1001, "HP Envy 16", 10, 150000f);
        Product p2 = new Product("Mouse", 1002, "Wireless Mouse", 50, 2500f);
        Product p3 = new Product("Keyboard", 1003, "Mechanical Keyboard", 30, 8500f);

        // ---------------------------------------
        // 2. Create cart items
        // ---------------------------------------
        CartItem ci1 = new CartItem(p1, 1);
        CartItem ci2 = new CartItem(p2, 2);
        CartItem ci3 = new CartItem(p3, 1);

        Vector<CartItem> cart1 = new Vector<>();
        cart1.add(ci1);
        cart1.add(ci2);

        Vector<CartItem> cart2 = new Vector<>();
        cart2.add(ci3);

        // ---------------------------------------
        // 3. Create customers
        // ---------------------------------------
        Customer c1 = new Customer("John", "Doe", "johndoe@gmail.com", "iamjohndoe");
        Customer c2 = new Customer("Jane", "Smith", "jsmith@yahoo.com", "itzjanesmith");

        // ---------------------------------------
        // 4. Create orders
        // ---------------------------------------
        Order o1 = new Order();
        o1.SetCustomer(c1);
        o1.SetCartItem(cart1);
        o1.SetTotal(ci1.CalculateTotal() + ci2.CalculateTotal());

        Order o2 = new Order();
        o2.SetCustomer(c2);
        o2.SetCartItem(cart2);
        o2.SetTotal(ci3.CalculateTotal());

        // ---------------------------------------
        // 5. Generate unique order IDs
        // ---------------------------------------
        Vector<Order> existingOrders = new Vector<>();
        existingOrders.add(o1);
        existingOrders.add(o2);

        o1.generateOrderID(existingOrders);
        o2.generateOrderID(existingOrders);

        // ---------------------------------------
        // 6. Create queue and enqueue orders
        // ---------------------------------------
        OrderQueue queue = new OrderQueue();
        queue.Enqueue(o1);
        queue.Enqueue(o2);

        // ---------------------------------------
        // 7. Display queue
        // ---------------------------------------
        System.out.println("=== DISPLAY QUEUE ===");
        queue.DisplayQueue();

        // ---------------------------------------
        // 8. Show front and rear
        // ---------------------------------------
        System.out.println("\n=== FRONT OF QUEUE ===");
        System.out.println(queue.QueueFront());

        System.out.println("\n=== REAR OF QUEUE ===");
        System.out.println(queue.QueueRear());

        // ---------------------------------------
        // 9. Count queue items
        // ---------------------------------------
        System.out.println("\nQueue Count: " + queue.Count());

        // ---------------------------------------
        // 10. Update order status
        // ---------------------------------------
        System.out.println("\n=== UPDATE ORDER STATUS ===");
        o1.UpdateOrderStatus("Shipped");
        System.out.println(o1);

        // ---------------------------------------
        // 11. Dequeue
        // ---------------------------------------
        System.out.println("\n=== DEQUEUE ===");
        Order removed = queue.Dequeue();
        System.out.println("Removed Order:\n" + removed);

        // ---------------------------------------
        // 12. Display queue again
        // ---------------------------------------
        System.out.println("\n=== DISPLAY QUEUE AFTER DEQUEUE ===");
        queue.DisplayQueue();
    }
}