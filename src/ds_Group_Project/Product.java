package ds_Group_Project;

public class Product {
	private String name;
	private int ID;
	private String description;
	private int quantity;
	private float price;
	
	public Product() {
		name = "Laptop";
		ID = 0024;
		description = "16 inch HP Envy 360x Laptop";
		quantity = 100;
		price = 50000.50f;
	}
	
	public Product(String n, int id, String desc, int quan, float p) {
		name = n;
		ID = id;
		description = desc;
		quantity = quan;
		price = p;
	}
	
	public String getName() { return name; }
	public int getID() { return ID; }
	public String getDescription() { return description; }
	public int getQuantity() { return quantity; }
	public float getPrice() { return price; }
	
	public void setName(String n) { name = n; }
	public void setID(int id) { ID = id; }
	public void setDescription(String d) { description = d; }
	public void setQuantity(int q) { quantity = q; }
	public void setPrice(float p) { price = p; }

	
}
