package hilos;

import java.util.Scanner;

public class Main {

    private static final AvailableProducts availableProducts = new AvailableProducts();

    public static void main(String[] args){

        addProducts();
        openGroceryStore();

        /*
            Solamente podrás elegir una actividad
            Hagan una tienda: Tenis, Natación, Football, Billar.

            Rentar cancha:
                >> Tenis: # pelotas, # jugadores, tiempo
                >> Natación: # personas, tiempo
                >> Football: # pelotas, # jugadores, tiempo
                >> Billar: # mesa, # jugadores, tiempo


                30 min : $20
                60 min : $40
                1h30min : $55
                2h00 : por cada 30 min + $12

        */

    }

    private static void addProducts(){
        availableProducts.addProduct(new Product("Cheetos", (byte) 50, 11F));
        availableProducts.addProduct(new Product("Pingüinos", (byte) 30, 14F));
        availableProducts.addProduct(new Product("Chocorroles", (byte) 20, 14F));
        availableProducts.addProduct(new Product("Sabritas", (byte) 50, 12F));
    }

    private static void openGroceryStore(){
        Scanner scanner = new Scanner(System.in);

        availableProducts.printMenu();

        Customer customer = new Customer();
        customer.setName("Purfuruberto de Jesús");

        String answer;
        byte quantity;

        for (Product product: availableProducts.getProducts()) {
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
                            customer.addProducts(new Product(product.getName(), quantity, product.getPrice()));
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
        customer.buyProducts();
    }

}
