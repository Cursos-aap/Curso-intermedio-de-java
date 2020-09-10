package grocery_store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final AvailableProducts availableProducts = new AvailableProducts();

    public static void main(String[] args){
        //addProducts();
        openGroceryStore();
    }

    private static void openGroceryStore(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> menu = availableProducts.getProducts();

        if(menu == null || menu.size() < 1){
            System.out.println("Ha ocurrido un error");
            return;
        }

        HashMap<Product, Byte> ticket = new HashMap<>();

        availableProducts.printMenu();

        Customer customer = new Customer("María de Jesús");

        String answer;
        byte quantity;

        for (Product product: menu) {
            System.out.println("¿Quieres comprar " + product.getName() + "? (y/n)");
            answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("y")){
                while (true) {
                    System.out.println("¿Cuántos quieres comprar?");
                    if(scanner.hasNextByte()) {
                        quantity = scanner.nextByte();

                        if (quantity > product.getStock())
                            System.out.println("Lo sentimos, nada más tenemos " + product.getStock() +
                                    " " + product.getName() + " disponibles");
                        else if(quantity > 0) {
                            ticket.put(new Product(product.getName(), product.getPrice()), quantity);
                            scanner.nextLine();
                            availableProducts.reduceStock(product.getName(), quantity);
                            break;
                        }
                        else
                            System.out.println("Cantidad inválida");
                    }
                    scanner.nextLine();
                }
            }
        }
        if(availableProducts.updateProduct())
            customer.buyProducts(ticket);
        else
            System.out.println("Lo sentimos, no pudimos procesar su compra");
    }

    private static void addProducts(){
        availableProducts.addProduct(new Product("Cheetos", (byte) 50, 11F));
        availableProducts.addProduct(new Product("Pingüinos", (byte) 30, 14F));
        availableProducts.addProduct(new Product("Chocorroles", (byte) 20, 14F));
        availableProducts.addProduct(new Product("Sabritas", (byte) 50, 12F));
    }

}
