package com.holger.leetcode.P771.宝石与石头;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Holger
 * @date 2019/7/12
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        //利用hash
        char[] jarry = J.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < jarry.length; i++) {
            map.put(jarry[i], jarry[i]);
        }
        char[] sarry = S.toCharArray();
        for (int i = 0; i < sarry.length; i++) {
            if (map.get(sarry[i]) != null) {
                count++;
            }
        }
        return count;
    }
}
