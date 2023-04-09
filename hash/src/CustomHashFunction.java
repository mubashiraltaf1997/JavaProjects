import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomHashFunction {

    // Custom hash function based on conditions
    public static int customHash(String key) {
        int hash = 0;

        // Condition 1: Sum of ASCII values of characters
        for (int i = 0; i < key.length(); i++) {
            hash += (int) key.charAt(i);
        }

        // Condition 2: Length of the key
        hash += key.length();

        // Condition 3: Multiply the hash by a constant
        hash *= 31;

        // Condition 4: Take modulo with a prime number
        int prime = 17;
        hash %= prime;

        return hash;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> hashMap = new HashMap<>();

        while (true) {
            System.out.print("Enter key: ");
            String key = scanner.nextLine();

            if (Integer.parseInt(key) < 0) {
                break;
            }

            System.out.print("Enter value: ");
            String value = scanner.nextLine();

            // Compute custom hash
            int hash = customHash(key);

            // Wrap key-value pair in the hash map
            int index = hash % 6;
            hashMap.put(index, value);

            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
            System.out.println("Hash: " + hash);
            System.out.println("HashMap: " + hashMap);
            System.out.println("Index: " + index);
            System.out.println();
        }
    }
}
