package com.holger.learn.字符串相关.字符串左移问题;

/**
 * @author Holger
 * @date 2019/5/7
 */
public class SwapMoving {
    /**
     * 核心原理就是(x'y')' = yx
     * @param str
     * @return
     */
    public static String swapMoving(String str,int i){
        char[] array = str.toCharArray();
        swap(array,0,i - 1);
        swap(array,i,array.length -1);
        swap(array,0,array.length -1);
        return new String(array);
    }
    
    private static void swap(char[] array,int from, int to){
        while (from<to){
            char s = array[from];
            array[from++] = array[to];
            array[to--] = s;
            //from++;
            //to--;
        }
    }
}
