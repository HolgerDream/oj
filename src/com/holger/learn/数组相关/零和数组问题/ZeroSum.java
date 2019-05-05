package com.holger.learn.数组相关.零和数组问题;

import java.util.Arrays;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class ZeroSum {
    /**
     * 零和数组问题的关键就是在首先求出n的前n项和，然后排序求差值，最小的那个就是所要求得的记过
     * @param nums
     * @return
     */
    public static int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        if (len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len + 1];
        //记录总体的和
        int prev = 0;
        sums[0] = new Pair(0, 0);
        //求出a[i]的前i-1项和
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        //将前i项和的结果排序
        Arrays.sort(sums,(Pair a, Pair b)-> a.sum - b.sum);
        int ans = Integer.MAX_VALUE;
        //根据sum(i) - sum(j) = sum(ij)
        //由于sum(i) =a[0]+...+a[i - 1]; 故小的index要加1
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int min = Math.min(sums[i].index - 1,sums[i - 1].index - 1);
                int max = Math.max(sums[i].index - 1,sums[i - 1].index - 1);
                res = new int[]{min+1,max};
            }
        }
        return res;
        
    }

    static class Pair {
        // value
        int sum;
        // key
        int index;
        public Pair(int s, int i) {
            sum = s;
            index = i;
        }
    }



    
}
