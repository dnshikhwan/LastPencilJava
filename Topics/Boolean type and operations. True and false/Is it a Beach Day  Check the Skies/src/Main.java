import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isSunny = scanner.nextBoolean();
        boolean isRainy = scanner.nextBoolean();
        boolean isCold = scanner.nextBoolean();

        // Calculate and print decision
        if (isSunny && !isRainy && !isCold) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        scanner.close();
    }
}