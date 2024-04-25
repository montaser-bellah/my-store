import java.util.Scanner;

public class Main {
    static Scanner readerStrings = new Scanner(System.in) ;
    static  Scanner readerNumbers = new Scanner(System.in);
    public static void main(String[] args) {

        Store myStore = new Store("montaser-Store");


        System.out.println("Hello world!");

        Person p = new Person("montaer", "m", "2020");

        Merchant m = new Merchant();
        m.merchantServices.mainMenu();
    }
}