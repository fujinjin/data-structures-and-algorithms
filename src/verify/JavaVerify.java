package verify;

import java.util.Scanner;

public class JavaVerify{
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        String str1 = new String("str1");
        String str2 = new String("str2");
        swap(num1,num2);
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        swap(str1,str2);
        System.out.println("str1 : " + str1);
        System.out.println("str2 : " + str2);
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(s);
        input.close();
    }

    private static void swap(String a, String b) {
        String temp = a;
        a = b;
        b = temp;
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a : " + a);
        System.out.println("b : " + b);

    }

}
