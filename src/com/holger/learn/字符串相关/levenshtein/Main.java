package com.holger.learn.字符串相关.levenshtein;

/**
 * @author Holger
 * @date 2019/5/5
 */
public class Main {
    /**
     * 字符串距离问题
     * @param args
     */
    public static void main(String[] args) {
        String start ="abcdefgh";
        String end ="adgcf";
        System.out.println(Levenshtein.levenshtein(start,end));
    }
}
