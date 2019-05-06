package com.holger.learn.字符串相关.字符串全组合问题;

import java.util.Arrays;

/**
 * @author Holger
 * @date 2019/5/6
 */
public class Main {
    public static void main(String[] args) {
        String test = "abc";
        System.out.println(Arrays.toString(Combination.recursive(test)));
    }
}
