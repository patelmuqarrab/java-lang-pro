/**
 * The {@code MyNumber} class represents a number and provides methods to check
 * various properties of the number such as whether it is negative, positive, zero,
 * odd, or even. The class provides constructors to initialize the number and methods
 * to perform these checks.
 */
public class MyNumber {
    private int x;

    public MyNumber() {
        x = 0;
    }

    public MyNumber(int x) {
        this.x = x;
    }

    public boolean isNegative() {
        return x < 0;
    }

    public boolean isPositive() {
        return x > 0;
    }

    public boolean isZero() {
        return x == 0;
    }

    public boolean isOdd() {
        return x % 2 != 0;
    }

    public boolean isEven() {
        return x % 2 == 0;
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        int x = Integer.parseInt(args[0]);
        MyNumber m = new MyNumber(x);

        if (m.isNegative())
            System.out.println("Number is Negative");
        if (m.isPositive())
            System.out.println("Number is Positive");
        if (m.isEven())
            System.out.println("Number is Even");
        if (m.isOdd())
            System.out.println("Number is Odd");
        if (m.isZero())
            System.out.println("Number is Zero");
    }
}
