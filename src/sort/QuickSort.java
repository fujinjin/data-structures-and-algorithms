package sort;

import java.util.Arrays;

/**
 * 快速排序
 */

public class QuickSort {

    public static int[] quickSort(int[] arr) {
        int[] array = Arrays.copyOf(arr, arr.length);
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            sort(array, left, partitionIndex - 1);
            sort(array, partitionIndex + 1, right);
        }

    }

    private static int partition(int[] array, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] array, int i, int index) {
        int temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        int[] array = QuickSort.quickSort(arr);
        System.out.println("\n交换后：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
