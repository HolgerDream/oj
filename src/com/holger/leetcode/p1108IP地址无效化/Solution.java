package com.holger.leetcode.p1108IP地址无效化;

/**
 * @author Holger
 * @date 2019/7/12
 */
class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[\\.]");
    }
}