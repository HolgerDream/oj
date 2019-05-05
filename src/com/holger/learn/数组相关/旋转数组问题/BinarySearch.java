package com.holger.learn.数组相关.旋转数组问题;

/**
 * @author Holger
 * @date 2019/4/25
 */
public class BinarySearch {
    /**
     * 二分查找法的关键逻辑在于因为数组本身是两段有序的数组，那么只要确定中间的位置是在大数组里面还是小数组里面即可
     * a[mid] <= a[length - 1]
     * 此问题需要考虑重复数据
     *
     * @param array
     * @return
     */
    public static Integer BinarySearch(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            int middle = low + (high - low)/2;
            //如果中间值大于最后小数组的最大值，则数组范围缩小至后半部分
            //中间值如果等于最后小数组的最大值，则数组范围缩小n-1
            //如果中间值小于最后的小数组的最大值，则数组范围缩小至前半部分
            if(array[middle] > array[high]){
                low = middle + 1;
            }else if(array[middle] == array[high]){
                high = high - 1;
            }else{
                high = middle;
            }
        }
        return array[low];
    }
}
