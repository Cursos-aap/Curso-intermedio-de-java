package StartWithJavaGUI;

public class Main {

    public static void main(String[] args){
        System.out.println(duplicate(10));
    }

    public static int duplicate(int number){
        if(number < 0)
            return -1;
        if(number > Integer.MAX_VALUE / 2)
            return number;
        return (number << 0x01);
    }
    /*
        00000101
        00001010
     */

}
