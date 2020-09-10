package Cifrados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class CesarEncryption {

    private final int UNICODE_LENGTH = 65535;

    public String encryptByCesarWithUnicode(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char letter : text.toCharArray())
            stringBuilder.append((char) (((int) letter) + displacement % UNICODE_LENGTH));

        return stringBuilder.toString();
    }

    public String decryptByCesarWithUnicode(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char letter : text.toCharArray())
            stringBuilder.append((char) (((int) letter) - displacement % UNICODE_LENGTH));

        return stringBuilder.toString();
    }

    public void breakCesarEncryption(String text) {
        String path = System.getProperty("user.dir") + "\\src\\Cifrados\\cesar_break.txt";
        try {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(
                                    new File(path)
                            )
                    )
            );
            StringBuilder stringBuilder = new StringBuilder(text.length());
            int key = 0;
            for (; key < UNICODE_LENGTH; key++) {
                stringBuilder.append(decryptByCesarWithUnicode(text, key))
                        .append("Key: ")
                        .append(key)
                        .append('\n');
                out.write(stringBuilder.toString());
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    private final short ASCII_LENGTH = Byte.MAX_VALUE;

    public String encryptByCesarWithASCII(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();
        short temp;
        for (byte letter : text.getBytes()) {
            temp = (short) (letter + displacement % ASCII_LENGTH);
            stringBuilder.append((char) (byte) (temp > Byte.MAX_VALUE ? (short) (temp - ASCII_LENGTH) : temp));
        }
        return stringBuilder.toString();
    }

    public String decryptByCesarWithASCII(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();
        short temp;
        for (byte letter : text.getBytes()) {
            temp = (short) (letter - displacement % ASCII_LENGTH);
            temp = (short) (temp < 0 ? temp + ASCII_LENGTH : temp);
            stringBuilder.append((char) (byte) temp);
        }
        return stringBuilder.toString();
    }
*/
    private final short ASCII_LENGTH = 255;

    public String encryptByCesarWithASCII(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();
        int temp;
        for (char letter : text.toCharArray()) {
            temp =  ((int) letter + displacement % ASCII_LENGTH);
            temp = temp > ASCII_LENGTH ? (temp - ASCII_LENGTH) : temp;
            if(temp > ASCII_LENGTH || temp < 0)
                return "";
            stringBuilder.append((char) temp);
        }
        return stringBuilder.toString();
    }
    public String decryptByCesarWithASCII(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();
        int temp;
        for (char letter : text.toCharArray()) {
            temp = letter - displacement % ASCII_LENGTH;
            temp = temp < 0 ? temp + ASCII_LENGTH : temp;
            if(temp > ASCII_LENGTH || temp < 0)
                return "";
            stringBuilder.append((char) temp);
        }
        return stringBuilder.toString();
    }

    private final String abc = "abcdefghijklmnñopqrstuvwxyz ";
    private final byte abc_length = (byte) abc.length();

    public String encryptByCesarWithAbc(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();
        short temp;
        byte index;
        for (char letter : text.toCharArray()) {
            index = (byte) abc.indexOf(letter);
            if(index == -1)
                continue;
            temp = (short) (index + displacement % abc_length);
            if (temp >= abc_length)
                temp = (short) (temp - abc_length);
            stringBuilder.append(abc.charAt(temp));
        }
        return stringBuilder.toString();
    }
    public String decryptByCesarWithAbc(String text, int displacement) {
        StringBuilder stringBuilder = new StringBuilder();
        short temp;
        for (char letter : text.toCharArray()) {
            temp = (short) (abc.indexOf(letter) - displacement % abc_length);
            if (temp < 0)
                temp = (short) (temp + abc_length);
            stringBuilder.append(abc.charAt(temp));
        }
        return stringBuilder.toString();
    }

}
