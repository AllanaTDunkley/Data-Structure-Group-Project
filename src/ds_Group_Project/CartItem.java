package ds_Group_Project;

public class CartItem {
	private Product prod;
	private int quantity;
	
	public CartItem() {
		prod = new Product();
		quantity = 1;
	}
	
	public CartItem(Product p, int q) {
		prod = p;
		quantity = q;
	}
	
	
	public Product GetProduct() { return prod; }
	public int GetQuantity() { return quantity; }
	public void SetProduct(Product p) { prod = p; }
	public void SetQuantity(int q) { quantity = q; }
	
	public double CalculateTotal() { 
		double total = prod.getPrice() * quantity;
		return  total;
	}
	
	@Override
	public String toString() {
		return prod.getName() + " * " + quantity + " @ " + prod.getPrice() + " = $" + CalculateTotal();
	}
}
