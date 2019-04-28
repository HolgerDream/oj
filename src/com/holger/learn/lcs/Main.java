package com.holger.learn.lcs;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class Main {

    public static void main(String[] args) {
        String x = "BDCABA";
        String y = "ABCBDAB";
        System.out.println(Lcs.getLCS(x,y));
    }
}
