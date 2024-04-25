import java.util.Locale;

public class MerchantServices {
//    Merchant merchant ;
//
//    MerchantServices(Merchant merchant) {
//        this.merchant = merchant ;
//    }


    public void mainMenu() {
        int action ;
        do {
        System.out.println("Merchant main menu :) ");
        System.out.println("1. Add New Category ");
        System.out.println("2. Add New Product ");
        System.out.println("3. Update Category data");
         action = Main.readerNumbers.nextInt() ;
     switch (action) {
         case 1 : addCategories();
         break ;

         case 2: addProduct();
         break;

         case 3 : updateCategoryData();
         break;

     }


        }while(action != 7);




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


    // adding new Products when creating new Category :>
    private  void addingProductIfHeWanted(Category category) {
        String answer = Main.readerStrings.nextLine();
        if(answer.toLowerCase().equals("y")) {
            for (int i = 0; i < category.getProductCounts(); i++)
                category.addProduct();
        }
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


    public void receivingCategory() {
        int input = Main.readerNumbers.nextInt() ;
        Category category = Category.getCategoryByNumber(input);
        if(category != null) {
            category.addProduct();
            return ;
        }
        System.out.println("The number you entered is not known! , try again ");

    }

    public void displayCategories() {
        for(Category category : Store.categories)
            System.out.println(">>Category Name: "+ category.getName() + "  >> Category Number: " + category.getItemNumber());
    }


    public void updateCategoryData() {
        if(Store.categories.isEmpty()) {
            System.out.println("No Categories , please add then update !");
            return ;
        }
        System.out.println("<<< Updating Category DATA >>>\n");
        System.out.println("Please select the category you want to add products to based on number .");
        this.displayCategories();
        int input = Main.readerNumbers.nextInt() ;
        Category category = Category.getCategoryByNumber(input);
        if(category == null) {
        System.out.println("The number you entered is not known! , try again ");
            return ;
        }
        Main.readerStrings.nextLine();
        System.out.println("Please Enter the New Name Category .");
        category.setName(Main.readerStrings.nextLine());
        System.out.println("Please Enter the New Description Category .");
        category.setDescription(Main.readerStrings.nextLine());
        System.out.println("Please Enter the New ID / Number Category .");
        category.setItemNumber(Main.readerNumbers.nextInt());

        System.out.println("The operation was completed successfully :) ");
        System.out.println(category);


    }

}
