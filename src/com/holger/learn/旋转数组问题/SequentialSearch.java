package com.holger.learn.旋转数组问题;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class SequentialSearch {
    /**
     * 顺序查找的核心思想按照O(n)的时间复杂度轮询整个数组
     * @param a
     * @return
     */
    public static Integer sequsentialSearch(int[] a){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }
    
}
