public class Merchant extends Person{
    public MerchantServices merchantServices ;
    Merchant(String userName, String password, String birthYear) {
        super(userName, password, birthYear);
        super.setUserType("Admin");
        this.merchantServices = new MerchantServices();
        Store.merchants.add(this);
    }
    public Merchant() {
        super.setUserType("Admin");
        this.merchantServices = new MerchantServices();
        Store.merchants.add(this);

    }


}
