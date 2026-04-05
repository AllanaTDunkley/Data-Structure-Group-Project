import java.util.Vector;

public class CartLinkedList {
    private Node head;
    private Node tail;

    public CartLinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Searches the linked list and returns the node containing the matching product ID
    public Node searchNodeByProductID(int productID) {
        Node current = head;

        while (current != null) {
            if (current.getData().getProduct().getid() == productID) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    // Returns the CartItem for a given product ID
    public CartItem search(int productID) {
        Node foundNode = searchNodeByProductID(productID);

        if (foundNode != null) {
            return foundNode.getData();
        }

        return null;
    }

    // Inserts a new CartItem at the end of the linked list
    public void insert(CartItem item) {
        Node newNode = new Node(item);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    // Deletes the node containing the given product ID
    public boolean delete(int productID) {
        Node nodeToDelete = searchNodeByProductID(productID);

        if (nodeToDelete == null) {
            return false;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else if (nodeToDelete == head) {
            head = head.getNext();
            head.setPrev(null);
        } else if (nodeToDelete == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            nodeToDelete.getPrev().setNext(nodeToDelete.getNext());
            nodeToDelete.getNext().setPrev(nodeToDelete.getPrev());
        }

        return true;
    }

    // Traverses the linked list and displays each cart item
    public void traverse() {
        Node current = head;

        if (isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        while (current != null) {
            current.getData().displayCartItem();
            current = current.getNext();
        }
    }

    // Calculates the total cost of all items in the cart
    public double calculateTotal() {
        Node current = head;
        double total = 0.0;

        while (current != null) {
            total += current.getData().calculateSubtotal();
            current = current.getNext();
        }

        return total;
    }

    // Converts the linked list of cart items into a Vector for Order creation
    public Vector<CartItem> toVector() {
        Vector<CartItem> items = new Vector<>();
        Node current = head;

        while (current != null) {
            items.add(current.getData());
            current = current.getNext();
        }

        return items;
    }
}