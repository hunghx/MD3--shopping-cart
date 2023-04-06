package ra.view;

import ra.config.Config;
import ra.controller.cart.CartController;
import ra.controller.product.ProductController;
import ra.model.entity.CartItem;
import ra.model.entity.Product;

import java.util.List;

import static ra.config.Config.scanner;

public class CartView {
    CartController cartController = new CartController();
    ProductController productController= new ProductController();
    public  void showCart() {
        List<CartItem> listCartItems = cartController.getListCartItems();
        System.out.println("Show list cart");
        float total = 0;
        for (CartItem cartitem : listCartItems) {
            total+= cartitem.getProduct().getProductPrice()*cartitem.getQuantity();
            System.out.printf("{product: %s , quantity : %d} \n",cartitem.getProduct(),cartitem.getQuantity());
        }
        System.out.println("Total : " +total);

    }
    public  void  addCartItem(){
        System.out.println("Enter product id");
        Product product = productController.findById(Integer.parseInt(scanner.nextLine()));
        if (product == null) {
            System.err.println("Id not found");
            addCartItem();
        }else {
            System.out.println("Enter quantity");
            int quantity =Integer.parseInt(scanner.nextLine()) ;
            CartItem  newCartItem = new CartItem(product,quantity);
            cartController.addToCart(newCartItem);
            System.out.println("add to cart success");
        }
    }
}
