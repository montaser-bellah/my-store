public class CustomerServices extends  Services {
    Customer customer ;
    CustomerServices(Customer customer) {
        this.customer = customer ;
    }

    public void mainMenu() {
        int action;
        do {
            System.out.println("CUSTOMER Main Menu :) ");
            System.out.println("1. Display All Categories ");
            System.out.println("2. Display All Products with short Details in Category ");
            System.out.println("3. About Me ");
            System.out.println("4. Update my Data ");
            System.out.println("5. Buy New Products ");
            System.out.println("6. Exit 👉");
            action = Main.readerNumbers.nextInt();
            switch (action) {
                case 1:
                    super.displayAllCategories();
                    break;

                case 2:
                    super.displayAllProductInCategory();
                    break;

                case 3 :
                    System.out.println(customer.aboutMe());
                    break;

                case 4 :
                    this.updateMyData();
                    break;

                case 5 :
                    this.buyProducts();
                    break;

            }


        } while (action != 6);

    }

    public void updateMyData() {
        System.out.println("<<< Update My DATA >>> \n");
        if(Store.customers.isEmpty()){
            System.out.println("NO Customers, Please Sign Up then Update you DATA :) ");
            return ;
        }
        System.out.println("Please Enter New Name .");
        customer.setUserName(Main.readerStrings.nextLine());
        System.out.println("Please Enter New Password .");
        customer.setPassword(Main.readerStrings.nextLine());
        System.out.println("Please Enter New Birth Date .");
        customer.setBirthDate(Main.readerStrings.nextLine());
        System.out.println("YOur DATA was Updated successfully 😉");
        System.out.println(customer.aboutMe());
    }

    public void buyProducts() {
        System.out.println("<<< Buy Products & Added to Bill >>>\n");
        String answer ;

        do {
            // display categories with category Name & category Number .
            System.out.println("Please Select that suits You .");
            Category category = super.receivingCategory();
            if (category == null) {
                System.out.println("No Categories with the Number your selected !");
                return;
            }
            category.displayProducts();
            System.out.println("Please Select ID / Number of product you needed .");
            Product product = category.getProductByNumber(Main.readerNumbers.nextInt());
            if (product == null) {
                System.out.println("NO Products with the Number your Selected !");
                return;
            }

            customer.getBill().getCurrentBill(product);


            System.out.println("Do you want to buy something else ? (Y, N) 👇");
            answer = Main.readerStrings.nextLine();


        }while (answer.toLowerCase().equals("y"));

        // fill Bill Details if the answer == NO "n" ;

       customer.getBill().getFullDetails();

       nextOfBuyProduct();





    }



    public void nextOfBuyProduct() {
        int choice ;

        do {
        System.out.println("\n1. Add another Bill\n" +
                "2. Amendment to a Bill after completing the purchase process\n" +
                "3. Print all Bills\n" +
                "4. End the program");

            choice = Main.readerNumbers.nextInt();
            switch(choice) {
                case 1 :
                    createNewBill();
                    break;

                case 2 :
                    updatingBillDataAfterBuying();
                    break;

                case 3 :
                    customer.printAllBills();


            }

        }while(choice !=4);


    }

    public void createNewBill() {
        System.out.println("<<< Create New Bill >>>\n");
        customer.createNewBillV2();
        buyProducts();

    }

    public void updatingBillDataAfterBuying() {
        System.out.println("<<< Updating Bill DATA After Buying >>>\n");
        System.out.println("Please Enter Bill Number / ID");
        int input = Main.readerNumbers.nextInt() ;
        Bill bill = customer.getBillById(input);
        if(bill == null) {
            System.out.println("Bill ID incorrect, please try again :) ");
            return;
        }

        this.billServices(bill);




    }

    public void deleteProductByName(Bill bill) {
        System.out.println("<<< Deleting Products After Buying >>>\n");
        System.out.println("Please Enter Product Name .");
        String input = Main.readerStrings.nextLine();
        Product product =bill.getProductByName(input);
        if(product == null) {
            System.out.println("product Name incorrect ! , try again :) ");
            return ;

        }
        bill.deleteProduct(product);
        bill.updateCart();
        System.out.println("Product was successfully Deleted .");
        System.out.println(bill);

    }

    public void billServices(Bill bill) {
        System.out.println("1. Adding New Products\n2. Deleting Products\n3. Deleting this Bill ");
        int action = Main.readerNumbers.nextInt() ;

        switch (action) {

            case 1 :
                buyProducts();
                break;

            case 2 :deleteProductByName(bill);
                break;

            case 3 :
                customer.deletingBill(bill);
                break;
        }

    }





}
