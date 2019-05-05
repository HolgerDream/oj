package com.holger.learn.字符串相关.lcs;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class Main {

    public static void main(String[] args) {
        String x = "BDCABA";
        String y = "ABCBDAB";
        System.out.println(Lcs.getLCS(x,y));
        System.out.println(MyLcs.getLCS(x,y));
    }
}
