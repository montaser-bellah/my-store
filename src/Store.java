import java.util.ArrayList;

public class Store {
    String name ;
    static ArrayList<Category> categories ;
    static ArrayList<Merchant> merchants ;
    static ArrayList<Customer> customers ;



    Store(String name) {
        this.name = name ;
        init();

    }

    public void init () {
        categories = new ArrayList<>();
        merchants = new ArrayList<>() ;
        customers = new ArrayList<>();
    }
}
