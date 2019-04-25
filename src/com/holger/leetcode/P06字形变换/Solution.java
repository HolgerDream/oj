package com.holger.leetcode.P06字形变换;

/**
 * @author Holger
 * @date 2019/1/18
 */
public class Solution {
    public String convert(String s, int numRows) {
        //判断异常输入
	if(s == null || s.isEmpty() || numRows < 2){
	    return s;
	}
	//计算所需要的表格大小
	int scol = s.length() / (numRows + numRows -2) + 1;
	String[][] text = new String[numRows][scol * 2];
	int row = 0,col = 0;
	for(int i =0; i < s.length(); i++){
	    
	}
	return "";
    }
}
