import java.util.Arrays;
import java.util.Collections;

public class ArrayAndStringOperations {

    public void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public void sortArray(int[] arr) {
        Arrays.sort(arr);
    }

    public int searchArray(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public double averageArray(int[] arr) {
        if (arr.length == 0) return 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public int maximumArray(int[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayAndStringOperations ops = new ArrayAndStringOperations();
        int[] numbers = {5, 2, 8, 1, 9, 4};
        String text = "Hello World";
        int targetValue = 8;

        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Original String: " + text);

        System.out.println("\n--- Array Operations ---");

        ops.sortArray(numbers);
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(numbers));

        int searchIndex = ops.searchArray(numbers, targetValue);
        if (searchIndex != -1) {
            System.out.println("Search: Value " + targetValue + " found at index " + searchIndex);
        } else {
            System.out.println("Search: Value " + targetValue + " not found");
        }

        System.out.println("Average of Array: " + ops.averageArray(numbers));
        System.out.println("Maximum of Array: " + ops.maximumArray(numbers));

        ops.reverseArray(numbers);
        System.out.println("Reversed Array: " + Arrays.toString(numbers));
        
        System.out.println("\n--- String Operations ---");
        System.out.println("Reversed String: " + ops.reverseString(text));
    }
}
