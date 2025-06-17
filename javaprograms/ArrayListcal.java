import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ArrayListCalculator {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            boolean continueCalc = true;
            while (continueCalc) {
                try {
                    System.out.print("Enter the number of operations you want to perform: ");
                    int n = s.nextInt();
                    if (n <= 0) {
                        System.out.println("Please enter a number greater than 0.");
                        continue;
                    }
                    ArrayList<Double> numbers = new ArrayList<>();
                    ArrayList<String> operators = new ArrayList<>();
                    System.out.print("Enter the first number: ");
                    double result = s.nextDouble();
                    numbers.add(result);
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Enter operator (+, -, *, /, %): ");
                        String operator = s.next();
                        System.out.print("Enter the next number: ");
                        double number = s.nextDouble();
                        // Handle division by zero
                        if ((operator.equals("/") || operator.equals("%")) && number == 0) {
                            System.out.println("Cannot divide or modulus by zero.");
                            i--; // repeat the iteration
                            continue;
                        }
                        operators.add(operator);
                        numbers.add(number);
                        switch (operator) {
                            case "+" -> result += number;
                            case "-" -> result -= number;
                            case "*" -> result *= number;
                            case "/" -> result /= number;
                            case "%" -> result %= number;
                            default -> {
                                System.out.println("Invalid operator.");
                                operators.remove(operators.size() - 1);
                                numbers.remove(numbers.size() - 1);
                                i--;
                            }
                        }
                    }
                    // Display full expression
                    System.out.print("Expression: ");
                    System.out.print(numbers.get(0));
                    for (int i = 0; i < operators.size(); i++) {
                        System.out.print(" " + operators.get(i) + " " + numbers.get(i + 1));
                    }
                    System.out.println();
                    System.out.println("The final result is: " + result);
                    System.out.println("Numbers used: " + numbers);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numeric values.");
                    s.nextLine(); // clear buffer
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String ch = s.next();
                if (!ch.equalsIgnoreCase("yes")) {
                    continueCalc = false;
                    System.out.println("Calculator exited.");
                }
            }
        }
    }
}
