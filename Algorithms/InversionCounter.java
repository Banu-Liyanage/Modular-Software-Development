import java.io.*;
import java.util.*;

public class InversionCounter {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        // Read the file into a list
        try (BufferedReader br = new BufferedReader(new FileReader("IntegerArray.txt"))) {//this file was uploaded to the workspace from FileDownloader.java
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line)); //this passes the string into a signed integer 
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        int[] arr = numbers.stream().mapToInt(i -> i).toArray();

        //  Count inversions
        long totalInversions = countInversions(arr);
        System.out.println("Total Inversions: " + totalInversions);
    }

    //  Modified Merge Sort for counting inversions
    private static long countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(arr, temp, left, mid);
            count += mergeSort(arr, temp, mid + 1, right);
            count += merge(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long merge(int[] arr, int[] temp, int left, int mid, int right) {
        long count = 0;
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);  // Count inversions
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
