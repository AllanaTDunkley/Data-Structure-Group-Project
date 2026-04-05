public class Node {
    private CartItem data;
    private Node next;
    private Node prev;

    // Constructor to initialize a node with a CartItem
    public Node(CartItem data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Returns the CartItem stored in this node
    public CartItem getData() {
        return data;
    }

    public void setData(CartItem data) {
        this.data = data;
    }

    // Returns reference to the next node in the list
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    // Returns reference to the previous node (doubly linked list)
    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}