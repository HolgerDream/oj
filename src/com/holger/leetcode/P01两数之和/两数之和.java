package com.holger.leetcode.P01两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetCode  P01两数之和
 * @author Holger
 * @date 2018/11/20
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
	for(int i = 0; i < nums.length; i++){
	    for(int j = i + 1; j < nums.length; j++){
		if(nums[i] + nums[j]  == target){
		    return new int[]{i,j};
		}
	    }
	}
	return new int[2];
    }
}

class Solution2{
    public int[] twoSum(int[] nums, int target) {
	Map<Integer,Integer> map = new HashMap<>();
	for(int i = 0; i < nums.length; i++){
	    if(map.get(target - nums[i]) != null){
	        return new int[]{map.get(target - nums[i]),i};
	    }else{
	        map.put(nums[i],i);
	    }
	}
        return new int[2];
    }
}

class SolutionMain{
    public static void main(String[] args) {
	int [] test = new int[]{2,7,11,15};
	int target= 9;
	System.out.println(Arrays.toString(new Solution2().twoSum(test,target)));
    }
}
