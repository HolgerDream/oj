package com.holger.leetcode.P13.罗马数转整数;

/**
 * @author Holger
 * @date 2019/7/17
 */
public class Solution2 {
    static int[] map = new int[128];

    static {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }

    /**
     * 次方法的核心思想是判断后面一个字符是否大于前面的字符
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (i + 1 < cs.length && map[cs[i]] < map[cs[i + 1]]) {
                res -= map[cs[i]];
            } else {
                res += map[cs[i]];
            }
        }
        return res;
    }
}
