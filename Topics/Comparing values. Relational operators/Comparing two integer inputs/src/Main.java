import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the first integer from user input
        int num1 = scanner.nextInt();

        // Get the second integer from user input
        int num2 = scanner.nextInt();

        // Write your code here to compare num1 and num2
        // You should use the relational operators to compare the values
        // Then print 'less than', 'equal to' or 'greater than' according to the comparison result
        if (num1 == num2) {
            System.out.println("equal to");
        } else if (num1 < num2) {
            System.out.println("less than");
        } else {
            System.out.println("greater than");
        }

    }
}