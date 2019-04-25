package com.holger.learn.最大子串之和;

/**
 * @author Holger
 * @date 2019/4/23
 */
public class Solution {
    public static void main(String[] args) {
        int[] test = {1,2,-1,3,-2,5,3,-7};
        //测试暴力算法
        System.out.println("暴力法输出结果："+BruteForce.maxSbuSum(test));
        //测试分治法
        System.out.println("分治法输出结果："+DivideConquer.maxSbuSum(test,0,test.length -1));
        //动态规划法
        System.out.println("分治法输出结果：");
        
    }
}
