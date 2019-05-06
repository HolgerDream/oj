package com.holger.learn.字符串相关.字符串全排列问题;

import java.util.Arrays;

/**
 * @author Holger
 * @date 2019/5/5
 */
public class Main {
    public static void main(String[] args) {
        String test = "1432";
        System.out.println(Arrays.toString(StringArrange.arrangeRecursive(test)));
        System.out.println(Arrays.toString(StringArrange.arrangeDictionary(test)));
    }
}
