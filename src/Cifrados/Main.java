package Cifrados;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //Try with 8888888 or 84623
        askForCesar();
    }

    private static void askForCesar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la palabra a cifrar");
        String text = scanner.nextLine();

        while (true){
            System.out.print("Ingresa el desplazamiento de César: ");
            if(scanner.hasNextInt())
                break;
            scanner.nextLine();
        }
        int displacement = scanner.nextInt();
        System.out.println("----------- Cesar encryption -----------");
        System.out.println("--------------- With Abc ---------------");
        encryptWithAbc(text, displacement);
        System.out.println("----------- Cesar encryption -----------");
        System.out.println("-------------- With ASCII --------------");
        encryptWithASCII(text, displacement);
        System.out.println("----------- Cesar encryption -----------");
        System.out.println("------------- With Unicode -------------");
        encryptWithUnicode(text, displacement);
    }

    private static void encryptWithUnicode(String text, int displacement){
        CesarEncryption cesarEncryption = new CesarEncryption();

        String encrypted = cesarEncryption.encryptByCesarWithUnicode(text, displacement);
        String decrypted = cesarEncryption.decryptByCesarWithUnicode(encrypted, displacement);
        System.out.println("Texto cifrado: " + encrypted + '\n' + "Texto descifrado: " + decrypted + "\n");

        //cesarEncryption.breakCesarEncryption(encrypted);
    }

    private static void encryptWithASCII(String text, int displacement){
        CesarEncryption cesarEncryption = new CesarEncryption();

        String encrypted = cesarEncryption.encryptByCesarWithASCII(text, displacement);
        String decrypted = cesarEncryption.decryptByCesarWithASCII(encrypted, displacement);
        System.out.println("Texto cifrado: " + encrypted + '\n' + "Texto descifrado: " + decrypted + "\n");

        //cesarEncryption.breakCesarEncryption(encrypted);
    }

    private static void encryptWithAbc(String text, int displacement){
        CesarEncryption cesarEncryption = new CesarEncryption();

        String encrypted = cesarEncryption.encryptByCesarWithAbc(text, displacement);
        String decrypted = cesarEncryption.decryptByCesarWithAbc(encrypted, displacement);
        System.out.println("Texto cifrado: " + encrypted + '\n' + "Texto descifrado: " + decrypted + "\n");

        //cesarEncryption.breakCesarEncryption(encrypted);
    }

}
