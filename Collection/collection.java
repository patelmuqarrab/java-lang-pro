// Set A

/* a) Write a java program to accept names of ‘n’ cities, insert same into array list
collection and display the contents of same array list, also remove all these elements. */

import java.util.ArrayList;
import java.util.Scanner;

public class CityListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cities = new ArrayList<>();

        // Get number of cities
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Input city names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter city name #" + (i+1) + ": ");
            String city = scanner.nextLine();
            cities.add(city);
        }

        // Display the ArrayList
        System.out.println("\nCities in the list:");
        System.out.println(cities);

        // Remove all elements
        cities.clear();
        System.out.println("\nAfter removing all elements:");
        System.out.println("Cities list: " + cities);

        scanner.close();
    }
}

/* b) Write a java program to read ‘n’ names of your friends, store it into linked list, also
display contents of the same.*/

import java.util.LinkedList;
import java.util.Scanner;

public class FriendListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> friends = new LinkedList<>();

        // Get number of friends
        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Input friend names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter friend name #" + (i+1) + ": ");
            String name = scanner.nextLine();
            friends.add(name);
        }

        // Display the LinkedList
        System.out.println("\nFriends in the list:");
        System.out.println(friends);

        scanner.close();
    }
}

/* c) Write a program to create a new tree set, add some colors (string) and print out the
tree set.*/

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet to store colors
        TreeSet<String> colors = new TreeSet<>();

        // Add colors to the TreeSet
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");
        colors.add("Violet");
        
        // Add a duplicate (will be ignored)
        colors.add("Green");

        // Print the TreeSet (automatically sorted)
        System.out.println("Colors in TreeSet (sorted alphabetically):");
        System.out.println(colors);
    }
}

/*d) Create the hash table that will maintain the mobile number and student name. Display
the contact list.*/

import java.util.Hashtable;
import java.util.Map;

public class ContactList {
    public static void main(String[] args) {
        // Create Hashtable with String keys (mobile) and String values (names)
        Hashtable<String, String> contacts = new Hashtable<>();
        
        // Add entries to the Hashtable
        contacts.put("9876543210", "Alice Smith");
        contacts.put("8765432109", "Bob Johnson");
        contacts.put("7654321098", "Charlie Brown");
        contacts.put("6543210987", "Diana Miller");
        contacts.put("5432109876", "Evan Davis");

        // Display the contact list
        System.out.println("Contact List:");
        System.out.println("-------------");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Mobile: " + entry.getKey() + 
                             "\tName: " + entry.getValue());
        }
    }
}

// Set B

/* a) Accept ‘n’ integers from the user. Store and display integers in sorted order having
proper collection class. The collection should not accept duplicate elements.*/

import java.util.Scanner;
import java.util.TreeSet;

public class SortedUniqueIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> numbers = new TreeSet<>();

        System.out.print("Enter the number of integers (n): ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (!numbers.add(num)) {
                System.out.println("Duplicate value " + num + " ignored");
            }
        }

        System.out.println("\nSorted unique integers:");
        System.out.println(numbers);
        
        scanner.close();
    }
}

/* b) Write a program to sort HashMap by keys and display the details before sorting and
after sorting. */

import java.util.*;

public class HashMapSorting {
    public static void main(String[] args) {
        // Create and populate original HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("John", 25);
        hashMap.put("Alice", 30);
        hashMap.put("Bob", 22);
        hashMap.put("Diana", 28);
        hashMap.put("Charlie", 35);

        // Display original HashMap
        System.out.println("Original HashMap (Unsorted):");
        displayMap(hashMap);

        // Sort using TreeMap
        Map<String, Integer> sortedMap = new TreeMap<>(hashMap);

        // Display sorted TreeMap
        System.out.println("\nSorted by Keys:");
        displayMap(sortedMap);
    }

    private static void displayMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + 
                             ", Value: " + entry.getValue());
        }
    }
}

