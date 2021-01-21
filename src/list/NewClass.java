package list;

import java.util.List;
import java.util.Scanner;

public class NewClass {

    public int getSeconds(int[] array) {
        int n = array.length;
        int sum = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return array[0] * 6;
        }
        sum = array[0] * 6;
        for (int i = 0; i < n - 1; i++) {
            int left = array[i];
            int right = array[i + 1];
            if (left < right) {
                sum = sum + (right - left) * (6 + 5);
            } else {
                sum = sum + (left - right) * (4 + 5);
            }
        }
        return sum;

    }

    void countMostFruit(String array) {
        array = "5 西瓜 苹果 蓝莓 苹果 苹果 3 桃 橙子 桃 1 陶 0";
        String[] strings = array.split("\\d");
        for (String subString : strings) {
            String[] fruits = subString.split("\\s");
            int maxLength = 0;
            String mostFruit = "";
            for (String fruit : fruits) {
                int length = subString.length();
                subString = subString.replaceAll(fruit, "");
                if (length - subString.length() > maxLength) {
                    maxLength = length - subString.length();
                    mostFruit = fruit;

                }
            }

            System.out.println(mostFruit);
        }
    }

    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "99999";
        System.out.print(add(num1, num2));
    }

    public static String add(String num1, String num2) {
        String sum = "";
        int length1 = num1.length();
        int length2 = num2.length();
        int newLocal = 0;
        if (length1 < length2) {
            String num = num2;
            num2 = num1;
            num1 = num;
            int length = length2;
            length2 = length1;
            length1 = length;

        }

        if (length1 > length2) {
            for (int index = length2 - 1; index >= 0; index--) {
                int index2 = index + (length1 - length2);
                int subNum1 = num1.charAt(index2) - 48;
                int subNum2 = num2.charAt(index) - 48;
                int internal = subNum1 + subNum2 + newLocal;
                if (internal >= 10) {
                    internal = internal - 10;
                    sum = internal + sum;
                    newLocal = 1;
                } else {
                    sum = internal + sum;
                    newLocal = 0;
                }
            }
            int subLength = num1.charAt(length1 - length2 - 1) - 48 + newLocal;
            if (subLength < 10) {
                return num1.substring(0, length1 - length2 - 1) + subLength + sum;
            } else {
                for (int index = length1 - length2 - 1; index >= 0; index--) {
                    int subLength2 = num1.charAt(index) - 48 + newLocal;
                    if (subLength2 < 10) {
                        newLocal = 0;
                        return num1.substring(0, index) + subLength2 + sum;
                    } else {
                        newLocal = 1;
                        subLength2 = subLength2 - 10;
                        sum = String.valueOf(subLength2) + sum;
                    }

                }
                return 1 + sum;
            }
        }
        return sum;

    }

    public void printTriangle(int n) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = 0;
        }
        int count = 1;
        int x = 0, y = 0;
        a[x][y] = 1;

        while (count < ((n * (n + 1)) / 2)) {
            while (x < n - 1 && a[x + 1][y] == 0) {
                a[++x][y] = ++count;
            }
            while (y < n - 1 && x > 0 && a[x][y + 1] == 0) {
                a[x][++y] = ++count;
            }
            while (y > 0 && a[x - 1][y - 1] == 0) {
                a[--x][--y] = ++count;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(a[i][j] + " ");
            }

        }

    }
}
