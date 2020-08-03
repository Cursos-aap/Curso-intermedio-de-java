package hilos;

public class Product {

    private final String name;
    private byte stock;
    private final float price;

    public Product(String name, byte quantity, float price) {
        this.name = name;
        this.stock = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public byte getStock() {
        return stock;
    }

    public void reduceStock(byte quantity){
        this.stock -= quantity;
    }

    public float getPrice() {
        return price;
    }
}
