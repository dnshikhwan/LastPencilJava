import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double C = scanner.nextDouble();
        double F = C * 1.8 + 32;
        System.out.println(F);

        scanner.close();
    }
}