// Set C
/*a) Create a java application to store city names and their STD codes using an
appropriate collection. The GUI should allow the following operations:
i. Add a new city and its code (No duplicates)
ii. Remove a city from the collection
iii. Search for a city name and display the code*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CityCodeApp extends JFrame {
    private HashMap<String, String> cityCodes = new HashMap<>();
    private JTextField cityField, codeField;
    private JTextArea outputArea;

    public CityCodeApp() {
        setTitle("City STD Code Manager");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("City Name:"));
        cityField = new JTextField();
        inputPanel.add(cityField);
        inputPanel.add(new JLabel("STD Code:"));
        codeField = new JTextField();
        inputPanel.add(codeField);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton searchButton = new JButton("Search");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> addCity());
        removeButton.addActionListener(e -> removeCity());
        searchButton.addActionListener(e -> searchCity());
    }

    private void addCity() {
        String city = cityField.getText().trim();
        String code = codeField.getText().trim();

        if (city.isEmpty() || code.isEmpty()) {
            showError("Both fields must be filled!");
            return;
        }

        if (!code.matches("\\d+")) {
            showError("STD code must be numeric!");
            return;
        }

        if (cityCodes.containsKey(city)) {
            showError("City already exists!");
            return;
        }

        cityCodes.put(city, code);
        outputArea.append("Added: " + city + " - " + code + "\n");
        clearFields();
    }

    private void removeCity() {
        String city = cityField.getText().trim();
        
        if (city.isEmpty()) {
            showError("Enter city name to remove!");
            return;
        }

        if (cityCodes.containsKey(city)) {
            cityCodes.remove(city);
            outputArea.append("Removed: " + city + "\n");
        } else {
            showError("City not found!");
        }
        clearFields();
    }

    private void searchCity() {
        String city = cityField.getText().trim();
        
        if (city.isEmpty()) {
            showError("Enter city name to search!");
            return;
        }

        if (cityCodes.containsKey(city)) {
            outputArea.append("Found: " + city + " - " + cityCodes.get(city) + "\n");
        } else {
            showError("City not found!");
        }
        clearFields();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void clearFields() {
        cityField.setText("");
        codeField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CityCodeApp().setVisible(true);
        });
    }
}

/*Write a program to create link list of integer objects. Do the following:
i. add element at first position
ii. delete last element
iii. display the size of link list*/

import java.util.LinkedList;

public class LinkedListOperations {
    public static void main(String[] args) {
        // Create LinkedList of Integer objects
        LinkedList<Integer> numberList = new LinkedList<>();
        
        // Add initial elements
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        System.out.println("Initial List: " + numberList);

        // i. Add element at first position
        numberList.addFirst(5);
        System.out.println("\nAfter adding 5 at first position: " + numberList);

        // ii. Delete last element
        if (!numberList.isEmpty()) {
            numberList.removeLast();
            System.out.println("After removing last element: " + numberList);
        } else {
            System.out.println("List is empty - cannot remove last element");
        }

        // iii. Display the size of linked list
        System.out.println("\nCurrent size of LinkedList: " + numberList.size());
    }
}

/*Read a text file, specified by the first command line argument, into a list. The
program should then display a menu which performs the following operations on the
list:
1. Insert line 2. Delete line 3. Append line 4. Modify line 5. Exit
When the user selects Exit, save the contents of the list to the file and end the
program*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileEditor {
    private static ArrayList<String> lines = new ArrayList<>();
    private static String filename;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please specify a filename as command line argument");
            return;
        }
        
        filename = args[0];
        readFile();
        showMenu();
    }

    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with empty document.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nCurrent Document:");
            displayDocument();
            System.out.println("\nMenu:");
            System.out.println("1. Insert line");
            System.out.println("2. Delete line");
            System.out.println("3. Append line");
            System.out.println("4. Modify line");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1 -> insertLine(scanner);
                    case 2 -> deleteLine(scanner);
                    case 3 -> appendLine(scanner);
                    case 4 -> modifyLine(scanner);
                    case 5 -> saveAndExit();
                    default -> System.out.println("Invalid choice. Please enter 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                choice = 0;
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private static void displayDocument() {
        if (lines.isEmpty()) {
            System.out.println("(Document is empty)");
            return;
        }
        
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }

    private static void insertLine(Scanner scanner) {
        System.out.print("Enter line number to insert at: ");
        int lineNumber = getValidLineNumber(scanner, true);
        if (lineNumber == -1) return;

        System.out.print("Enter text to insert: ");
        String text = scanner.nextLine();
        lines.add(lineNumber - 1, text);
    }

    private static void deleteLine(Scanner scanner) {
        if (lines.isEmpty()) {
            System.out.println("Document is empty - nothing to delete");
            return;
        }

        System.out.print("Enter line number to delete: ");
        int lineNumber = getValidLineNumber(scanner, false);
        if (lineNumber == -1) return;

        lines.remove(lineNumber - 1);
    }

    private static void appendLine(Scanner scanner) {
        System.out.print("Enter text to append: ");
        String text = scanner.nextLine();
        lines.add(text);
    }

    private static void modifyLine(Scanner scanner) {
        if (lines.isEmpty()) {
            System.out.println("Document is empty - nothing to modify");
            return;
        }

        System.out.print("Enter line number to modify: ");
        int lineNumber = getValidLineNumber(scanner, false);
        if (lineNumber == -1) return;

        System.out.print("Enter new text: ");
        String text = scanner.nextLine();
        lines.set(lineNumber - 1, text);
    }

    private static int getValidLineNumber(Scanner scanner, boolean forInsert) {
        try {
            int lineNumber = Integer.parseInt(scanner.nextLine());
            int maxAllowed = forInsert ? lines.size() + 1 : lines.size();
            
            if (lineNumber < 1 || lineNumber > maxAllowed) {
                System.out.println("Line number must be between 1 and " + maxAllowed);
                return -1;
            }
            return lineNumber;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
            return -1;
        }
    }

    private static void saveAndExit() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Document saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}


