package heap;

public class MinKNumber {
    public static void main(String[] args) {

        MinKNumber minKNumber = new MinKNumber();
        int[] result = minKNumber.findMinKNum(new int[]{1, 5, 3, 2, 3, 4, 5, 6, 9, 10}, 5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] findMinKNum(int[] input, int k) {
        if (input == null || input.length < k) {
            return new int[]{};
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = input[i];
        }
        result = buildMaxHeap(result);

        for (int i = k; i < input.length; i++) {
            if (input[i] < result[0]) {
                result[0] = input[i];
                adjustHeapToTop(result, 0, k);
            }
        }

        return result;
    }

    private int[] buildMaxHeap(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            adjustHeapToTop(array, i, array.length);
        }
        return array;
    }

    private void adjustHeapToTop(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i < length; i = i * 2 + 1) {
            if (i < length - 1 && array[i] < array[i + 1]) {
                i++;
            }
            if (temp > array[i]) {
                break;
            } else {
                array[k] = array[i];
                k = i;
            }
            array[i] = temp;
        }
    }
}
