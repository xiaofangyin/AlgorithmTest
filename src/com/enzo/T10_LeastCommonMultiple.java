package com.enzo;

import java.util.Scanner;

/**
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 分析：最小公倍数=两个数的乘积/最大公约数
 */
public class T10_LeastCommonMultiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println("最小公倍数: " + (m * n / getResult(m, n)));
    }

    private static int getResult(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int k;
        while (n != 0) {
            k = m % n;
            m = n;
            n = k;
        }
        return m;
    }
}
