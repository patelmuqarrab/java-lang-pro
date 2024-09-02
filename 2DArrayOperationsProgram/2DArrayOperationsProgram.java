import java.util.Scanner;

public class SetCc {
    public static void main(String[] args) {
        int i, j, r, c, ch;
        int sumDiagonal = 0, sumUpperDiagonal = 0, sumLowerDiagonal = 0;
        int[][] a = new int[10][10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        r = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        c = sc.nextInt();

        System.out.println("Enter the elements of the Array: ");
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Array:");
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nMenu");
        System.out.println("1. Sum of diagonal elements");
        System.out.println("2. Sum of upper diagonal elements");
        System.out.println("3. Sum of lower diagonal elements");
        System.out.println("4. Exit");

        do {
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    sumDiagonal = 0;
                    for (i = 0; i < r; i++) {
                        for (j = 0; j < c; j++) {
                            if (i == j) {
                                sumDiagonal += a[i][j];
                            }
                        }
                    }
                    System.out.println("Sum of diagonal elements: " + sumDiagonal);
                    break;

                case 2:
                    sumUpperDiagonal = 0;
                    for (i = 0; i < r; i++) {
                        for (j = 0; j < c; j++) {
                            if (i < j) {
                                sumUpperDiagonal += a[i][j];
                            }
                        }
                    }
                    System.out.println("Sum of upper diagonal elements: " + sumUpperDiagonal);
                    break;

                case 3:
                    sumLowerDiagonal = 0;
                    for (i = 0; i < r; i++) {
                        for (j = 0; j < c; j++) {
                            if (i > j) {
                                sumLowerDiagonal += a[i][j];
                            }
                        }
                    }
                    System.out.println("Sum of lower diagonal elements: " + sumLowerDiagonal);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        } while (ch != 4);
    }
}
