import java.util.Arrays;
import java.util.Scanner;

/**
 * A class to perform matrix operations such as addition, subtraction, multiplication, and transpose.
 */
public class Matrix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] a = {{5, 6, 7}, {8, 9, 10}, {3, 1, 2}};
        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] c;

        System.out.println("Matrix A: " + Arrays.deepToString(a));
        System.out.println("Matrix B: " + Arrays.deepToString(b));

        int choice;
        do {
            System.out.println("\nChoose the matrix operation:");
            System.out.println("--------------------------------");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose");
            System.out.println("5. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    c = add(a, b);
                    System.out.println("Sum of matrices:");
                    System.out.println(Arrays.deepToString(c));
                    break;

                case 2:
                    c = subtract(a, b);
                    System.out.println("Subtraction of matrices:");
                    System.out.println(Arrays.deepToString(c));
                    break;

                case 3:
                    c = multiply(a, b);
                    System.out.println("Multiplication of matrices:");
                    System.out.println(Arrays.deepToString(c));
                    break;

                case 4:
                    System.out.println("Transpose of the first matrix:");
                    c = transpose(a);
                    System.out.println(Arrays.deepToString(c));

                    System.out.println("Transpose of the second matrix:");
                    c = transpose(b);
                    System.out.println(Arrays.deepToString(c));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid input. Please enter a valid choice.");
            }
        } while (true);
    }

    /**
     * Adds two matrices.
     * 
     * @param a First matrix
     * @param b Second matrix
     * @return Sum of the two matrices
     */
    public static int[][] add(int[][] a, int[][] b) {
        int row = a.length;
        int column = a[0].length;
        int[][] sum = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    /**
     * Subtracts the second matrix from the first matrix.
     * 
     * @param a First matrix
     * @param b Second matrix
     * @return Difference of the two matrices
     */
    public static int[][] subtract(int[][] a, int[][] b) {
        int row = a.length;
        int column = a[0].length;
        int[][] sub = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sub[i][j] = a[i][j] - b[i][j];
            }
        }
        return sub;
    }

    /**
     * Multiplies two matrices.
     * 
     * @param a First matrix
     * @param b Second matrix
     * @return Product of the two matrices
     */
    public static int[][] multiply(int[][] a, int[][] b) {
        int row = a.length;
        int column = b[0].length;
        int[][] product = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                product[i][j] = 0;
                for (int k = 0; k < a[0].length; k++) {
                    product[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return product;
    }

    /**
     * Computes the transpose of a matrix.
     * 
     * @param a Matrix to be transposed
     * @return Transposed matrix
     */
    public static int[][] transpose(int[][] a) {
        int row = a.length;
        int column = a[0].length;
        int[][] temp = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                temp[j][i] = a[i][j];
            }
        }
        return temp;
    }
}
