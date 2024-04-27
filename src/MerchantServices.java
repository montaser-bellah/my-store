
public class MerchantServices extends Services {
//    Merchant merchant ;
//
//    MerchantServices(Merchant merchant) {
//        this.merchant = merchant ;
//    }


    public void mainMenu() {
        int action ;
        do {
        System.out.println("MERCHANT Main Menu :) ");
        System.out.println("1. Add New Category ");
        System.out.println("2. Add New Product ");
        System.out.println("3. Update Category data");
        System.out.println("4. Update Product Data");
        System.out.println("5. Display All Categories ");
        System.out.println("6. Display All Products with short Details in Category ");
            System.out.println("7. ADD New Customers ");
            System.out.println("8. Exit ");
         action = Main.readerNumbers.nextInt() ;
     switch (action) {
         case 1 : addCategories();
         break ;

         case 2: addProduct();
         break;

         case 3 : updateCategoryData();
         break;


         case 4 : updateProductData();
         break ;

         case 5 : super.displayAllCategories();
         break;

         case 6 : super.displayAllProductInCategory();
         break;

         case 7 :
             addCustomers();
             break;



     }


        }while(action != 8);




    }

    public void addCategories() {
        System.out.println("<<< Add New Categories >>>\n");
        Category category = new Category() ;
        System.out.println("Please Enter Category Name .");
        category.setName(Main.readerStrings.next());
        System.out.println("Please Enter Category Description .");
        category.setDescription(Main.readerStrings.next());
        Main.readerStrings.nextLine();
        System.out.println("Please Enter Category Number .");
        category.setItemNumber(Main.readerNumbers.nextInt());
        System.out.println("Please Enter Products counts .");
        category.setProductCounts(Main.readerNumbers.nextInt());
        System.out.println("Do you want to add products to the category now? (y, N) .");
        addingProductIfHeWanted(category);

        Store.categories.add(category);
        System.out.println("Category successfully added 😉");
//        System.out.println(Store.categories.toString());
    }






    public void addProduct() {
        System.out.println("<<< Adding New Products >>>\n");
        if(Store.categories.isEmpty()){
            System.out.println("NO Categories, Please Add new Categories then add products !");
            return ;
        }
        System.out.println("Please select the category you want to add products to based on number .");
        this.displayCategories();
        int input = Main.readerNumbers.nextInt() ;
        Category category = Category.getCategoryByNumber(input);
        if(category != null) {
            category.addProduct();
            return ;
        }
        System.out.println("The number you entered is not known! , try again ");



    }





    public void updateCategoryData() {
        if(Store.categories.isEmpty()) {
            System.out.println("No Categories , please add then update !");
            return ;
        }
        System.out.println("<<< Updating Category DATA >>>\n");
        System.out.println("Please select the category you want to Updating DATA to based on number .");
        Category category =this.receivingCategory();
        if(category == null) {
        System.out.println("The number you entered is not known! , try again ");
            return ;
        }
//        Main.readerStrings.nextLine();
        category.updateCategory();
        System.out.println(category);


    }

    public void updateProductData() {
        System.out.println("<<< Updating Product DATA >>>\n");
        System.out.println("Please select the category you want to Updating DATA to based on number .\n");

        Category category = this.receivingCategory() ;
        if(category == null) {
            System.out.println("The number you entered is not known! , try again");
            return  ;
        }
        category.displayProducts();
        System.out.println("Please select the Product you want to Updating DATA to based on number .\n");
        Product product = category.getProductByNumber(Main.readerNumbers.nextInt());
        if(product == null) {
            System.out.println("The number you entered is not known! , try again");
            return ;
        }
//        Main.readerStrings.nextLine();
        product.updateProductData();

        }

//    public void displayAllCategories() {
//        System.out.println("<<< Display All Categories >>>\n");
//        for(Category category : Store.categories)
//            System.out.println(category.toString() + "\n");
//    }

//    public void displayAllProductInCategory() {
//        System.out.println("<<< Display All Product in Category selected >>> \n");
//        Category category = this.receivingCategory() ;
//        if(category == null) {
//            System.out.println("The number you entered is not known! , try again");
//            return;
//        }
//        category.displayAllProducts();
//
//    }

        ////////////////////////////////////////////////////////// HELPER Functions  /////////////////////////////////////////////////////////

    // adding new Products when creating new Category :>
    private  void addingProductIfHeWanted(Category category) {
        String answer = Main.readerStrings.nextLine();
        if(answer.toLowerCase().equals("y")) {
            for (int i = 0; i < category.getProductCounts(); i++)
                category.addProduct();
        }
    }

//    public Category receivingCategory() {
//        this.displayCategories();
//        System.out.println("Please Enter Number / ID Category .");
//        int input = Main.readerNumbers.nextInt() ;
//        return Category.getCategoryByNumber(input);
//
//    }

    public void displayCategories() {
        for(Category category : Store.categories)
            System.out.println(">>Category Name: "+ category.getName() + "  >> Category Number: " + category.getItemNumber());
    }



    // add new Customers :

    public void addCustomers() {
        Customer c = new Customer() ;
        System.out.println("Please Enter  UserName Customer .");
        c.setUserName(Main.readerStrings.nextLine());
        System.out.println("Please Enter Password Customer .");
        c.setPassword(Main.readerStrings.nextLine());
        System.out.println("Please Enter Birthdate Customer .");
        c.setBirthDate(Main.readerStrings.nextLine());
        System.out.println("The Customer has been added successfully:) ");


    }


}
