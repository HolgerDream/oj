package com.holger.hdoj;

import java.util.Scanner;

/**
 * Created by Holger on 2018/4/12.
 */
public class P1003 {
    public static void main(String args[]) {
        /**
         * 此题目的是求取子串之和，而子串是按步递进的。也就是说不是求子集
         * 如果中间有一个特别大的负数，也就意味着前面的sum作废
         *
         */
        Scanner scanner = new Scanner(System.in);
        int num;
        int row = scanner.nextInt();
        int max;
        int sum;
        for (int i = 0; i < row; i++) {
            num = scanner.nextInt();
            max = Integer.MIN_VALUE;
            sum = 0;
            //start 是用来记录子串的开始位置，
            //z是一个下标，用来重新确定子串开始位置
            int start = 0, end = 0, z = 0;
            for (int j = 0; j < num; j++) {
                int a = scanner.nextInt();
                //求和
                sum = sum + a;
                //判断是否增大，增大则记录子串的结束地址
                if (max < sum) {
                    max = sum;
                    end = j;
                    start = z;
                }
                //中间出现特别大的负数，则子串从头在求和
                if (sum < 0) {
                    sum = 0;
                    z = j + 1;
                }
            }
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(max + " " + (start + 1) + " " + (end + 1));
            if (i < row - 1) {
                System.out.println();
            }
        }
    }
}
