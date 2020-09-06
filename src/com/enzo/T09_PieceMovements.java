package com.enzo;

import java.util.Scanner;

/**
 * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
 * 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 *
 * 解题思路：对于一个n*m的格子，由题意，若右走则变成n*(m-1)的格子，若往下走则变成（n-1）*m的格子，由此可得递推关系式
 * f（n,m）=f(n-1,m)+f(n,m-1),又当格子只剩下一条边时，只有唯一的走法。
 */
public class T09_PieceMovements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int result = getResult(n, m);
        System.out.println(result);
        scanner.close();
    }

    public static int getResult(int n, int m) {
        if (m < 0 || n < 0)
            return 0;
        if ((m == 1 && n == 0) || (n == 1 && m == 0))
            return 1;
        return getResult(n, m - 1) + getResult(n - 1, m);
    }

}
