package sort;

/**
 * 直接插入排序
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        int j;//已排序列表下表
        int temp;//待排序元素
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                temp = arr[i + 1];
                for (j = i; j >= 0 && arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];// 从后往前遍历已排序列表，逐个和待排序元素比较，如果已排序元素较大，则将它后移
                }
                arr[j + 1] = temp;// 将待排序元素插入到正确的位置
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 直接插入排序
        insertSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
