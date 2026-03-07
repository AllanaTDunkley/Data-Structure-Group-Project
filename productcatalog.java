import java.util.LinkedList;

public class productcatalog {
    
    private int id;
    private String catalogname;
    private LinkedList<product> catalog;
    private ProductNode head;


    public productcatalog(String catname, int catid){
        this.id = catid;
        this.catalogname = catname;
    }


    public void initalizecatalog(ProductNode value){
        if(head == null){
            head = value;

        }

        System.out.println("Product Catalog made successfully");
    };

    public void addproducttotheback(ProductNode value){
        ProductNode current = head;
        if(current == null){
            head = value;
        }else{
            while(current.next != null){
                
                current = head.next;

            }
            current.next = value;
        }
        
    }

    public void display(){
        System.out.println("----List of Products----");
        
        ProductNode current = head;
        while(current != null){
            
            System.out.println(current.getData() + "   ->  ");
            current = current.next;
            
        }
    }


    public void removeproductbyid(int id){

        ProductNode current = head;
        while(current != null){

            if(current.NodeID == id){
                head = current.next;
                System.out.println("Removed the product");
                return;
            }

            ProductNode nextone = current.next;
            if(nextone != null){
                if(nextone.NodeID == id){
                    current.next = nextone.next;
                    System.out.println("Removed the product");
                    return;
                }
            }
            current = current.next;
            
        }
    };

    public void searchbyname(String prodname){
        System.out.println("Remove product");
    };

    public void searchbyid(int id){
    System.out.println("----Search by Id----");
        ProductNode current = head;
        while(current != null){

            if(current.NodeID == id){
                String info = current.getData();
                System.out.println(info);
                return;
            }

            current = current.next;

            
            
        }
    };
}
