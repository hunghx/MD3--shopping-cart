package ra.model.service.cart;

import ra.model.entity.Cart;
import ra.model.entity.CartItem;
import ra.model.entity.User;
import ra.model.service.IGenericService;

public interface ICartService extends IGenericService<Cart> {

  boolean addToCart (CartItem cartItem);
User getUserLogin();
}
