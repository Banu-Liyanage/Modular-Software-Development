import java.io.*;
import java.util.*;

public class QuickSortLast {
    private static int totalComparisons = 0;

    public static void main(String[] args) throws IOException {
        int[] input = readInput("IntegerArray_2.txt");
        quickSort(input, 0, input.length - 1);
        System.out.println("Total comparisons (last element as pivot): " + totalComparisons);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        totalComparisons += (right - left);

        //  Use last element as pivot by swapping it to the front
        swap(arr, left, right);

        int pivotIndex = partition(arr, left, right);

        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, left, i - 1);
        return i - 1;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] readInput(String IntegerArray_2) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(IntegerArray_2));
        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Integer.parseInt(line.trim()));
        }
        br.close();
        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
