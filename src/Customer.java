import java.util.ArrayList;

public class Customer extends Person {

    private Bill bill ;
     ArrayList<Bill> bills;
    public Customer() {
        super.setUserName("user");
        this.bill = new Bill();
        this.bills = new ArrayList<>();
        bills.add(bill);
        Store.customers.add(this);
    }

    public String aboutMe() {
        return "Name: " + super.getUserName() +" || " + "Birth Date: " + super.getBirthDate()+" || " +
                "Password: " + super.getPassword() ;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }


    public Bill createNewBill() {
        Bill bill = new Bill();
        this.bill = bill ;
        bills.add(bill);
        return bill ;
    }
    public void createNewBillV2() {
        Bill bill = new Bill();
        this.bill = bill ;
        bills.add(bill);
    }

    public void printAllBills() {
        if(this.bills.isEmpty()){
            System.out.println("NO Bills , Please create one then come in :) ");
            return ;
        }
        System.out.println("<<< All Bills in Your Account >>> \n");
        System.out.println("counts is "+ this.bills.size());
        for(Bill bill : this.bills)
            System.out.println(bill.toString());
    }

    public Bill getBillById(int input) {
        for(Bill bill : this.bills)
            if(bill.getBillId() == input)
                return bill ;
        return null;
    }


    public void deletingBill(Bill b) {
        this.bills.remove(b);
        System.out.println("This Bill was successfully Deleted .");
    }



}
