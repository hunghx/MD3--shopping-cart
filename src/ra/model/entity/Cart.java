package ra.model.entity;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private  User user;
    private List<CartItem> listCartItem;

    public Cart() {
    }

    public Cart(User user, List<CartItem> listCartItem) {
        this.user = user;
        this.listCartItem = listCartItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getListCartItem() {
        return listCartItem;
    }

    public void setListCartItem(List<CartItem> listCartItem) {
        this.listCartItem = listCartItem;
    }
}
