package grocery_store;

import java.io.*;
import java.util.ArrayList;

public class AvailableProducts {

    protected ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        SerializeData serializeData = new SerializeData();

        try {
            products = serializeData.readProducts();
            return products;
        }catch (IOException e){
            System.out.println("No se pudieron leer los productos");
            e.printStackTrace();
        }
        return null;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void serializeProducts(){
        SerializeData serializeData = new SerializeData();
        try{
            serializeData.addProducts(this.products);
        }catch(IOException e){
            System.out.println("No se pudieron guardar los datos");
            e.printStackTrace();
        }
    }

    public void printMenu(){
        StringBuilder stringBuilder = new StringBuilder();

        for(Product product : products){
            stringBuilder.append(product.getName())
                    .append(": $ ")
                    .append(product.getPrice())
                    .append(" >>>> ")
                    .append(product.getStock())
                    .append(" disponibles")
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

    public boolean updateProduct(){
        SerializeData serializeData = new SerializeData();
        try {
            serializeData.updateProduct(this.products);
            return true;
        }catch (IOException e){
            System.out.println("No se pudieron actualizar los productos");
            return false;
        }
    }


    public class SerializeData {

        private String path = "./products.txt";

        public void addProducts(ArrayList<Product> menu) throws IOException {
            File file = new File(path);

            if(!file.exists()) {
                file.createNewFile();

                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream(file, true))) {

                    for (Product product : menu)
                        objectOutputStream.writeObject(product);
                }
                return;
            }

            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(file, true)){

            }) {
                

                for (Product product : menu)
                    objectOutputStream.writeObject(product);
            }

        }

        public void writeProducts(ArrayList<Product> menu) throws IOException {
            File file = new File(path);

            if(!file.exists())
                file.createNewFile();

            try(ObjectOutputStream objectOutputStream =  new ObjectOutputStream(
                    new FileOutputStream(file, false))) {

                for(Product product : menu)
                    objectOutputStream.writeObject(product);
            }
        }

        public ArrayList<Product> readProducts() throws IOException{

            ArrayList<Product> menu = new ArrayList<>();

            File file = new File(path);

            if(!file.exists())
                return null;

            try(ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(file))){
                while (true)
                    try {
                        menu.add((Product) objectInputStream.readObject());
                    }catch (Exception e){
                        break;
                    }
            }

            return menu;
        }

        public void updateProduct(ArrayList<Product> products_to_update) throws IOException {

            ArrayList<Product> menu = readProducts();

            int i = -1;

            for(Product product : products_to_update)
                while (i < menu.size())
                    if(menu.get(++i).getName().equals(product.getName())) {
                        menu.set(i, product);
                        break;
                    }

            writeProducts(menu);

        }

    }

}
