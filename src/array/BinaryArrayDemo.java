package array;

public class BinaryArrayDemo {
    public static void main(String[] args) {
        int[][] a = new int[3][2];
        int[] b = new int[5];
        for (int i = 0; i <b.length ; i++) {
            System.out.println(b[i]);
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }

    public int getNum(int[]array, int target){
        if (array ==null || array.length == 0){
            return -1;
        }
        int low = 0;
        int high = array.length;
        int mid = low + (high - low)/2;
        while (low<=high){
            if (array[mid] == target){
                while (mid>0 && array[mid-1]== array[mid]){
                    mid--;
                }
                return mid-1;
            }else if (array[mid] > target){
                low = mid +1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
}
