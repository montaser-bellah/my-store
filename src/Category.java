import java.util.ArrayList;

public class Category {
   private String name, description ;
  private  int itemNumber , productCounts  ;

   private ArrayList<Product> products ;

    public Category(String name, int itemNumber, String description) {
        this.name = name;
        this.itemNumber = itemNumber;
        this.description = description;
        this.products = new ArrayList<>();
    }

    Category() {
        this.products = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductCounts() {
        return productCounts;
    }

    public void setProductCounts(int productCounts) {
        this.productCounts = productCounts;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Category { " +
                "Item Number='" + itemNumber + '\'' +
                ", Name=" + name + '\'' +
                ", description='" + description + '\'' +
                ", Product Counts =" + this.products.size() +
                '}';
    }


    //////////////////////////////////////////////////// Functions //////////////////////////////////////////////////////////////
public void updateCategory() {
    System.out.println("Please Enter the New Name Category .");
    this.setName(Main.readerStrings.nextLine());
    System.out.println("Please Enter the New Description Category .");
    this.setDescription(Main.readerStrings.nextLine());
    System.out.println("Please Enter the New ID / Number Category .");
    this.setItemNumber(Main.readerNumbers.nextInt());

    System.out.println("The operation was completed successfully :) ");
}



    public void addProduct() {
        System.out.println("<<< Add New Products >>>\n");
        Product product = new Product();
        System.out.println("Please Enter Product Name .");
        product.setName(Main.readerStrings.nextLine());
        System.out.println("Please Enter Product Description .");
        product.setDescription(Main.readerStrings.nextLine());
        System.out.println("Please Enter Product Color .");
        product.setColor(Main.readerStrings.next());
        System.out.println("Please Enter product Number .");
        product.setProductNumber(Main.readerNumbers.nextInt());
        System.out.println("Please enter Product Quantity .");
        product.setQuantity(Main.readerNumbers.nextInt());
        System.out.println("Please Enter Product Price .");
        product.setPrice(Main.readerNumbers.nextFloat());
        this.products.add(product);
        System.out.println("Product Successfully added :) ");
        Main.readerStrings.nextLine();
        System.out.println(this.products);


    }



    static Category getCategoryByNumber(int number) {
        if(Store.categories.isEmpty())return null ;

        for(Category category : Store.categories) {
            if(category.getItemNumber() == number)
                return category ;
        }
        return null;
    }


    public void displayProducts() {
        System.out.println(">>> All Products in " +this.name +"\n");
        for(Product product : this.products)
            System.out.println("product Name: " +product.getName() + ",  Product Number / ID:" +product.getProductNumber());

    }

    public void displayAllProducts() {
        for(Product product : this.products)
            System.out.println(product.shortDetails());
    }




    public Product getProductByNumber(int input) {
        for(Product product : this.products ) {
            if(product.getProductNumber()== input)
                return product ;
        }
        return null ;
    }
}
