package com.holger;

/**
 * @author Holger
 * @date 2019/4/22
 */
public class Test {
    public static void main(String[] args) {
        int[] test = {1,2,-1,3,-8,5,3,-7};
        
        int res = test[0];
        int sum = test[0];
        for (int i = 1; i <test.length; i++) {
            if(sum > 0){
                sum +=test[i];
            }else {
                sum = test[i];
            }
            if(sum > res){
                res = sum;
            }
        }
        System.out.println(res);
    }
}
