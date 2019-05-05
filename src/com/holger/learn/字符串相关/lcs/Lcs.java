package com.holger.learn.字符串相关.lcs;

import java.util.Stack;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class Lcs {
    /**
     *         Array(i,j) = 0;                                          当i=0或者j=0;
     *
     *         Array(i,j) = Array(i-1,j-1);                        当i>0,j>0 && Xi==Yj;
     *
     *         Array(i,j) = max{Array(i-1,j),Array(i,j-1)}         当i>0,j>0 && Xi!=Yj
     * @param x
     * @param y
     * @return
     */
    public static String getLCS(String x, String y) {
        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        if(x == null || x.isEmpty()){
            return "";
        }
        if(y == null || y.isEmpty()){
            return "";
        }
        //此处的棋盘长度要比字符串长度多加1，需要多存储一行0和一列0
        int[][] array = new int[x.length() + 1][y.length() + 1];
        //第0行第j列全部赋值为0
        for (int j = 0; j < array[0].length; j++) {
            array[0][j] = 0;
        }
        //第i行，第0列全部为0
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 0;
        }
        //利用动态规划将数组赋满值
        for (int m = 1; m < array.length; m++) {
            for (int n = 1; n < array[m].length; n++) {
                if (s1[m - 1] == s2[n - 1]) {
                    //动态规划公式一
                    array[m][n] = array[m - 1][n - 1] + 1;
                } else {
                    //动态规划公式二
                    array[m][n] = max(array[m - 1][n], array[m][n - 1]);
                }
            }
        }

        Stack stack = new Stack();
        int i = x.length() - 1;
        int j = y.length() - 1;

        while ((i >= 0) && (j >= 0)) {
            //字符串从后开始遍历，如若相等，则存入栈中
            if (s1[i] == s2[j]) {
                stack.push(s1[i]);
                i--;
                j--;
            } else {
                //如果字符串的字符不同，则在数组中找相同的字符，
                // 注意：数组的行列要比字符串中字符的个数大1，因此i和j要各加1
                if (array[i + 1][j] > array[i][j + 1]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        //打印输出栈正好是正向输出最大的公共子序列
        String res ="";
        while (!stack.isEmpty()) {
            res +=stack.pop();
        }
        return res;
        /*String res = "";
        boolean flag = true;
        int j = 1;
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            while (flag && j < array[i].length){
                if(count < array[i][j]){
                    res += s2[j - 1];
                    count = array[i][j];
                    flag =false;
                }
                j++;
            }
            flag = true;
            j = 1;
        }
        return res;*/
    }

    public static int max(int a, int b) {//比较(a,b)，输出大的值
        return (a > b) ? a : b;
    }

}
