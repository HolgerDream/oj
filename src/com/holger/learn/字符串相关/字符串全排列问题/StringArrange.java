package com.holger.learn.字符串相关.字符串全排列问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holger
 * @date 2019/5/5
 */
public class StringArrange {
    /**
     * 递归方式求全排列问题,首先取第一个，然后再排列后面的字符
     * @param s
     */
    public static String[] arrangeRecursive(String s){
        char[] arrayA = s.toCharArray();
        List<String> list = new ArrayList<>();
        recursionArrange(list,arrayA,0,arrayA.length-1);
        return list.toArray(new String[list.size()]);
    }
    public static void recursionArrange(List<String> res, char[] arrayA, int start, int end){
        if(end <= 1){
            return;
        }
        //递归结束条件
        if(start == end){
            String tmp = "";
            for(int i = 0;i < arrayA.length;i++){
                tmp += arrayA[i];
            }
            res.add(tmp);
        }
        else{
            //遍历当前数组，选出第一个元素，然后递归后面的数组
            for(int i = start;i <= end;i++){
                //选出第一个字符
                swap(arrayA,i,start);
                recursionArrange(res, arrayA,start+1,end);
                //还原数组
                swap(arrayA,i,start);
            }
        }
    }
    /**
     * 交换数组m位置和n位置上的值
     *
     */
    public static void swap(char[] arrayA, int m, int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    /**
     * 字典序的方式求排列问题
     * @param str
     */
    public static String[] arrangeDictionary(String str){
        char[] s = str.toCharArray();
        List<String> list = new ArrayList<>();
        list.add(str);
        boolean isEnd = false;
        /*如果有找到可交换的位置，则可以进行下一次；否则完成全排序*/
        while(!isEnd){
            int[] fromAndToIndex = getSwapFromAndToIndex(s);
            if(fromAndToIndex != null){
                swapChar(s,fromAndToIndex[1],fromAndToIndex[0]);
                //反转from右边的数，即右边的数从小到大排序
                revertStr(s,fromAndToIndex[0]+1);
                list.add(new String(s));
            }else{
                isEnd = true;
            }
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * 获得字符串序列中两个交换位置，这两个位置上的数交换后，可以增大该字符串序列。
     * 这里获得的就是能最小增大的两个交换位置。
     * 例如：1342，那么找两个位置上的数交换后能让他增大。
     * 那基础位置就可以从倒数第二个数开始，然后从基础位置往后找，<br/>
     * 若找到比基础位置上的数大的数，那此时交换两个数就能增大这个序列。
     * 并且要找到比基础位置上的数大并且是所有比它大的最小的数
     * @param str
     * @return 返回的int[2]数组元素。0位置元素记录交换的左边位置，1位置元素记录交换的右边位置 
     */
    static int[] getSwapFromAndToIndex(char[] str){
        //fromAndTo[0]记录基础位置
        int[] fromAndTo = new int[2];
        //基础位置
        int basis = str.length - 2;
        //可交换位置
        int afterBasis = basis + 1;
        fromAndTo[1] = -1;
        while(basis >= 0){
            //查看位置能否交换，原则是前面小于后面
            if(str[basis] < str[afterBasis]){
                //找到最小的一个值来交换
                if(fromAndTo[1] < 0 || (fromAndTo[1] > 0 && str[fromAndTo[1]] > str[afterBasis])){
                    fromAndTo[1] = afterBasis;
                }
            }
            //向后寻找
            if(++afterBasis > str.length - 1){
                //判断后值是否已经到结尾
                if(fromAndTo[1] < 0){
                    //未找到后值
                    basis--;
                    //重置后值
                    afterBasis = basis + 1;
                    fromAndTo[1] = -1;
                }else{
                    //已经找到后值就与前值交换
                    fromAndTo[0] = basis;
                    return fromAndTo;
                }
            }
        }
        return null;
    }

    static void swapChar(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /**反转。把字符数组从from位置开始后的数反转*/
    static void revertStr(char[] str, int from){
        if(str.length - from <= 1){
            return;
        }
        for(int i = from; i < (str.length + from)/2;i++){
            swapChar(str,i,str.length - 1 -(i - from));
        }
    }
    
}
