public class Services {

    public void displayAllCategories() {
        System.out.println("<<< Display All Categories >>>\n");
        for(Category category : Store.categories)
            System.out.println(category.toString() + "\n");
    }

    public void displayAllProductInCategory() {
        System.out.println("<<< Display All Product in Category selected >>> \n");
        Category category = this.receivingCategory() ;
        if(category == null) {
            System.out.println("The number you entered is not known! , try again");
            return;
        }
        category.displayAllProducts();

    }

    public Category receivingCategory() {
        this.displayCategories();
        System.out.println("Please Enter Number / ID Category .");
        int input = Main.readerNumbers.nextInt() ;
        return Category.getCategoryByNumber(input);

    }

    public void displayCategories() {
        for(Category category : Store.categories)
            System.out.println(">>Category Name: "+ category.getName() + "  >> Category Number: " + category.getItemNumber());
    }

}
