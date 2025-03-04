// Set A

/*a) Program to define a thread for printing text on output screen for ‘n’ number of times.
Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor.
Example:
i. First thread prints “COVID19” 10 times.
ii. Second thread prints “LOCKDOWN2020” 20 times
iii. Third thread prints “VACCINATED2021” 30 times */

class PrintTask implements Runnable {
    private String text;
    private int count;

    // Constructor to pass text and count
    public PrintTask(String text, int count) {
        this.text = text;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
}

public class ThreadPrintDemo {
    public static void main(String[] args) {
        // Create 3 threads with different text and counts
        Thread t1 = new Thread(new PrintTask("COVID19", 10));
        Thread t2 = new Thread(new PrintTask("LOCKDOWN2020", 20));
        Thread t3 = new Thread(new PrintTask("VACCINATED2021", 30));

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}

/* b) Write a program in which thread sleep for 6 sec in the loop in reverse order from 100
to 1 and change the name of thread. */

public class ReverseCounterThread extends Thread {
    @Override
    public void run() {
        for (int i = 100; i >= 1; i--) {
            // Change the thread name for each iteration
            setName("CounterThread-" + i);
            System.out.println("Thread Name: " + getName() + " - Count: " + i);
            
            // Sleep for 6 seconds (6000 milliseconds)
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                break;
            }
        }
    }

    public static void main(String[] args) {
        ReverseCounterThread counter = new ReverseCounterThread();
        counter.start();
    }
}

// Set B

/* a) Write a program to calculate the sum and average of an array of 1000 integers
(generated randomly) using 10 threads. Each thread calculates the sum of 100
integers. Use these values to calculate average. [Use join method ].*/

import java.util.concurrent.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class OptimizedArraySum {
    private static final int ARRAY_SIZE = 1000;
    private static final int THREAD_COUNT = 10;
    private static final int CHUNK_SIZE = ARRAY_SIZE / THREAD_COUNT;

    public static void main(String[] args) {
        // Generate random array using parallel stream
        int[] numbers = ThreadLocalRandom.current()
                .ints(ARRAY_SIZE, 0, 1000)
                .toArray();

        // Create thread pool with fixed number of threads
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Future<Integer>[] futures = new Future[THREAD_COUNT];

        // Submit all tasks to executor
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int start = i * CHUNK_SIZE;
            final int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : start + CHUNK_SIZE;
            futures[i] = executor.submit(() -> calculatePartialSum(numbers, start, end));
        }

        // Calculate total sum and average
        try {
            int totalSum = 0;
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }
            double average = (double) totalSum / ARRAY_SIZE;
            
            System.out.println("Total Sum: " + totalSum);
            System.out.printf("Average: %.2f%n", average);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static int calculatePartialSum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}

// Set C

/* a) Write a program that simulates a traffic light. The program lets the user select one of
three lights: red, yellow, or green with radio buttons. On selecting a button, an
appropriate message with “stop” or “ready” or “go”should appear above the buttons in
a selected color. Initially there is no message shown.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame {
    private JLabel messageLabel;
    private JRadioButton redButton, yellowButton, greenButton;

    public TrafficLightSimulator() {
        setTitle("Traffic Light Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout(10, 10));

        // Message label setup
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(messageLabel, BorderLayout.NORTH);

        // Radio buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group radio buttons
        ButtonGroup lightGroup = new ButtonGroup();
        lightGroup.add(redButton);
        lightGroup.add(yellowButton);
        lightGroup.add(greenButton);

        // Add action listeners
        redButton.addActionListener(new LightListener(Color.RED, "STOP"));
        yellowButton.addActionListener(new LightListener(Color.YELLOW, "READY"));
        greenButton.addActionListener(new LightListener(Color.GREEN, "GO"));

        // Add buttons to panel
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Configure window
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class LightListener implements ActionListener {
        private final Color color;
        private final String message;

        public LightListener(Color color, String message) {
            this.color = color;
            this.message = message;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText(message);
            messageLabel.setForeground(color);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrafficLightSimulator());
    }
}

/* b) Write a program to create a thread for moving a ball inside a panel vertically. The ball
should be created when the user clicks on the start button. */

import javax.swing.*;
import java.awt.*;

public class BallMovement extends JFrame {
    private final BallPanel ballPanel = new BallPanel();
    private final JButton startButton = new JButton("Start");

    public BallMovement() {
        setTitle("Moving Ball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);

        startButton.addActionListener(e -> {
            startButton.setEnabled(false);
            ballPanel.createBall();
            new Thread(() -> {
                try {
                    while (true) {
                        Thread.sleep(50);
                        SwingUtilities.invokeLater(() -> {
                            ballPanel.moveBall();
                            ballPanel.repaint();
                        });
                    }
                } catch (InterruptedException ignored) { }
            }).start();
        });
        add(new JPanel() {{ add(startButton); }}, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BallMovement().setVisible(true));
    }

    class BallPanel extends JPanel {
        private static final int DIAMETER = 30;
        private int yPos;
        private boolean ballExists;

        public void createBall() { yPos = 0; ballExists = true; }

        public void moveBall() {
            if (!ballExists) return;
            yPos += 3;
            if (yPos > getHeight()) yPos = -DIAMETER;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (ballExists) {
                int xCenter = getWidth() / 2 - DIAMETER / 2;
                g.setColor(Color.RED);
                g.fillOval(xCenter, yPos, DIAMETER, DIAMETER);
            }
        }
    }
}


/* c) Using the concepts of thread synchronization create two threads as sender and
receiver. Sender thread will set a message to the receiver thread that will display the
message on console. The sender thread accepts the input message from console.
Continue this process until sender sets the message as “Good Bye Corona”.*/

import java.util.Scanner;

class MessageBuffer {
    private String message;
    private boolean empty = true;

    public synchronized void put(String message) throws InterruptedException {
        while (!empty) wait();
        this.message = message;
        empty = false;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (empty) wait();
        String msg = message;
        empty = true;
        notifyAll();
        return msg;
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        MessageBuffer buffer = new MessageBuffer();

        Thread sender = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                String message;
                do {
                    System.out.print("Sender: Enter message: ");
                    message = scanner.nextLine();
                    buffer.put(message);
                } while (!"Good Bye Corona".equals(message));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread receiver = new Thread(() -> {
            try {
                String message;
                do {
                    message = buffer.take();
                    System.out.println("Receiver: " + message);
                } while (!"Good Bye Corona".equals(message));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        sender.start();
        receiver.start();

        try {
            sender.join();
            receiver.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Communication ended");
    }
}

