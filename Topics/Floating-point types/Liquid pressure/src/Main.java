import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double p = scanner.nextDouble();
        double g = 9.8;
        double h = scanner.nextDouble();

        double pressure = p * g * h;
        System.out.println(pressure);

        scanner.close();
    }
}