package com.enzo;

import java.util.Scanner;

/**
 * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 */
public class T07_AddStartBeforeAndAfterNumber {

    public static void main(String[] args) {
        method2();
    }

    private static void method1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                    sb.append(str.charAt(i));
                else {
                    sb.append("*");
                    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        sb.append(str.charAt(i));
                        i++;
                    }
                    sb.append("*");
                    if (i != str.length())
                        sb.append(str.charAt(i));
                }
                i++;
            }
            System.out.println(sb.toString());
        }
    }

    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                    sb.append(str.charAt(i));
                } else {
                    sb.append("*");
                    sb.append(str.charAt(i));
                    sb.append("*");
                }
            }
            String result = sb.toString().replace("**", "");
            System.out.println(result);
        }
    }
}
