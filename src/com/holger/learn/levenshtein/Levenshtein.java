package com.holger.learn.levenshtein;

/**
 * @author Holger
 * @date 2019/5/5
 */
public class Levenshtein {
    /**
     * 状态转移方程:
     * edit(i, j) = min{edit(i - 1,j)+ 1, edit(i,j - 1) + 1,edit(i -1, j -1) + f(i,j)}
     * f(i,j) = s[i] == s[j]?0:1
     * @param a
     * @param b
     * @return
     */
    public static Integer levenshtein(String a, String b){
        if(a == null || b == null){
            return 0;
        }
        if(a.isEmpty()){
            return b.length();
        }
        if(b.isEmpty()){
            return a.length();
        }
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int[][] array= new int[s1.length + 1][s2.length + 1];
        //初始化动态表格
        for (int i = 0; i <array.length ; i++) {
            array[i][0] =i;
        }
        for (int i = 0; i <array[0].length ; i++) {
            array[0][i] = i;
        }
        //写入数据
        for (int i = 1; i <array.length ; i++) {
            for (int j = 1; j <array[i].length ; j++) {
                int min = Math.min(array[i -1][j] + 1,array[i][j - 1] + 1);
                if(s1[ i -1] == s2[j - 1]){
                    array[i][j] = Math.min(min,array[i -1][j - 1]);
                }else{
                    array[i][j] = Math.min(min,array[i -1][j - 1] + 1);
                }
            }
        }
        return array[s1.length][s2.length];
    }
}
