package manager;

import account.Cart;
import account.User;
import iotextfile.IOTextFile;

import java.io.PushbackInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CartManager implements Serializable {
    private final ArrayList<Cart> carts;
    private final IOTextFile<Cart> ioTextFile;
    private final String path = "E:\\Case-study\\CaseStudy2\\src\\textfile\\cart.txt";
    public CartManager(){
        ioTextFile = new IOTextFile<>();
        carts = ioTextFile.readFile(path);
    }
    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public IOTextFile<Cart> getIoTextFile() {
        return ioTextFile;
    }

    public String getPath() {
        return path;
    }
    public Cart getCartByUser (User user){
        for (Cart cart : carts){
            if (cart.getUserCart().getUserName().equals(user.getUserName())){
                return cart;
            }
        }
        return null;
    }
    public void saveCartList(){
        ioTextFile.writeFile(carts, path);
    }
    public void add(Cart item){
        carts.add(item);
        ioTextFile.writeFile(carts, path);
    }
}
