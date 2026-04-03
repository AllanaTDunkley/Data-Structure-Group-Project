public class product {
    
    private int id;
    private String name;
    private String description;
    private int quantity;
    private float price;


    public product(int prodid, String prodname, String proddesc, int prodquantity, float prodprice){
        this.id = prodid;
        this.name = prodname;
        this.description = proddesc;
        this.quantity = prodquantity;
        this.price = prodprice;
    }

    float getprice(){
        return this.price;
    }

    int getquantity(){
        return this.quantity;
    }

    int getid(){
        return this.id;
    }

    String getname(){
        return this.name;
    }

    String getproductinfo(){
        return "ID: " + id +" - " + name + " - " + description + " - " + "Quantity: "+ quantity + " - " + "$"+price;
    }
}
