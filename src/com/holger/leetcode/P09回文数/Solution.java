package com.holger.leetcode.P09回文数;

/**
 * @author Holger
 * @date 2019/5/15
 */
public class Solution {
    /**
     * 首先将int转换成String
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * 此思路是取反转一半的数据与x比对，但是需要考虑到结束位为0的情况
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revent = 0;
        while (revent < x) {
            revent = revent * 10 + x % 10;
            x /= 10;
        }

        return revent == x / 10 || revent == x;
    }
}
