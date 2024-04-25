public class Product {
   private String name, description, color  ;
    private int productNumber ;
   private float price ;
   private int quantity ;

    public Product() {
    }

    public Product(String name, String description, String color, int productNumber, float price, int quantity) {
        this.name = name;
        this.description = description;
        this.color = color;
        this.productNumber = productNumber;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product { " +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", productNumber=" + productNumber +
                ", price=" + price +
                ", quantity=" + quantity +
                " }";
    }
}
