import java.util.ArrayList;

public class Store {
    String name ;
    static ArrayList<Category> categories ;
    static ArrayList<Person> persons;
    static ArrayList<Merchant> merchants ;
    static ArrayList<Customer> customers ;
    static ArrayList<Bill> bills ;



    public Store(String name) {
        this.name = name ;
        System.out.println("Welcome in "+this.name.toUpperCase());
        init();

    }

    public void init () {
        categories = new ArrayList<>();
        persons = new ArrayList<>();
        merchants = new ArrayList<>() ;
        customers = new ArrayList<>();
        bills = new ArrayList<>( );
        start();

    }


    public void start() {
        do {
            signUp();
            loginV2();
            System.out.println("Do you want to exit the program? (Y, N)");
            String answer = Main.readerStrings.nextLine();
            if(answer.toLowerCase().equals("y"))
                break;
        }while(true);
    }


    public void signUp() {
        if(!Store.persons.isEmpty())return ;
        System.out.println("<<< SING UP SCREEN >>>\n");
        System.out.println("Are You\n1. Merchant\n2. Customer  ");
        int choice = Main.readerNumbers.nextInt();

        switch (choice){
            case 1:
                signUpAsMerchant();
                break;

            case 2 :
               signUpAsCustomer();
                break;
        }

        System.out.println("Persons" + Store.persons);
        System.out.println("Merchants" + Store.merchants);
        System.out.println("Customers "+ Store.customers);


    }

    public void signUpAsMerchant() {
        Merchant m = new Merchant();
        System.out.println("Please Enter Your UserName .");
        m.setUserName(Main.readerStrings.nextLine());
        System.out.println("Please Enter Your Password .");
        m.setPassword(Main.readerStrings.nextLine());
        System.out.println("Please Enter Your Birthdate .");
        m.setBirthDate(Main.readerStrings.nextLine());
    }

    public void signUpAsCustomer() {
        Customer c = new Customer() ;
        System.out.println("Please Enter Your UserName .");
        c.setUserName(Main.readerStrings.nextLine());
        System.out.println("Please Enter Your Password .");
        c.setPassword(Main.readerStrings.nextLine());
        System.out.println("Please Enter Your Birthdate .");
        c.setBirthDate(Main.readerStrings.nextLine());

    }

     public void loginV2() {
        System.out.println("<<<<< LOGIN SCREEN >>>>>\n");
        System.out.println("Please Enter Your UserName :)");
        String userName = Main.readerStrings.nextLine();
        System.out.println("Please Enter YOur Password :) ");
        String password = Main.readerStrings.nextLine();
        Person person = getPerson(userName, password);

        if(person == null){
            System.out.println("UserName or Password incorrect ! , try again .");
            return ;
        }
        if(person instanceof Merchant) {
            Merchant merchant = (Merchant) person;
            Store.merchants.add(merchant);
            merchant.merchantServices.mainMenu();
        } if(person instanceof Customer) {
             Customer customer = (Customer) person;
            Store.customers.add(customer);
            CustomerServices cs = new CustomerServices(customer);
            cs.mainMenu();
        }



    }


    public Person getPerson(String userName, String password) {
        for(Person person : Store.persons){
            if(person.getUserName().equals(userName)&&person.getPassword().equals(password))
                return person;
        }
        return null;

    }
}
