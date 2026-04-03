public class ProductNode {
    
    public product data;
    public int NodeID;
    public ProductNode next;

    public ProductNode(product val){
        data = val;
        next = null;
        NodeID = val.getid();

    }


    String getData(){
        return data.getproductinfo();
    }
}
