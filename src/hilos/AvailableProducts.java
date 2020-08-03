package hilos;

import java.util.ArrayList;

public class AvailableProducts {
    protected ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Product product : products){
            stringBuilder.append(product.getName())
                    .append(": $ ")
                    .append(product.getPrice())
                    //.append(" >>>> ")
                    //.append(product.getStock())
                    //.append(" disponibles")
                    .append('\n');
        }
        System.out.println(stringBuilder);
    }

    public void reduceStock(String name, byte quantity){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.reduceStock(quantity);
                break;
            }
        }
    }
}
