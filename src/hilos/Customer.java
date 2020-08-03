package hilos;

import java.util.ArrayList;

public class Customer {

    // :P Para qué no se conectan ><

    private String name;

    // Name, Quantity, Price
    private ArrayList<Product> products = new ArrayList<>();

    protected String getName(){
        return this.name;
    }

    protected void setName(final String name){
        this.name = name;
    }

    protected void addProducts(Product product){
        this.products.add(product);
    }

    protected void buyProducts(){
        double subtotal, total = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (Product product: products) {
            subtotal = product.getPrice() * product.getStock();
            total += subtotal;
            stringBuilder.append("Compramos ")
                    .append(product.getStock())
                    .append(' ')
                    .append(product.getName())
                    .append(", subtotal: $")
                    .append(subtotal)
                    .append('\n');
        }
        stringBuilder.append("Total : $")
                .append(total);

        System.out.println(stringBuilder);

    }

}
