import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    private static int number;

    private int billId ;
    private ArrayList<Product> purchasedProducts ;
    private  String customerName ;
     float amount , amountAfterDiscount ;
    private double discountPercentage = 0.1 ;
    private LocalDate purchaseDate;
    private String currencyType;



    Bill(){
        this.number++ ;
        this.billId = number;
        this.purchaseDate = LocalDate.now() ;
        this.purchasedProducts = new ArrayList<>( );
//        System.out.println("Bill number = "+ number);
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }



    @Override
    public String toString() {
        return "▶ Bill{ " +
                "number=" + billId +
                ", customerName='" + customerName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", amount=" + amount +
                ", discountPercentage=" + discountPercentage +
                ", Amount after discount=" + this.calcTotalAmount() +
                ",\n🔻purchasedProducts=" + purchasedProducts +

                '}';
    }

    public double calcTotalAmount() {
      this.amountAfterDiscount =
             purchasedProducts.size() > 100 || this.amount > 50 ? (int)(amount - amount *discountPercentage)  : amount ;
      return amountAfterDiscount ;
    }


    public void processPayment() {
        System.out.println("Please Select the type of transaction you want to pay with .");
        System.out.println("1. USD $\n2. ILS ₪ \n3. JOD ₫");
        int choice = Main.readerNumbers.nextInt() ;
        System.out.println("Please Enter Your Amount :) ");
        double customerAmount = Main.readerNumbers.nextDouble() ;
        switch(choice) {
            case 1 :
                customerAmount  *= 3.5 ;

                break;

            case 3 :
                customerAmount *=5 ;
                break;
        }
        System.out.println("Your Total Amount in Shekels: " + customerAmount);

    }

    public void getCurrentBill(Product product) {
        System.out.println("Please Enter the quantity you need ");
        int quantityNeeded = Main.readerNumbers.nextInt();
        if(product.getQuantity() < quantityNeeded) {
            System.out.println("Sorry, this quantity is not available, But the quantity is available: "+product.getQuantity());
            return ;
        }
        this.purchasedProducts.add(product);
        product.setQuantity(product.getQuantity() - quantityNeeded);

        double currentAmount = quantityNeeded * product.getPrice();
        this.amount +=currentAmount;
        System.out.println("The Current Bill is "+ currentAmount+" ||"
                +" Product Name: " +product.getName() +" || product quantity: " + quantityNeeded );
        System.out.println("...................................................................");

    }

    public void getFullDetails() {
        System.out.println("<<< Full Bill Details >>>");
        System.out.println(this.toString());



    }

    public String shortDetails() {
        return "Bill ID:" + this.billId + " || " + "Customer Name: " + this.customerName;
    }

    public void deleteProduct(Product product) {
        this.purchasedProducts.remove(product);

    }

  public Product getProductByName(String input) {
        if(this.purchasedProducts.isEmpty())
            return null;
        for(Product p : purchasedProducts)
            if(p.getName().equals(input))
                return p ;
        return null;

    }


    public  void updateCart() {
        this.amount = 0 ;
        for(Product product : this.purchasedProducts) {
            this.amount += product.getPrice() * product.getQuantity();


        }
        this.amountAfterDiscount = (float)this.calcTotalAmount();

    }


}
