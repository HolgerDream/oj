package com.holger.leetcode.P04寻找中位数;

import java.util.Arrays;

/**
 * @author Holger
 * @date 2019/1/17
 */
public class Solution {
    public static double findMedianSortedArrays(int[] A, int[] B) {
	int m = A.length;
	int n = B.length;
	if (m > n) { // to ensure m<=n
	    int[] temp = A; A = B; B = temp;
	    int tmp = m; m = n; n = tmp;
	}
	//(5+1)/2 =3 (4+1)/2 = 2 所以直接算出中间值，不用写判断
	int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
	while (iMin <= iMax) {
	    int i = (iMin + iMax) / 2;
	    int j = halfLen - i;
	    if (i < iMax && B[j-1] > A[i]){
		iMin = i + 1; // i is too small
	    }
	    else if (i > iMin && A[i-1] > B[j]) {
		iMax = i - 1; // i is too big
	    }
	    else { // i is perfect
		int maxLeft = 0;
		if (i == 0) { maxLeft = B[j-1]; }
		else if (j == 0) { maxLeft = A[i-1]; }
		else { maxLeft = Math.max(A[i-1], B[j-1]); }
		if ( (m + n) % 2 == 1 ) { return maxLeft; }

		int minRight = 0;
		if (i == m) { minRight = B[j]; }
		else if (j == n) { minRight = A[i]; }
		else { minRight = Math.min(B[j], A[i]); }

		return (maxLeft + minRight) / 2.0;
	    }
	}
	return 0.0;
    }

    public static void main(String[] args) {
	int[] sum1 = {1,3};
	int[] sum2 = {2,};
	System.out.println(Solution2.findMedianSortedArrays(sum1, sum2));
	System.currentTimeMillis();
    }
}
class Solution2 {
    /**
     * 利用快排思想求出中间值，然后根据奇偶性判断后面的数字
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays(int[] A, int[] B){
        int start = A.length;
	A = Arrays.copyOf(A, A.length + B.length);
	System.arraycopy(B, 0, A, start, B.length);
	Arrays.sort(A);
	if(A.length == 1){
	    return A[0];
	}
	if(A.length %2 ==0){
	    return ((double) A[A.length/2] + (double) A[A.length/2 - 1])/2;
	}else{
	    return  A[(A.length+1)/2 -1];
	}
    }
}