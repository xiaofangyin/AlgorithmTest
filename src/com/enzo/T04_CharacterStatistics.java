package com.enzo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 * <p>
 * 实现以下接口：
 * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
 * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出
 * 清空目前的统计结果，重新统计
 * 调用者会保证：
 * 输入的字符串以‘\0’结尾。
 */
public class T04_CharacterStatistics {

    public static void main(String[] args) {
        characterStatistics();
    }

    public static void characterStatistics() {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        // ascii, count
        HashMap<Integer, Integer> map = new HashMap();
        // ascii, ch
        HashMap<Integer, Character> asMap = new HashMap();

        int assicValue, countVal;
        // 对字符串进行字符个数统计
        for (char ch : str.toCharArray()) {
            // 只处理英文字符，数字，空格进行统计
            if (ch >= 'a' || ch <= 'z'
                    || ch >= 'A' || ch <= 'Z'
                    || ch >= '0' || ch <= '9'
                    || ch == ' ') {
                // 获取当前字符对应的ascci码
                assicValue = Integer.valueOf(ch);
                countVal = 0;
                if (map.containsKey(assicValue)) {
                    countVal = map.get(assicValue);
                }
                map.put(assicValue, ++countVal);
                asMap.put(assicValue, ch);
            }
        }

        List<Pairs> list = new ArrayList<>();
        map.forEach((k, v) -> {
            list.add(new Pairs(k, v));
        });

        // 优先根据字符出现的个数进行降序排序
        list.sort((p1, p2) -> {
            // 如果个数相同， 则按照ascii码进行升序排序
            if (p1.getValue() - p2.getValue() == 0) {
                // 升序
                return p1.getKey() - p2.getKey();
            }
            // 降序
            return p2.getValue() - p1.getValue();
        });

        // 输出结果
        StringBuilder rlt = new StringBuilder();
        for (Pairs pairs : list) {
            Integer k = pairs.getKey();
            rlt.append(asMap.get(k));
        }

        System.out.println(rlt.toString());
    }

    public static class Pairs {
        private Integer key;
        private Integer value;

        public Pairs(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

}
