package com.holger.learn.数组相关.旋转数组问题;

/**
 * @author Holger
 * @date 2019/4/25
 */
public class Main {
    public static void main(String[] args) {
        int[] test = {4,4,5,6,7,1,2,3,4};
        System.out.println(BinarySearch.BinarySearch(test).toString());
        System.out.println(SequentialSearch.sequsentialSearch(test).toString());
        
    }
}
