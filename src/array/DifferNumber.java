package array;

public class DifferNumber {
    public static int diffnum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                sum++;
                int temp = nums[left];
                while (left <= right && nums[right] == temp)
                    right--;
                while (left <= right && nums[left] == temp)
                    left++;
            } else if (nums[left] < nums[right]) {
                sum++;
                int temp = nums[left];
                while (left <= right && nums[left] == temp)
                    left++;
            } else {
                sum++;
                int temp = nums[right];
                while (left <= right && nums[right] == temp)
                    right--;
            }
        }
        return sum;
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i < 0 || B[j] >= A[i]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(diffnum(new int[]{1, 3, 9, 2}));
        merge(new int[]{1, 3, 9, 2}, 4, new int[]{1, 3, 9, 7}, 4);
    }
}
