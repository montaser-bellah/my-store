public class Person {
    String userName, password, birthYear, userType ;
    Person() {

    }

    Person(String userName, String password, String birthYear) {
        this.userName = userName ;
        this.password = password ;
        this.birthYear = birthYear ;
        System.out.println(this.userName);
    }
}
