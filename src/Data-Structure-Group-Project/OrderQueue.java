package ds_Group_Project;

public class OrderQueue {
	private OrderNode front;
	private OrderNode rear;
	
	public OrderQueue() {
		front = null;
		rear = null;
	}
	
	//Accessors and Mutators
	public OrderNode getFront() { return front; }
	public void setFront(OrderNode f) { front = f; }
	public OrderNode getBack() { return rear; }
	public void setBack(OrderNode b) { rear = b; }
	
	public void Enqueue(Order o) {
		//create a temporary node to store the data entered
		OrderNode temp =  new OrderNode(o);
		if(temp != null) {
			//check if the queue is empty
			if(front == null) {
				front = temp; 
				rear = temp;
			} else { //if not, inserts node from the end of the queue
				rear.setNextNode(temp);
				temp.setPrevNode(rear);
				rear = temp;
			}
		}
	}
	
	public Order Dequeue() {
		//create a order object to store the data to be removed
		Order returndata = new Order();
		if(front != null) {
			//check if the queue is empty
			if(front == rear) {
				rear = null;
			}
			
			//create a temporary node that points to the front of the queue
			//then the data to be removed is stored and then removed
			OrderNode tempNode = front;
			returndata = front.getData();
			front = front.getNextNode();
			if(front != null) { front.setPrevNode(null); }
			tempNode = null;
		} else {
			System.err.println("There's nothing in the queue to remove");
		}
		return returndata;
	}
	
	public Order QueueFront() {
		//checks if the queue is empty
		if(front == null) {
			System.out.println("The queue is empty, there's nothing to return");
			return null;
		} 
		return front.getData();
	}
	
	public Order QueueRear() {
		//checks if the queue is empty
		if(front == null) {
			System.out.println("Queue is empty, there's nothing to return");
			return null;
		}
		return rear.getData();
	}
	
	public int Count() {
		int cnt = 0;
		OrderQueue queue = new OrderQueue();
	
		//while the original queue is not empty
		while(front != null) {
			queue.Enqueue(Dequeue()); //remove the nodes from the original queue to the temp queue
			 cnt++;
		}
		
		//while the temp queue is not empty, add the nodes back to the original queue
		while(queue.getFront() != null) {
			Enqueue(queue.Dequeue());
		}
		
		return cnt;
	}
	
	public boolean IsEmpty() {
		if(front == null) {
			System.out.println("The queue is empty");
			return true;
		}
			
		else return false;
	}
	
	public void DisplayQueue() {
		OrderNode curr = front;
		if(front != null) {
			//check if the queue is empty
			if(curr == null) { 
				System.out.println("Queue is empty, nothing to display");
				return;
			}
			
			//loops through the queue and prints the data until it reaches the end
			while(curr != null) {
				System.out.println(curr.getData());
				curr = curr.getNextNode();
			}
		}
	}
}
