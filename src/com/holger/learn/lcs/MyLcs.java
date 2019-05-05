package com.holger.learn.lcs;

/**
 * @author Holger
 * @date 2019/5/5
 */
public class MyLcs {
    /**
     * 核心思想就是缩小问题规模，写出问题的递归程式
     * 
     *      *         Array(i,j) = 0;                                          当i=0或者j=0;
     *      *
     *      *         Array(i,j) = Array(i-1,j-1);                        当i>0,j>0 && Xi==Yj;
     *      *
     *      *         Array(i,j) = max{Array(i-1,j),Array(i,j-1)}         当i>0,j>0 && Xi!=Yj
     * @param x
     * @param y
     * @return
     */
    public static String getLCS(String x, String y) {
        String res = "";
        if(x == null || x.isEmpty()){
            return res;
        }
        if(y == null || y.isEmpty()){
            return res;
        }
        
        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        //创建一个二维数组
        int array[][] = new int[s1.length + 1][s2.length + 1];
        /*//第一行放置为0
        for (int i = 0; i < array[0].length; i++) {
            array[0][i] = 0;
        }
        //第一列置为0
        for (int i = 0; i < array.length; i++) {
            array[i][0] = 0;
        }*/
        //生成表格
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if(s1[i -1] == s2[j -1]){
                    array[i][j] = array[i - 1][j - 1] + 1;
                }else{
                    array[i][j] = Math.max(array[i - 1][j],array[i][j - 1]);
                }
            }
        }
        
        //取出子序列数据
        boolean flag = true;
        int j = 1;
        //引入count暂存当前的最大值
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
        return res;
    }
}
