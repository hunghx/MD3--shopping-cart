package ra.controller.cart;

import ra.config.Config;
import ra.controller.user.UserController;
import ra.model.entity.Cart;
import ra.model.entity.CartItem;
import ra.model.entity.User;
import ra.model.service.cart.CartServiceIMPL;
import ra.model.service.cart.ICartService;

import java.util.List;

import static ra.config.Config.scanner;

public class CartController {

    ICartService cartService = new CartServiceIMPL();
    public List<CartItem> getListCartItems(){
        User user = cartService.getUserLogin();
        Cart myCart = cartService.findById(user.getUserId()) ;
        return myCart.getListCartItem();
    }
    public void addToCart(CartItem cartItem){
        cartService.addToCart(cartItem);
    }
}
