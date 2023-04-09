import java.util.Random;

public class BinarySearch {

    public static int iterativeBinarySearch(int[] arr, int target, int size) {
        int low = 0;
        int high = size - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            count++;


            if (arr[mid] == target) {
                return count;
            }

            if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return count;
    }

    public static int recursiveBinarySearch(int[] arr, int target, int low, int high) {
        int count = 1;

        if (low > high) {
            return 0;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return count;
        }

        if (arr[mid] < target) {
            return count + recursiveBinarySearch(arr, target, mid + 1, high);
        } else {
            return count + recursiveBinarySearch(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("size" + "\t" + "avgIterativeComp" + "\t" + "avgRecursiveComp");

        for (int size : new int[]{5000, 10000, 15000, 20000, 25000, 30000}) {
            int[] arr = new int[size];
            int totalIterativeComp = 0;
            int totalRecursiveComp = 0;

            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(size);
            }

            for (int i = 0; i < 50; i++) {
                int target = rand.nextInt(size);
                totalIterativeComp += iterativeBinarySearch(arr, target, size);
                totalRecursiveComp += recursiveBinarySearch(arr, target, 0, size - 1);
            }

            double avgIterativeComp = (double) totalIterativeComp / 50.0;
            double avgRecursiveComp = (double) totalRecursiveComp / 50.0;

            System.out.println(size + "\t" + avgIterativeComp + "\t\t\t\t" + avgRecursiveComp);
        }
    }

}
