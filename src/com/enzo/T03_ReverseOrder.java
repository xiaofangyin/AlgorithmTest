package com.enzo;

import java.util.Scanner;

public class T03_ReverseOrder {

    public static void main(String[] args) {
        reverseOrder();
    }

    /**
     * 字符逆序
     */
    private static void reverseOrder() {
        String str = "";
        do {
            System.out.println("请输入字符串(长度小于100):");
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
        } while (str.length() > 100);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        System.out.println("输出结果: " + stringBuilder.toString());
    }

}
