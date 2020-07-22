package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercises {

    public static void isOddOrEven(){

        //  5.0
        //  2.5 - round(2.5)
        //  2.5 - 2.0  = 0.5
        //  2.5 - 3.0  = -0.5

        Scanner scanner = new Scanner(System.in);
        double number;

        do {
            System.out.print("Ingresa un número: ");
            if(scanner.hasNextDouble()){
                number = scanner.nextDouble();
                break;
            }else
                scanner.nextLine();

        } while( true );

        double division = number / 2;
        double round_down = Math.floor(division);

        if(division - round_down == 0)
            System.out.print(number + " es par");
        else
            System.out.println(number + " es impar");


    }

    public static int linearSearch(int[] arr, int element){
        for (int i = 0; i < arr.length; i++)
            if(arr[i] == element)
                return i;
        return -1;
    }

    public static double sumElementsInArray(double[] arr){
        double sum = 0;
        for(double temp : arr)
            sum += temp;

        return sum;
    }

    public static double[] sumTwoVectors(double[] vector_a, double[] vector_b){
        double[] vector_c = new double[vector_a.length];

        if(vector_a.length != vector_b.length)
            return new double[] { Double.NaN };

        for (int i = 0; i < vector_a.length; i++)
            vector_c[i] = vector_a[i] + vector_b[i];

        return vector_c;
    }

    public static double[] sumNVectors(double[]... vectors){

        if(vectors == null)
            return new double[] { Double.NaN };
        
        if(vectors.length < 1)
            return new double[] { Double.NaN };
        
        for (int i = 0; i < vectors.length -1; i++)
            if(vectors[i].length != vectors[i + 1].length )
                return new double[] { Double.NaN };

        double[] vector_r = new double[vectors[0].length];

        for (double[] vector : vectors) 
            for (int j = 0; j < vector.length; j++)
                vector_r[j] += vector[j];
            
        return vector_r;
    }

    public static void sumMatrix(double[][] matrix_1, double[][] matrix_2){

        if(matrix_1.length != matrix_2.length){
            System.out.println("Las matrices no coinciden en # filas");
            return;
        }

        short columns = (short) matrix_1[0].length;

        for (int i = 0; i < matrix_2.length; i++) {
            if(matrix_1[i].length != matrix_2[i].length || matrix_2[i].length != columns ){
                System.out.println("Las matrices no coinciden en # columnas");
                return;
            }
        }

        double[][] matrix_r = new double[matrix_1.length][matrix_1[0].length];

        for (int i = 0; i < matrix_2.length; i++)
            for (int j = 0; j < matrix_1[0].length; j++)
                matrix_r[i][j] = matrix_2[i][j] + matrix_1[i][j];

        System.out.println(Arrays.deepToString(matrix_r));
    }

    public static long sumWithGauss(final int n, final int m){
        //     condición   +   ? instrucciones en caso verdadero +      : instrucciones en caso falso
        return n >= 0 && m > n ? ( ((long) m + 1) * m - (n - 1) * n) /2 : 0;
        // m > 0
        // m > n >= 0
    }

    public static void printTriangle(byte height){
        StringBuilder str_builder = new StringBuilder();
        for (byte i = 0; i < height; i++) {
            str_builder.append(" ".repeat(height - i - 1));
            str_builder.append("*".repeat(i * 2 + 1));
            str_builder.append('\n');
        }
        System.out.println(str_builder);
    }
    
    public static void printTriangle2(byte height){
        StringBuilder str_builder = new StringBuilder();
        for (byte i = 0; i < height; i++) {
            for (int j = 0; j < height -i -1; j++)
                str_builder.append(' ');
            for (int j = 0; j < i * 2 +1; j++)
                str_builder.append('*');
            str_builder.append('\n');
        }
        System.out.println(str_builder);
    }

}
