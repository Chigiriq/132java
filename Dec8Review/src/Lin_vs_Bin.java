import java.util.Arrays;

public class Lin_vs_Bin {
	// Linear Search Function
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Element found, return its index
            }
        }
        return -1; // Element not found
    }

    // Binary Search Function (Assumes the array is sorted)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Element found, return its index
            } else if (arr[mid] < target) {
                low = mid + 1; // Discard left half
            } else {
                high = mid - 1; // Discard right half
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetElement = 7;

        // Linear Search
        int linearResult = linearSearch(sortedArray, targetElement);
        if (linearResult != -1) {
            System.out.println("Linear Search: Element found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Element not found");
        }

        // Binary Search
        int binaryResult = binarySearch(sortedArray, targetElement);
        if (binaryResult != -1) {
            System.out.println("Binary Search: Element found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Element not found");
        }
    }
}
