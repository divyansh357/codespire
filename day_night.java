import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Helper function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input D and P
        int D = scanner.nextInt();
        int P = scanner.nextInt();

        // Calculate the length of each part
        int partLength = D / P;

        // List to store prime numbers up to D
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < D; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        int count = 0;

        // Iterate through each hour
        for (int hour = 0; hour < D; hour++) {
            boolean allPrime = true;

            // Check equivalent hours in all parts
            for (int part = 0; part < P; part++) {
                int equivalentHour = (hour + part * partLength) % D;
                if (!isPrime(equivalentHour)) {
                    allPrime = false;
                    break;
                }
            }

            // If all equivalent hours are prime, increment count
            if (allPrime) {
                count++;
            }
        }

        // Output the result
        System.out.println(count);

        scanner.close();
    }
}
