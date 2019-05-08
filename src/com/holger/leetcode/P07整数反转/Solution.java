package com.holger.leetcode.P07整数反转;

/**
 * @author Holger
 * @date 2019/5/7
 */
public class Solution {
    
    public static int reverse(int x) {
        String s = String.valueOf(x);
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if(!res.isEmpty() || s.charAt(i) != 0){
                res += s.charAt(i);
            }
        }
        Long r;
        if(res.charAt(res.length() - 1) == '-'){
            res = res.replace("-","");
            r = 0 - Long.valueOf(res);
        }else{
            r = Long.valueOf(res);
        }
        if(r < Integer.MIN_VALUE || r>Integer.MAX_VALUE) {
            return 0;
        }
        return r.intValue();
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
