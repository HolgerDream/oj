package com.holger.leetcode.P05最长回文字符串;

/**
 * @author Holger
 * @date 2019/1/18
 */
public class Solution {
    String palin = "";
    public String longestPalindrome(String s) {
	String drome = "";
        if(s.length() < 2){
	    return palin;
	}
	int max = 1;
        boolean isSave = true;
	for (int i = 0;i < s.length() - max + 1; i++){
	    String test = s.substring(i,i +max);
	    int j = 0,k = test.length() - 1;
	    //判断子字符串是否是回文字符串
	    while (j < k){
	        if (test.charAt(j) != test.charAt(k)){
		    isSave = false;
	            break;
		}
		j++;
	        k--;
	    }
	    if(isSave){
		drome = test;
		max++;
		i = -1;
	    }
	    isSave = true;
	    if(i == s.length() -max){
	        max++;
	        i = -1;
	    }
	}
	return drome;
    }

    public static void main(String[] args) {
	//System.out.println("babad".charAt("babad".length()));
	System.out.println(new Solution().longestPalindrome("ac"));	
    }
}
