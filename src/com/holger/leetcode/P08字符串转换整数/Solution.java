package com.holger.leetcode.P08字符串转换整数;

/**
 * @author Holger
 * @date 2019/5/7
 */
public class Solution {
    /**
     * 此种方法不行。
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (res.isEmpty() && str.charAt(i) != 0 && str.charAt(i) != '-' && str.charAt(i) > 57 && str.charAt(i) < 48) {
                return 0;
            } else if (str.charAt(i) == '-' && res.isEmpty()) {
                res += str.charAt(i);
            } else {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    res += str.charAt(i);
                }
            }
        }
        if (res.isEmpty() || res.equals("-")) {
            return 0;
        }
        Long r = Long.valueOf(res);
        if (r < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (r > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return r.intValue();
    }

    public static void main(String[] args) {
        System.out.println(myAtoi3("   -42"));
        System.out.println(myAtoi3("-+1"));
        System.out.println(myAtoi3("+-2"));
        System.out.println(myAtoi3("+1"));
        System.out.println(myAtoi3("3.14159"));
        System.out.println(myAtoi3("words and 987"));
        System.out.println(myAtoi3("-4193- with words"));
        System.out.println(myAtoi3("-91283472332"));
        System.out.println(myAtoi3("20000000000000000000"));

    }

    /**
     * 应该在读入数据的时候就判断出当前数据是否超出了int的上线
     *
     * @param str
     * @return
     */
    public static int myAtoi2(String str) {
        //判断异常情况
        if (str.isEmpty()) {
            return 0;
        }
        if (str.indexOf("+-") != -1) {
            return 0;
        }
        String res = "";
        Long tmp = 0L;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && str.charAt(i) != '+' && res.isEmpty()) {
                if (str.charAt(i) == '-') {
                    res += str.charAt(i);
                } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    return 0;
                }
            }
            if (!res.isEmpty()) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9' && str.charAt(i) != '-') {
                    break;
                }
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res += str.charAt(i);
            }
            if (!res.isEmpty() && !res.equals("-")) {
                tmp = Long.valueOf(res);
                if (tmp > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (tmp < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        if (res.isEmpty() || res.equals("-")) {
            return 0;
        }
        return Integer.valueOf(res);
    }

    /**
     * 正确代码
     * @param str
     * @return
     */
    public static int myAtoi3(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        char[] chr = str.trim().toCharArray();
        int start = 0, flag = 1, result = 0;
        if (chr[0] == '-' || chr[0] == '+') {
            start = 1;
            flag = chr[0] == '-' ? -1 : 1;
        }
        String res = "";
        Long tmp = 0L;
        for (int i = start; i < chr.length; i++) {
            if (chr[i] > '9' || chr[i] < '0') {
                break;
            }
            tmp = Long.valueOf(chr[i] - '0') + tmp * 10;
            if (tmp * flag > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (tmp * flag< Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            result= tmp.intValue() * flag;
        }
        return result;
    }
}
