package ra.view;

import ra.controller.catalog.CatalogController;
import ra.controller.catalog.ICatalogController;
import ra.model.entity.Catalog;

import java.util.List;

import static ra.config.Config.scanner;

public class CatalogView {
    private static ICatalogController catalogController = new CatalogController();
    private static List<Catalog> catalogList = catalogController.findAll();
    public void showCatalog(){
        for (Catalog c:catalogList) {
            System.out.println(c);
        }
    }
    public void createCatalog(){
        Catalog catalog = new Catalog();
        if (catalogList.size()==0){
            catalog.setId(1);
        }else {
            catalog.setId(catalogList.get(catalogList.size()-1).getId()+1);
        }
        System.out.println("Enter the name: ");
        catalog.setName(scanner.nextLine());
        System.out.println("Enter the status: ");
        catalog.setStatus(Boolean.parseBoolean(scanner.nextLine()));
        catalogController.save(catalog);
    }
    public void updateCatalog(){
        System.out.println("Enter the id to update:");
        int id = Integer.parseInt(scanner.nextLine());
        if (catalogController.findById(id)==null){
            System.err.println("id not found!");
        }else {
            System.out.println("Enter name change to:");
            String nameUp = scanner.nextLine();
            System.out.println("Enter status change to: ");
            boolean status = Boolean.parseBoolean(scanner.nextLine());
            Catalog catalog = new Catalog(id,nameUp,status);
            catalogController.save(catalog);
        }
    }
    public void deleteCatalog(){
        System.out.println("Enter id to delete");
        int id = Integer.parseInt(scanner.nextLine());
        catalogController.delete(id);
    }
    public void searchByName(){
        System.out.println("Enter the search name:");
        String searchName= scanner.nextLine();

        for (Catalog c:catalogController.searchByName(searchName)) {
            System.out.println(c);
        }
    }
    public static void catalogManager(){
        boolean check = true;
        while (check){
            System.out.println("***************CATALOG MANAGEMENT**************");
            System.out.println("1. Show Catalog");
            System.out.println("2. Create Catalog");
            System.out.println("3. Update Catalog");
            System.out.println("4. Delete Catalog");
            System.out.println("5. Search By Name");
            System.out.println("6. exit");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println(" Enter Your Selection: ");
            switch (choice) {
                case 1:
                    new CatalogView().showCatalog();
                    break;
                case 2:
                    new CatalogView().createCatalog();
                    break;
                case 3:
                    new CatalogView().updateCatalog();
                    break;
                case 4:
                    new CatalogView().deleteCatalog();
                    break;
                case 5:
                    new CatalogView().searchByName();
                case 6:
                    check = false;

            }
        }
    }
}
