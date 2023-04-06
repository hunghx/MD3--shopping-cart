package ra.view;

import java.sql.SQLOutput;

import static ra.config.Config.scanner;

public class Main {

    public static void generalShop() {
        while (true) {
            System.out.println("*******************WELCOME TO SHOP******************");
            System.out.println("1. Show Product");
            System.out.println("2. Register");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            int choiceMenu = Integer.parseInt(scanner.nextLine());
            switch (choiceMenu) {
                case 1:
                    new ProductView().ShowProduct();
                    break;
                case 2:
                    new UserView().register();
                    break;
                case 3:
                    new UserView().formLogin();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
                case 5:
                    new UserView().showListUser();
                    break;
            }
        }

    }

    public static void generalManager() {
        boolean check = true;
        while (check) {
            System.out.println("**************GENERAL MANAGEMENT*************** \n");
            System.out.println("1. Product Management");
            System.out.println("2. Catalog Management");
            System.out.println("3. User Management");
            System.out.println("4. Cart Management");
            System.out.println("5. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    ProductView.ProductManagement();
                    break;
                case 2:
                    CatalogView.catalogManager();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    new UserView().logOut();
                    check = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Main.generalShop();
    }

    public void viewUser() {
        boolean check = true;
        while (check) {
            System.out.println("*******************WELCOME TO SHOP******************");
            System.out.println("1. Show Product");
            System.out.println("2. Add To Cart");
            System.out.println("3. Show your Cart");
            System.out.println("4. Update user");
            System.out.println("5. LogOut");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    new ProductView().ShowProduct();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    new UserView().updateUser();
                    break;
                case 5:
                    System.out.println("------Goodbye See you again !---------");
                    new UserView().logOut();
                    check = false;
                default:
                    break;

            }
        }
    }
}