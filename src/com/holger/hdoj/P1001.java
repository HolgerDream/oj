package com.holger.hdoj;

import java.util.Scanner;

/**
 * Created by Holger on 2018/4/11.
 */
public class P1001 {
    //public class Main {
    public static void main(String[] agrs) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLong()) {
            Long n = s.nextLong();
            System.out.println((1 + n) * n / 2);
            System.out.println();
        }
    }
}
