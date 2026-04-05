import java.util.Vector;

public class ShoppingCart {
    private CartLinkedList itemList;
    private ActionStack undoStack;
    private ActionStack redoStack;

    public ShoppingCart() {
        itemList = new CartLinkedList();
        undoStack = new ActionStack();
        redoStack = new ActionStack();
    }

    // Adds a new item to the cart or updates the quantity if it already exists
    public void addItem(product prod, int qty) {
        if (prod == null) {
            System.out.println("Invalid product.");
            return;
        }

        if (qty <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        CartItem existingItem = itemList.search(prod.getid());

        if (existingItem == null) {
            CartItem newItem = new CartItem(prod, qty);
            itemList.insert(newItem);

            Action action = new Action("ADD", prod, 0, qty);
            undoStack.push(action);
            redoStack.clear();

            System.out.println(prod.getname() + " added to cart.");
        } else {
            int oldQty = existingItem.getQuantity();
            int newQty = oldQty + qty;
            existingItem.setQuantity(newQty);

            Action action = new Action("UPDATE", prod, oldQty, newQty);
            undoStack.push(action);
            redoStack.clear();

            System.out.println("Quantity updated for " + prod.getname());
        }
    }

    // Removes an item from the cart and stores the action for undo
    public void removeItem(int productID) {
        CartItem item = itemList.search(productID);

        if (item == null) {
            System.out.println("Item not found in cart.");
            return;
        }

        Action action = new Action("REMOVE", item.getProduct(), item.getQuantity(), 0);

        boolean removed = itemList.delete(productID);

        if (removed) {
            undoStack.push(action);
            redoStack.clear();
            System.out.println(item.getProduct().getname() + " removed from cart.");
        }
    }

    // Updates the quantity of an item already in the cart
    public void updateQuantity(int productID, int newQty) {
        CartItem item = itemList.search(productID);

        if (item == null) {
            System.out.println("Item not found in cart.");
            return;
        }

        int oldQty = item.getQuantity();

        if (newQty <= 0) {
            removeItem(productID);
            return;
        }

        item.setQuantity(newQty);

        Action action = new Action("UPDATE", item.getProduct(), oldQty, newQty);
        undoStack.push(action);
        redoStack.clear();

        System.out.println("Quantity updated for " + item.getProduct().getname());
    }

    // Displays all items currently in the cart and the total cost
    public void viewCart() {
        itemList.traverse();
        System.out.println("Total: $" + itemList.calculateTotal());
    }

    // Creates an Order from the current cart contents
    public Order checkout(String orderID, Customer customer) {
        if (itemList.isEmpty()) {
            System.out.println("Cannot checkout. Cart is empty.");
            return null;
        }

        Vector<CartItem> itemsVector = itemList.toVector();
        DateTime timestamp = new DateTime();
        double totalAmount = itemList.calculateTotal();
        String orderStatus = "Processing";

        Order newOrder = new Order(orderID, itemsVector, timestamp, customer, totalAmount, orderStatus);

        itemList = new CartLinkedList();
        undoStack.clear();
        redoStack.clear();

        System.out.println("Checkout successful. Order created.");
        return newOrder;
    }

    // Reverses the most recent cart action
    public void undo() {
        Action lastAction = undoStack.pop();

        if (lastAction == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        if (lastAction.getActionType().equals("ADD")) {
            itemList.delete(lastAction.getProduct().getid());
        } else if (lastAction.getActionType().equals("REMOVE")) {
            CartItem restoredItem = new CartItem(lastAction.getProduct(), lastAction.getOldQty());
            itemList.insert(restoredItem);
        } else if (lastAction.getActionType().equals("UPDATE")) {
            CartItem item = itemList.search(lastAction.getProduct().getid());
            if (item != null) {
                item.setQuantity(lastAction.getOldQty());
            }
        }

        redoStack.push(lastAction);
        System.out.println("Undo successful.");
    }

    // Reapplies the most recently undone action
    public void redo() {
        Action action = redoStack.pop();

        if (action == null) {
            System.out.println("Nothing to redo.");
            return;
        }

        if (action.getActionType().equals("ADD")) {
            CartItem item = itemList.search(action.getProduct().getid());

            if (item == null) {
                CartItem restoredItem = new CartItem(action.getProduct(), action.getNewQty());
                itemList.insert(restoredItem);
            } else {
                item.setQuantity(action.getNewQty());
            }
        } else if (action.getActionType().equals("REMOVE")) {
            itemList.delete(action.getProduct().getid());
        } else if (action.getActionType().equals("UPDATE")) {
            CartItem item = itemList.search(action.getProduct().getid());
            if (item != null) {
                item.setQuantity(action.getNewQty());
            }
        }

        undoStack.push(action);
        System.out.println("Redo successful.");
    }
}