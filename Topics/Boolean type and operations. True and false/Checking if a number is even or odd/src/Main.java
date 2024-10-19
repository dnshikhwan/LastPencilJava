import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for taking input
        Scanner scanner = new Scanner(System.in);

        // Take integer input from the user
        int number = scanner.nextInt();

        // Use a simple way to determine if the number is even or odd.
        // If it's even, print true, otherwise, print false

        // Write your code here
        System.out.println(number % 2 == 0);

        scanner.close();
    }
}