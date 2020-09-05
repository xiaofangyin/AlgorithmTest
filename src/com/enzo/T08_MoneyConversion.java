package com.enzo;

import java.util.Scanner;

/**
 * 考试题目和要点：
 * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
 * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
 * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（40分）
 */
public class T08_MoneyConversion {

    public static void main(String[] args) {
        conversion();
    }

    private static void conversion() {
        Scanner in = new Scanner(System.in);
        String[] numStrs = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] unitStrs1 = {"角", "分"};
        String[] unitStrs2 = {"", "拾", "佰", "仟"};
        String[] unitStrs3 = {"", "万", "亿", "万亿"};
        while (in.hasNext()) {
            String n = in.nextLine();
            if (n.split("\\.")[0].length() > 13) {
                System.out.println("字符串长度整数部分不超过13位");
            }
            String result = "";
            String strs2 = n.split("\\.")[1];
            //小数点之后
            if ((strs2.length() == 1 && strs2.charAt(0) == '0') || (strs2.length() > 1 && strs2.charAt(0) == '0' && strs2.charAt(1) == '0')) {//整数
                result += "整";
            } else {//非整数
                for (int i = 0; i < Math.min(2, strs2.length()); i++) {
                    int tmp = strs2.charAt(i) - '0';
                    if (tmp != 0) {
                        result += numStrs[tmp] + unitStrs1[i];
                    }
                }
            }
            char[] chars = n.split("\\.")[0].toCharArray();
            //0元时不写元
            if (!(chars.length == 1 && chars[0] == '0')) {
                result = "元" + result;
            }
            //小数点之前
            int count = -1;
            for (int j = chars.length - 1; j >= 0; ) {//以四个为一组
                String str = "";
                for (int i = 0; i < 4 && j >= 0; i++) {
                    String num = numStrs[chars[j] - '0'];//当前位的数字
                    if (num.equals("零")) {
                        //这个零不能出现在最后一位（10.05）
                        //下一位不是零（100），连续中间有零时只读一个（1001）
                        if (chars.length - 1 - j != 0 && chars[j + 1] != '0' && str.charAt(0) != '零') {
                            str = num + str;
                        }
                    } else if (j == 0 && i == 1 && num.equals("壹")) {//防止壹拾壹元等情况的出现
                        str = unitStrs2[i] + str;
                    } else {
                        str = num + unitStrs2[i] + str;
                    }
                    j--;
                }
                count++;
                result = str + unitStrs3[count] + result;
            }
            result = "人民币" + result;
            System.out.println(result);
        }

    }
}
