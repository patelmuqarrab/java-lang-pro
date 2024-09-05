import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int l, b, perimeter, area;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Length of rectangle:");
        l = sc.nextInt();

        System.out.println("Enter Breadth of rectangle:");
        b = sc.nextInt();

        perimeter = 2 * (l + b);
        System.out.println("Perimeter of rectangle is: " + perimeter);

        area = l * b;
        System.out.println("Area of rectangle is: " + area);
    }
}
