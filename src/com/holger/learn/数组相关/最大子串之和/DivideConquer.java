package com.holger.learn.数组相关.最大子串之和;

/**
 * @author Holger
 * @date 2019/4/23
 */
public class DivideConquer {
    /**
     * 分治算法最核心的思想就是递归，缩小问题规模.
     * 在此问题中有三种情况
     * 1、最大串之和在middle前半区
     * 2、最大串之和在middle后半区
     * 3、最大串横跨middle，则最大子串之和等于middle向前寻找的最大子串+middle向后寻找的最大子串
     * @param a
     * @return
     */
    public static int maxSbuSum(int[] a,int from, int to) {
        int middle = (from + to)/2;
        if(from == to){
            return a[middle];
        }
        //最大串和在前半区
        int sleft = maxSbuSum(a,from ,middle);
        int sright = maxSbuSum(a,middle + 1 ,to);
        
        int smiddle =0;
        int mLeftSum = 0,mRightSum = 0,leftTmp =0,rightTmp=0;
        //前半区从middle寻找最大的子串
        for (int i = middle; i >=from; i--) {
            mLeftSum += a[i];
            if(mLeftSum > leftTmp){
                leftTmp =mLeftSum;
            }
        }
        //后半区从middle寻找最大的子串
        for (int j = middle + 1; j <=to; j++) {
            mRightSum += a[j];
            if(mRightSum > rightTmp){
                rightTmp =mRightSum;
            }
        }
        smiddle = rightTmp + leftTmp;
        
        return Math.max(Math.max(sleft,sright),smiddle);
    }
}
