package com.holger.leetcode.P06字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holger
 * @date 2019/5/7
 */
public class MySolution {
    /**
     * 因为二维数组中遍历，行是一样的，那么也就是说可以直接往下在往上走，存入对应的行即可
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        boolean down = true;
        int row = 0;
        int rc = Math.min(s.length(),numRows);
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(list.size() < rc){
                list.add(new StringBuilder());
            }
            list.get(row).append(s.charAt(i));
            if(row == 0){
                down = true;
            }
            if(row == rc -1){
                down = false;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder bu: list) {
         res.append(bu);   
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING",4));
    }
}
