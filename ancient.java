import java.util.*;

public class Main {

    // Function to find the nth special number
    public static long nthSpecialNumber(int n) {
        // Min-heap to store the special numbers
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        // Set to track already seen numbers
        Set<Long> seen = new HashSet<>();
        
        // Start with the base number 1
        minHeap.add(1L);
        seen.add(1L);
        
        // The prime factors 2, 3, and 5
        long[] primes = {2, 3, 5};
        
        // Extract the smallest element n times
        long current = 1L;
        for (int i = 0; i < n; i++) {
            // Get the smallest element
            current = minHeap.poll();
            
            // Generate new special numbers by multiplying with 2, 3, and 5
            for (long prime : primes) {
                long newNumber = current * prime;
                if (!seen.contains(newNumber)) {
                    seen.add(newNumber);
                    minHeap.add(newNumber);
                }
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // Read input n
        System.out.println(nthSpecialNumber(n));  // Output the nth special number
    }
}
