package exercises;

import java.util.Arrays;

public class Main {

    public static void main(String[] another_name_that_is_not_args) {

        double[][] matrix_1 = {{6, 22, 13}, {15, 82,23}, {1, 2, 12}, {52, 2, 167}, {17, 2, 3000}};

        double[][] matrix_2 = {{4, 5, 6}, {40, 55, 14}, {4, 45, 6}, {96, 48, 6}, {24, 15.2, 6}};

        double[][] matrix_n = {{4, 5, 6}, {40, 55, 14}, {4, 45, 6}, {96, 48, 6}, {24, 15.2, 6}};

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


}
