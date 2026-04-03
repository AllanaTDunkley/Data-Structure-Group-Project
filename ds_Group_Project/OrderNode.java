package ds_Group_Project;

import java.util.Vector;

public class OrderNode {
	private Order data;
	private OrderNode prevNode;
	private OrderNode nextNode;
	
	//Constructors
	public OrderNode() {
		data = new Order();
		prevNode = null;
		nextNode = null;
	}
	
	public OrderNode(Order d) {
		data = d;
		prevNode = null;
		nextNode = null;
	}
	
	public OrderNode(String id, Vector<CartItem> i, DateTime dt, Customer c, double t, String status) {
		data = new Order(id, i, dt, c, t, status);
		prevNode = null;
		nextNode = null;
	}
	
	//Accessors and Mutators
	public Order getData() { return data; }
	public void setData(Order d) { data = d;}
	public OrderNode getPrevNode() { return prevNode; }
	public void setPrevNode(OrderNode prev) { prevNode = prev; }
	public OrderNode getNextNode() { return nextNode; }
	public void setNextNode(OrderNode next) { nextNode = next; }
}
