package com.holger.leetcode.P06字形变换;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holger
 * @date 2019/1/18
 */
public class Solution {
    public static String convert(String s, int numRows) {
        //判断异常输入
        if (s == null || s.isEmpty() || numRows < 2) {
            return s;
        }
        //计算所需要的表格大小
        char[][] text = new char[numRows][s.length()/2];
        int row = 0, col = 0;
        //如果flag为0 则向下填充，为1则向上填充
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            text[row][col] = s.charAt(i);
            if(flag == 0){
                row++;
            }else{
                row--;
                col++;
            }
            if(row == numRows - 1){
                flag = 1;
            }
            if(row == 0){
                flag = 0;
            }
        }
        String str="";
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < text[i].length; j++) {
                if(text[i][j] !=0){
                    str +=text[i][j];
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",55));
        System.out.println(convert2("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",55));
    }

    public static String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
