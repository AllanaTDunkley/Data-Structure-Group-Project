public class Action {
    private String actionType;
    private product product;
    private int oldQty;
    private int newQty;

    // Stores details of a cart operation for undo/redo
    public Action(String actionType, product product, int oldQty, int newQty) {
        this.actionType = actionType;
        this.product = product;
        this.oldQty = oldQty;
        this.newQty = newQty;
    }

    public String getActionType() {
        return actionType;
    }

    // Returns the product associated with the action
    public product getProduct() {
        return product;
    }

    public int getOldQty() {
        return oldQty;
    }

    public int getNewQty() {
        return newQty;
    }
}