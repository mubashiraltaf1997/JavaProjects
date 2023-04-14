import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Pre-defined array of Person objects
        Person[] persons = new Person[]{
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35),
                new Person("David", 40),
                new Person("Eve", 45)
        };

        // Sort the array by age
        Arrays.sort(persons, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Perform binary search
        Person searchPerson = new Person("David", 40);
        int binarySearchResult = binarySearch(persons, searchPerson, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        if (binarySearchResult == -1) {
            System.out.println("Binary search: Person not found.");
        } else {
            System.out.println("Binary search: Person found at index " + binarySearchResult + ": " + persons[binarySearchResult]);
        }

        // Perform linear search
        searchPerson = new Person("Charlie", 35);
        int linearSearchResult = linearSearch(persons, searchPerson, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        if (linearSearchResult == -1) {
            System.out.println("Linear search: Person not found.");
        } else {
            System.out.println("Linear search: Person found at index " + linearSearchResult + ": " + persons[linearSearchResult]);
        }
    }

    // Binary search method
    public static <T> int binarySearch(T[] arr, T searchKey, Comparator<T> comparator) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comparator.compare(arr[mid], searchKey);

            if (cmp == 0) {
                return mid; // Found
            } else if (cmp < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    // Linear search method
    public static <T> int linearSearch(T[] arr, T searchKey, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            if (comparator.compare(arr[i], searchKey) == 0) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    // Comparator interface for comparing Person objects by age
    public interface Comparator<T> {
        int compare(T o1, T o2);
    }
}