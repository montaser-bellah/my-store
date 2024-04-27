public class Person {
   private String userName, password, birthDate, userType ;
    Person() {
        Store.persons.add(this);

    }

    public Person(String userName, String password, String birthDate) {
        this.userName = userName ;
        this.password = password ;
        this.birthDate = birthDate ;
        Store.persons.add(this);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
