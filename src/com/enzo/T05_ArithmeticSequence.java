package com.enzo;

import java.util.Scanner;

public class T05_ArithmeticSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sum(n));
    }

    /**
     * 功能:等差数列 2，5，8，11，14。。。。
     * 输入:正整数N >0
     * 输出:求等差数列前N项和
     * 返回:转换成功返回 0 ,非法输入与异常返回-1
     * 本题为多组输入，请使用while(cin>>)等形式读取数据
     */
    private static int sum(int n) {
        if (n == 0) return 0;
        else return sum(n - 1) + (3 * n - 1);
    }
}
