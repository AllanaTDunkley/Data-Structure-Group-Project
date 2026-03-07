public class Main{
    public static void main(String[] args) {
    
        product table = new product(1, "Table", "Used to hold items", 5, 5);
        product desk = new product(2, "Desk", "Used to hold items", 5, 5);
        product pencil = new product(3, "Table", "Used to hold items", 5, 5);

        float prodprice = table.getprice();

        productcatalog c1 = new productcatalog("Main product Catalog", 1);
        ProductNode node1 = new ProductNode(table);
        ProductNode node2 = new ProductNode(desk);
        ProductNode node3 = new ProductNode(pencil);

        c1.initalizecatalog(node1);
        c1.addproducttotheback(node2);
        c1.addproducttotheback(node3);

        c1.display();

        

        c1.display();

        c1.searchbyid(3);
    }
}