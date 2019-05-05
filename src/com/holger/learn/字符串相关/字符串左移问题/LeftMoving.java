package com.holger.learn.字符串相关.字符串左移问题;

/**
 * @author Holger
 * @date 2019/5/5
 */
public class LeftMoving {
    /**
     * 字符串左移问题关键就是先输出位置后的数据在输出位置之前的数据
     * @param s 偏移字符串
     * @param i 偏移位数
     * @return
     */
    public static String leftMoving(String s, int i){
        String res = "";
        if(s == null || s.isEmpty()){
            return res;
        }
        if(i == 0){
            return s;
        }
        for (int j = i; j < s.length(); j++) {
            res += s.charAt(j);
        }
        for (int j = 0; j < i; j++) {
            res += s.charAt(j);
        }
        
        return res;
    }
}
