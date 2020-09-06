package com.enzo;

import java.util.Scanner;

public class T11_IP {

    public static void main(String[] args) {
        System.out.print("输入一个IP地址：");  // 提示输入IP地址
        Scanner s = new Scanner(System.in);    // 从键盘读入字符
        String a = s.next();        // 将读入后的字符转成字符串
        String z = a.replace(".", "");  // 用空字符替代点
        int x = a.length() - z.length();  // 点的个数
        int t = a.indexOf("..");
        if (t < 0) {
            boolean y = z.matches("[0-9]+"); // 判断除点外的字符是不是数字
            if (!y || !Character.isDigit(a.charAt(0))
                    || !Character.isDigit(a.charAt(a.length() - 1))) {
                System.out.println("ERROR"); // 判断除点外，第一位和最后一位字符是不是数字
            } else if (x == 3) {
                int b = a.indexOf('.'); // 第一个点的位置
                String c = a.substring(0, a.indexOf('.'));// 截取第一个数
                int i = Integer.parseInt(c); // 第一个数
                String d = a.substring(b + 1); // 截取第一个点后面的数
                int e = d.indexOf('.'); // 第二个点的位置
                String f = d.substring(0, e); // 截取第二个数
                int j = Integer.parseInt(f); // 第二个数
                String g = d.substring(e + 1); // 截取第二个点后面的数
                int h = g.indexOf('.'); // 第三个点的位置
                String l = g.substring(0, h); // 截取第三个数
                int k = Integer.parseInt(l); // 第三个数
                String m = g.substring(h + 1); // 截取第三个点后面的数
                int n = Integer.parseInt(m); // 第四个数
                if ((i > 0 && i <= 255) && (j > 0 && j <= 255) && (k >= 0 && k <= 255) && (n >= 0 && n <= 255))
                    System.out.println("OK");
                else
                    System.out.println("ERROR");
            }else{
                System.out.println("ERROR");
            }
        } else
            System.out.println("ERROR");
    }
}

