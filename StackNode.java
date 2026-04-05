public class StackNode {
    private Action data;
    private StackNode next;

    // Constructor to initialize a node with an Action
    public StackNode(Action data) {
        this.data = data;
        this.next = null;
    }

    // Returns the Action stored in this node
    public Action getData() {
        return data;
    }

    // Returns reference to the next node in the stack
    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}