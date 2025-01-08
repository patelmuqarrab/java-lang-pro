import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, h, i, fact = 1, number, originalNumber, remainder, result = 0, ch;
        double volume, pi = 3.14;

        System.out.println("\nMenu\n");
        System.out.println("1. Calculate Volume of Cylinder");
        System.out.println("2. Find the Factorial of a Given Number");
        System.out.println("3. Check if the Number is Armstrong");
        System.out.println("4. Exit");
        System.out.println("\nEnter your Choice: ");
        ch = sc.nextInt();

        switch (ch) {
            case 1:
                System.out.println("Enter radius of the cylinder:");
                r = sc.nextInt();
                System.out.println("Enter height of the cylinder:");
                h = sc.nextInt();
                volume = pi * r * r * h;
                System.out.println("Volume of the cylinder is: " + volume);
                break;

            case 2:
                System.out.println("Enter a number: ");
                number = sc.nextInt();
                for (i = 1; i <= number; i++) {
                    fact *= i;
                }
                System.out.println("Factorial of " + number + " is: " + fact);
                break;

            case 3:
                System.out.println("Enter a number: ");
                number = sc.nextInt();
                originalNumber = number;
                while (originalNumber != 0) {
                    remainder = originalNumber % 10;
                    result += Math.pow(remainder, 3);
                    originalNumber /= 10;
                }
                if (result == number)
                    System.out.println(number + " is an Armstrong number.");
                else
                    System.out.println(number + " is not an Armstrong number.");
                break;

            case 4:
                System.out.println("Exit");
                break;

            default:
                System.out.println("Invalid choice! Please enter a valid option.");
                break;
        }
    }
}
