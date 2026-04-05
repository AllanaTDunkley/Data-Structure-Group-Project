public class CartItem {
    private product product;
    private int quantity;

    // Stores a product and the quantity selected by the customer
    public CartItem(product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Returns the product associated with this cart item
    public product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculates subtotal = price × quantity
    public double calculateSubtotal() {
        return product.getprice() * quantity;
    }

    // Displays cart item details
    public void displayCartItem() {
        System.out.println(product.getname() + " | Qty: " + quantity +" | Unit Price: $" + product.getprice() +" | Subtotal: $" + calculateSubtotal());
    }
}