package com.holger.learn.字符串相关.字符串全组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holger
 * @date 2019/5/6
 */
public class Combination {

    /**
     * 全组合的字符串
     * 核心思路是取第一个，剩下的取n-1个
     * 不取第一个，剩下的取n个
     *
     * @param str
     * @return
     */
    public static String[] recursive(String str) {
        List<String> list = new ArrayList<>();
        char[] c = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= c.length; i++) {
            permutation(c, 0, i, sb, list);
        }
        return list.toArray(new String[list.size()]);
    }

    private static void permutation(char[] c, int begin, int len, StringBuffer sb, List<String> list) {
        if (len == 0) {
            list.add(sb.toString());
            return;
        }

        if (begin == c.length) {
            return;
        }
        //取第一个
        sb.append(c[begin]);
        //剩下的里面选len-1个
        permutation(c, begin + 1, len - 1, sb, list);
        //不取
        sb.deleteCharAt(sb.length() - 1);
        //剩下的里面选len个
        permutation(c, begin + 1, len, sb, list);
    }

    /**
     * 利用位运算的方法来获取全部的数
     *
     * @param str
     * @return
     */
    public static String[] subset(String str) {
        List<String> list = new ArrayList<>();
        char[] array = str.toCharArray();
        int n = 1 << array.length;
        for (int i = 1; i < n; i++) {
            int j = 1 << (array.length - 1);
            int count = 0;
            String s = "";
            while (j >= 1) {
                if ((i & j) != 0) {
                    s += array[array.length - 1 - count];
                }
                count++;
                j >>= 1;
            }
            list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * 位运算方法二
     * @param str
     * @return
     */
    public static String[] subset2(String str) {
        List<String> list = new ArrayList<>();
        char[] array = str.toCharArray();
        int n = array.length;
        for (int i = 1; i < (1 << n); i++) {
            String s = "";
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    s += array[j];
                }
            }
            list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }


}
