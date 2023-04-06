package ra.view;

import ra.controller.catalog.CatalogController;
import ra.controller.product.ProductController;
import ra.model.entity.Catalog;
import ra.model.entity.Product;

import java.util.List;

import static ra.config.Config.scanner;

public class ProductView {
    private static ProductController productController = new ProductController();
    List<Product> productList = productController.findAll();
    public void ShowProduct(){
        for (Product product:productList) {
            System.out.println(product);
        }
    }
    public void createProduct(){
        Product product = new Product();
        if (productList.size()==0){
            product.setProductId(1);
        }else {
            product.setProductId(productList.get(productList.size()-1).getProductId()+1);
        }
        Catalog catalog = null;
        List<Catalog> catalogList = new CatalogController().findAll();
        for (Catalog c:catalogList) {
            System.out.println(c);
        }
        System.out.println("Enter the catalog by id :");
        int idC = Integer.parseInt(scanner.nextLine());
        for (Catalog c:catalogList) {
            if (c.getId()==idC){
                catalog = c;
            }
        }
        product.setProductCatalog(catalog);
        System.out.println("Enter the name:");
        product.setProductName(scanner.nextLine());
        System.out.println("Enter the price:");
        product.setProductPrice(Float.parseFloat(scanner.nextLine()));
        System.out.println("Enter the status:");
        product.setProductStatus(Boolean.parseBoolean(scanner.nextLine()));
        productController.save(product);
    }
    public void deleteProduct(){
        System.out.println("Enter the id to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        productController.delete(id);
    }
    public void updateProduct(){
        System.out.println("Enter the id to update:");
        int idUpdate = Integer.parseInt(scanner.nextLine());
        if (productController.findById(idUpdate)==null){
            System.err.println(" Id not found !");
        }else {

            System.out.println("Enter the name to change:");
            String nameUpdate = scanner.nextLine();
            Catalog catalogUpdate = null;
            List<Catalog> catalogList = new CatalogController().findAll();
            for (Catalog c:catalogList) {
                System.out.println(c);
            }
            System.out.println("Enter the catalog to change by id :");
            int idC = Integer.parseInt(scanner.nextLine());
            for (Catalog c:catalogList) {
                if (c.getId()==idC){
                    catalogUpdate = c;
                }
            }
            System.out.println("Enter the price to change");
            Float priceUpdate = Float.parseFloat(scanner.nextLine());
            System.out.println("Enter the status to change:");
            Boolean statusUpdate = Boolean.parseBoolean(scanner.nextLine());
            Product productUpdate = new Product(idUpdate,catalogUpdate,nameUpdate,priceUpdate,statusUpdate);
            productController.save(productUpdate);
        }
    }
    public void searchByName(){
        System.out.println("Enter the search Name:");
        String searchName= scanner.nextLine();
        for (Product p:productController.searchByName(searchName)) {
            System.out.println(p);
        }
    }
    public static void ProductManagement(){
        boolean check = true;
        while (check) {
            System.out.println("*************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Show Product");
            System.out.println("2. Create Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search By Name");
            System.out.println("6. exit");
            int c = Integer.parseInt(scanner.nextLine());
            switch (c){
                case 1:
                    new ProductView().ShowProduct();
                    break;
                case 2:
                    new ProductView().createProduct();
                    break;
                case 3:
                    new ProductView().updateProduct();
                    break;
                case 4:
                    new ProductView().deleteProduct();
                    break;
                case 5:
                    new ProductView().searchByName();
                    break;
                case 6:
                    check = false;
                    break;

            }
        }
    }
}
