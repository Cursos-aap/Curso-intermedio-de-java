package grocery_store;

import java.io.Serializable;

public class Product implements Serializable {

    private final String name;
    private byte stock;
    private final float price;

    public Product(String name, byte stock, float price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public byte getStock() {
        return stock;
    }


    public void reduceStock(byte quantity){
        this.stock -= quantity;
    }
}
