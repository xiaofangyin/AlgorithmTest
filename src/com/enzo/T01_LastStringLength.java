package com.enzo;

import java.util.Scanner;

public class T01_LastStringLength {
    public static void main(String[] args) {
        lastStringLength();
    }

    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开。
     */
    private static void lastStringLength() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strings = input.split(" ");
        System.out.println("长度： " + strings[strings.length - 1].length());
        scanner.close();
    }

}
