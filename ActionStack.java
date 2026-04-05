public class ActionStack {
    private StackNode top;

    public ActionStack() {
        top = null;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Pushes a new action onto the top of the stack
    public void push(Action action) {
        StackNode newNode = new StackNode(action);
        newNode.setNext(top);
        top = newNode;
    }

    // Removes and returns the top action from the stack
    public Action pop() {
        if (isEmpty()) {
            return null;
        }

        Action temp = top.getData();
        top = top.getNext();
        return temp;
    }

    // Returns the top action without removing it
    public Action peek() {
        if (isEmpty()) {
            return null;
        }

        return top.getData();
    }

    // Clears all elements from the stack
    public void clear() {
        top = null;
    }
}