package com.enzo;

import java.util.Scanner;

/**
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 */
public class T06_CalcAutomorphicNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(CalcAutomorphicNumbers(n));
        }
        scanner.close();
    }

    public static int CalcAutomorphicNumbers(int n) {
        if (n == 0 || n == 1) {
            return n + 1;
        } else {
            int count = 2;
            for (int i = 2; i <= n; i++) {
//                if (isNum(i)) {
//                    count++;
//                    System.out.println(i);
//                }
                if (isNum2(i)) {
                    count++;
                    System.out.println(i);
                }
            }
            return count;
        }
    }

    // 方法1:if判断是否位数匹配
    public static boolean isNum(int i) {
        int s = i * i; // 除到0就可以了
        while (i != 0) {
            int tmp1 = i % 10;
            i /= 10;
            int tmp2 = s % 10;
            s /= 10;
            if (tmp1 != tmp2) {
                return false;
            }
        }
        return true;
    }

    // 方法2:调用endsWith()方法直接判断
    public static boolean isNum2(int i) {
        int s = i * i;
        return String.valueOf(s).endsWith(String.valueOf(i));
    }
}


