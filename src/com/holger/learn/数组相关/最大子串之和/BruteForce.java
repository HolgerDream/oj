package com.holger.learn.数组相关.最大子串之和;

/**
 * @author Holger
 * @date 2019/4/23
 */
public class BruteForce {
    /**
     * 暴力算法的核心思想就是暴力枚举每一种情况，然后取子串和与暂存的max比较
     * 时间复杂度为O(n³)
     * @param a
     * @return
     */
    public static int maxSbuSum(int[] a){
        int sum = 0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                int temp = 0;
                for (int k = i; k < j; k++) {
                    temp+=a[k];
                }
                if(temp > sum){
                    sum = temp;
                }
            }
        }
        return sum;
    }
    
}
