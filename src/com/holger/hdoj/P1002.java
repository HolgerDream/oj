package com.holger.hdoj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Holger on 2018/4/12.
 */
public class P1002 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String temp1;
        String temp2;
        int i;
        int a = scanner.nextInt();
        for (i = 0; i < a;i++){
            temp1 = scanner.next();
            temp2 = scanner.next();
            System.out.println("Case " + (i + 1) + ":");
            System.out.println(temp1+" + "+temp2 +" = "+new BigDecimal(temp1).add(new BigDecimal(temp2)));
            if(i != a- 1){
                System.out.println();
            }
        }
    }
}
