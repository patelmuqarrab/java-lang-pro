import java.util.*;
import java.io.*;
import java.util.Scanner;

class Country {
    // Declaration of array
    String[] countries;
    int n;

    // Constructor to initialize the array and input country names
    Country() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of countries you want to enter: ");
        n = scanner.nextInt();
        countries = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter country name: ");
            countries[i] = scanner.next();
        }
    }

    // Method to display the country names in descending order
    void display() {
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (countries[i].compareTo(countries[j]) < 0) {
                    temp = countries[i];
                    countries[i] = countries[j];
                    countries[j] = temp;
                }
            }
        }
        System.out.println("Sorted Countries: ");
        for (String country : countries) {
            System.out.print(country + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Country obj = new Country();
        obj.display();
    }
}