package com.holger.learn.零和数组问题;

import java.util.Arrays;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class Main {
    public static void main(String[] args) {
        int[] test ={-3, 1, 1, -3, 5};
        System.out.println(Arrays.toString(ZeroSum.subarraySumClosest(test)));
    }
}
