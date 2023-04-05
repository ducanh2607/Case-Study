package product;

import java.io.Serializable;

public class Alcohol implements Serializable {
    public static Long INDEX = Long.valueOf(0);
    private String name;
    private double price;
    private Long id;
    private int volume;
    private String brand;
    private int quantity;

    public Alcohol() {
    }

    public Alcohol(String name, String brand, double price, int volume, int quantity) {
        this.id = Long.valueOf(++INDEX);
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.brand = brand;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }


    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", volume=" + volume +
                ", brand='" + brand + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
