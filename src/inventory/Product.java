package inventory;

import moviebooking.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product {
    private String name;
    private String category;
    private int quantity;
    private double pricePerUnit;

    static Product[] productList = new Product[100];
    static int productCount = 0;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Product(String nam,String cat,int quan,double price){
        this.name = nam;
        this.category = cat;
        this.quantity = quan;
        this.pricePerUnit = price;
    }
    public static void productRegistration() throws IOException {
        boolean flag = true;
        while (flag){
            Product newProduct = getProductInfo();
            productList[productCount]  = newProduct;
            productCount +=1;
            System.out.println("Wanna add more??? yes/no");
            String userInput = bufferedReader.readLine();
            if(userInput.equalsIgnoreCase("no")){
                flag = false;
            }
        }
    }

public static Product getProductInfo() throws IOException{
    System.out.println("<<<<<<<<<<< Product Registration >>>>>>>>>>>>");
    System.out.print("Enter Product Name :");
    String name = bufferedReader.readLine().trim();
    System.out.println("Enter Category :");
    String category = bufferedReader.readLine().trim();
    System.out.println("Enter quantity :");
    int quantity = Integer.parseInt(bufferedReader.readLine().trim());
    System.out.println("Enter price per unit : ");
    double price = Double.parseDouble(bufferedReader.readLine().trim());

    Product product = new Product(name,category,quantity,price);
    return product;
}
public static void displayAllProduct(){
        System.out.println("********** Displaying all products **********");
        int index = 1;
        for(Product product: productList){
            if(product != null){
                System.out.print(index + " "+product.name+"\n");
                index ++;
            }
        }
}
public static void totalValue( ){
    double total = 0;
    for(Product product : productList){
        if(product != null){
            double value = product.quantity * product.pricePerUnit;
            total += value;
        }
    }
    System.out.println("Inventory has total values of : "+total+" in Baht");
}

public static void highestQuantity(){
        Product first = productList[0];
        for(int i = 1; i <productCount-1;i++){
            if(first.quantity < productList[i].quantity){
                first = productList[i];
            }
        }
        System.out.println("Product Name : "+first.name+" has the highest quantity...\nTotal quantity : "+first.quantity);
}

@Override
public String toString(){
    return "Product->\t"+
            "Name : "+this.name+
            " Category : "+this.category+
            " Quantity : "+this.quantity+
            "PricePerUnit : "+this.pricePerUnit;
}
}

