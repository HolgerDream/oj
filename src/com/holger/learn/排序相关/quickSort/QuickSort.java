package com.holger.learn.排序相关.quickSort;

/**
 * @author Holger
 * @date 2019/4/26
 */
public class QuickSort {
    /**
     * 快排的核心思想就是首先设置一个哨兵，然后根据哨兵的大小划分小值区和大值区，然后再分别递归小值区和大值区
     * @param a
     * @param low
     * @param high
     */
    public static void quickSort(int[] a,int low, int high){
        //左边界
        int l = low;
        //右边界
        int h = high;
        int sentinel = a[low];
        
        while(l < h){
            //首先从high指针网low指针扫描，如果大的话扫描下一个
            while(l < h && a[h] >= sentinel){
                h--;
            }
            //直道扫描到一个a[h] < sentinel，则将a[h] 凡在a[l]的位置上
            //low++
            if (l < h) {
                a[l] = a[h];
                l++;
            }
            //开始从low往high扫描，如果小于则扫描下一个
            while(l < h && a[l] <= sentinel){
                l++;
            }
            //发现当前值大于哨兵，则将a[l]放在a[h]上面
            //h--
            if (l < h) {
                a[h] = a[l];
                h--;
            }
        }
        
        //排序左边,判断是否指针重合
        if(l -1 > low){
            quickSort(a,low, l -1);
        }
        //排序右边,判断是否指针重合
        if(l + 1 < high){
            quickSort(a,l+1, high);
        }
    }
}
