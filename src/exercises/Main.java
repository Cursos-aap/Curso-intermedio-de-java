package exercises;

import java.util.Arrays;

public class Main {

    public static void main(String[] another_name_that_is_not_args) {

        String output = Arrays.deepToString(
                sumTwoMatrix(
                    new double[][] {{16, 22, 13}, {15, 82, 131}, {14, 7, 4}, {52, 2, 167}, {17, 22, 3000}},
                    new double[][] {{42, 5, 6}, {40, 55, 67}, {4, 45, 6}, {96, 48, 6}, {24, 15, 6}}
                )
        );
        System.out.println(output);
        System.out.println(Arrays.deepToString(sumNMatrix(
                new double[][] {{16, 22, 13}, {15, 82, 131}, {14, 7, 4}, {52, 2, 167}, {17, 22, 3000}},
                new double[][] {{42, 5, 6}, {40, 55, 67}, {4, 45, 6}, {96, 48, 6}, {24, 15, 6}}
        )));

    }

    public static double[][] sumNMatrix(double[][]... matrix_array){
        if(matrix_array.length < 1)
            return new double[][] {{Double.NaN}};

        // Reference size
        byte[] matrix_size = { (byte) matrix_array[0].length, (byte) matrix_array[0][0].length };
        double[][] matrix_r = new double[matrix_size[0]][matrix_size[1]];

        for (double[][] matrix : matrix_array) {
            // Rows length don't match
            if (matrix.length != matrix_size[0])
                return new double[][]{{Double.NaN}};

            for (int j = 0; j < matrix.length; j++) {
                //El tamaño en columnas no coincide
                if (matrix[j].length != matrix_size[1])
                    return new double[][]{{Double.NaN}};

                for (int k = 0; k < matrix_size[1]; k++)
                    matrix_r[j][k] += matrix[j][k];
            }
        }
        return matrix_r;
    }

    public static double[][] sumTwoMatrix(double[][] matrix_1, double[][] matrix_2){
        if(matrix_1 == null || matrix_2 == null)
            return new double[][] { { Double.NaN } };

        if(matrix_1.length != matrix_2.length)
            return new double[][] { { Double.NaN } };

        if(matrix_1.length < 1)
            return new double[][] { { Double.NaN } };

        byte columns_reference = (byte) matrix_1[0].length;
        double[][] matrix_r = new double[matrix_1.length][columns_reference];

        for (int i = 0; i < matrix_1.length; i++) {
            if(matrix_1[i].length != columns_reference)
                return new double[][] { { Double.NaN } };
            if(matrix_2[i].length != columns_reference)
                return new double[][] { { Double.NaN } };

            for (int j = 0; j < columns_reference; j++)
                matrix_r[i][j] = matrix_1[i][j] + matrix_2[i][j];
        }

        return matrix_r;

    }

    /*
        matrix_2
        [
                 [ 3, 5, 7 ],    // 3
                 [ 1, 2, 6 ],    // 3
                 [ 1, 2, 6 ],    // 3
                 [ 1, 2, 3],    // 2
                 [ 1, 2, 6 ],    // 3
                 [ 1, 2, 6 ],    // 3
                 [ 3, 9, 12.2]   // 3
        ]
        matrix_1.length = 7;
     */

    public static double[] sumTwoVectors(double[] vector_1, double[] vector_2){

        if(vector_1 == null || vector_2 == null)
            return new double[] { Double.NaN };

        if (vector_1.length != vector_2.length)
            return new double[] { Double.NaN };

        double[] vector_r = new double[vector_2.length];

        for (int i = 0; i < vector_1.length; i++)
            vector_r[i] = vector_1[i] + vector_2[i];

        return vector_r;
    }

    public static double[] sumNVectors(double[]... vectors){
        /*
             [
                 < 3, 5, 7 >,    // 3
                 < 1, 2, 6 >,    // 3
                 < 3, 9, 12.2 >  // 3
             ]
         */

        if(vectors == null)
            return new double[] { Double.NaN };

        if (vectors.length < 1)
            return new double[] { Double.NaN };


        byte vector_dimension = (byte) vectors[0].length; // 5

        double[] vector_r = new double[vector_dimension];

        for (double[] vector: vectors) {
            if (vector.length != vector_dimension) {
                System.out.println("Los vectores no coinciden en longitud");
                return new double[]{ Double.NaN };
            }

            for (int i = 0; i < vector.length; i++)
                vector_r[i] += vector[i];
        }

        return vector_r;
    }

}
