package com.enzo;

import java.util.Scanner;

public class T02_FindCount {

    public static void main(String[] args) {
        findCount();
    }

    /**
     * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
     * 输出输入字符串中含有该字符的个数。
     */
    private static void findCount() {
        Scanner input = new Scanner(System.in);
        // 输入字符串：包含空格、数字、字母
        String line = input.nextLine();
        // 得到要找的字符
        char item = input.nextLine().toLowerCase().charAt(0);

        // 转小写，并得到字符数组
        char[] chars = line.toLowerCase().toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (item == aChar) {
                count++;
            }
        }
        System.out.println(count);
        input.close();
    }

}
