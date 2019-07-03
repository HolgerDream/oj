package com.holger.leetcode.P11盛水最多的容器;

/**
 * @author Holger
 * @date 2019/7/3
 */
public class Solution {

    /**
     * 此解决逻辑的核心是利用双指针，求出最大面积
     * 
     * 1、水槽的高度由两板中的短板决定，每次收缩，都会导致水槽底边宽度-1，
     * 2、因此，若想找到比当前最大值更大的水槽，那么水槽的短板高必须要高于上一个水槽短板高，
     * 而只有向内移动短板，有可能达成这一条件
     * （若移动长板，下个水槽的面积一定小于当前水槽面积。
     * 因为无论下一块板子大于等于当前长版，所装的水的高度由于短板所以是一样的，
     * 但是由于向前移动了一格导致底部的宽度减少，从而导致整体的水量会减少）。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, height[i] * (j - i));
                i++;
            } else {
                res = Math.max(res, height[j] * (j - i));
                j--;
            }
        }
        return res;
    }
}
