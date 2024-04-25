public class Merchant extends Person{
    MerchantServices merchantServices ;
    Merchant(String userName, String password, String birthYear) {
        super(userName, password, birthYear);
        this.merchantServices = new MerchantServices();
    }
    Merchant() {
        this.merchantServices = new MerchantServices();

    }
}
