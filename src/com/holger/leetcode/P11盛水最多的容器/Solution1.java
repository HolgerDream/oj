package com.holger.leetcode.P11盛水最多的容器;

/**
 * @author Holger
 * @date 2019/5/24
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j <height.length ; j++) {
                max = Math.max(max,Math.min(height[i],height[j]) * (j -1));
            }
        }
        return max;
    }
}
