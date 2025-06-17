import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class QueueMenu {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedList<Integer> queue = new LinkedList<>();
            boolean running = true;
            while (running) {
                System.out.println("\n====== Queue Operations Menu ======");
                System.out.println("1. Enqueue (Insert)");
                System.out.println("2. Dequeue (Remove)");
                System.out.println("3. Peek (Front Element)");
                System.out.println("4. Display Queue");
                System.out.println("5. Is Queue Empty?");
                System.out.println("6. Size of Queue");
                System.out.println("7. Exit");
                System.out.print("Enter your choice (1-7): ");
                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    continue;
                }
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter element to enqueue: ");
                        try {
                            int element = Integer.parseInt(sc.nextLine());
                            queue.addLast(element);
                            System.out.println(element + " enqueued.");
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid input. Please enter an integer.");
                        }
                    }
                    case 2 -> {
                        if (queue.isEmpty()) {
                            System.out.println("Queue is empty. Cannot dequeue.");
                        } else {
                            int removed = queue.removeFirst();
                            System.out.println("Dequeued element: " + removed);
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("Front element is: " + queue.getFirst());
                        } catch (NoSuchElementException e) {
                            System.out.println("Queue is empty.");
                        }
                    }
                    case 4 -> {
                        if (queue.isEmpty()) {
                            System.out.println("Queue is empty.");
                        } else {
                            System.out.println("Queue elements: " + queue);
                        }
                    }
                    case 5 -> System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is not empty.");
                    case 6 -> System.out.println("Size of queue: " + queue.size());
                    case 7 -> {
                        running = false;
                        System.out.println("Exiting Queue Program. Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please select between 1 and 7.");
                }
                // Display queue elements after each operation
                if (!queue.isEmpty()) {
                    System.out.println("Current Queue: " + queue);
                } else {
                    System.out.println("Current Queue is empty.");
                }
            }
        }
    }
}
