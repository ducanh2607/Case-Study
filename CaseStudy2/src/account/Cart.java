package account;

import java.io.Serializable;
import java.util.*;

import iotextfile.IOTextFile;
import iotextfile.IOTextFiles;
import product.Alcohol;
import manager.ProductManager;

public class Cart implements Serializable {
    private User userCart;
    private Map<Alcohol, Integer> cart;
    private Map<Alcohol, Integer> bill;

    private IOTextFile<Alcohol> ioTextFile;
    private IOTextFiles<Alcohol,Integer> ioTextFiles;
    public Cart() {

    }
    public Cart(User user){
        userCart = user;
        cart = new HashMap<>();
        bill = new HashMap<>();
        ioTextFile = new IOTextFile<>();
        ioTextFiles = new IOTextFiles<>();
    }

    public User getUserCart() {
        return userCart;
    }

    public void setUserCart(User userCart) {
        this.userCart = userCart;
    }

    public Map<Alcohol, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Alcohol, Integer> cart) {
        this.cart = cart;
    }

    public Map<Alcohol, Integer> getBill() {
        return bill;
    }

    public void setBill(Map<Alcohol, Integer> bill) {
        this.bill = bill;
    }

    public void addToCart(Alcohol alcohol, int quantity) {
        int value = 0;
        Set<Alcohol> keys = cart.keySet();
        for (Alcohol key : keys) {
            if (key.getName().equals(alcohol.getName())) {
                value = cart.get(key);
            }
        }
        if (value == 0) {
            cart.put(alcohol, quantity);
            ioTextFiles.writeFile((HashMap<Alcohol, Integer>) cart, "D:\\Case study\\CaseStudy2\\src\\textfile\\cart.txt");
        } else {
            cart.put(alcohol, Math.min(value + quantity, alcohol.getQuantity()));
            ioTextFiles.writeFile((HashMap<Alcohol, Integer>) cart, "D:\\Case study\\CaseStudy2\\src\\textfile\\cart.txt");
        }
    }
    public String checkOut(ProductManager productManager){
        String str = "";
        bill = new HashMap<>(cart);
        cart.clear();

        for(Map.Entry<Alcohol,Integer> entry : bill.entrySet()){
            System.out.println("Name product: " + entry.getKey().getName() + ", quantity: " + entry.getValue() + ", price: " + entry.getKey().getPrice()*entry.getValue()+"\n");
            str = "Name product: " + entry.getKey().getName() + ", quantity: " + entry.getValue() + ", price: " + entry.getKey().getPrice()*entry.getValue()+"\n";
        }
        Set<Alcohol> alcoholSet = bill.keySet();
        ArrayList<Alcohol> arr = productManager.getAlcohols();
        for (Alcohol al : alcoholSet){
            if (al.getQuantity() >= bill.get(al)){
                for (Alcohol alcohol : arr) {
                    if (alcohol.getId() == al.getId()) {
                        int newAmount = al.getQuantity() - bill.get(al);
                        alcohol.setQuantity(newAmount);
                    }
                }
            }
        }
        ioTextFile.writeFile(arr, "D:\\Case study\\CaseStudy2\\src\\textfile\\product.txt");
        productManager.setAlcohols(arr);
        return str;
    }
}
