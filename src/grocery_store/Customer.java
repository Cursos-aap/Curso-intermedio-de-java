package grocery_store;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer implements Serializable {

    // :P Para qué no se conectan ><

    private String name;
    private HashMap<Product, Byte> ticket;

    public Customer(String name){
        this.name = name;
    }
    public Customer(String name, HashMap<Product, Byte> ticket){
        this.name = name;
        this.ticket = ticket;
    }

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

    protected void buyProducts(HashMap<Product, Byte> ticket){
        double subtotal, total = 0;
        this.ticket = ticket;

        StringBuilder stringBuilder = new StringBuilder();

        for(Product product : ticket.keySet()){
            subtotal = product.getPrice() * ticket.get(product);
            total += subtotal;
            stringBuilder.append("Compramos ")
                    .append(product.getStock())
                    .append(' ')
                    .append(product.getName())
                    .append(", subtotal: $")
                    .append(subtotal)
                    .append('\n');
        }

        /* ticket.forEach((product, quantity) -> {

        }); */

        stringBuilder.append("Total : $").append(total);

        System.out.println(stringBuilder);

        SerializeData serializeData = new SerializeData();
        try {
            serializeData.addTickets(this);
        }catch (IOException e){
            System.out.println("No se pudo guardar su ticket");
            e.printStackTrace();
        }

    }

    public class SerializeData {

        private String path = "./tickets.txt";

        public void addTickets(Customer customer) throws IOException {
            File file = new File(path);

            if(!file.exists())
                file.createNewFile();


            try(ObjectOutputStream objectOutputStream =  new ObjectOutputStream(
                    new FileOutputStream(file,true))) {

                objectOutputStream.writeObject(customer);
            }
        }

    }

}