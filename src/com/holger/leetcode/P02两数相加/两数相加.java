package com.holger.leetcode.P02两数相加;

import java.math.BigDecimal;

/**
 * @author Holger
 * @date 2018/11/20
 */

 class ListNode { 
     int val;
     ListNode next;
      ListNode(int x) { val = x; }

    @Override 
    public String toString() {
          if(next != null){
	      return val + " -> " + next.toString() ;
	  }else{
	      return String.valueOf(val);
	  }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l1.next == null && l2.val == 0 && l2.next == null){
            return new ListNode(0);
	}
	BigDecimal sum = getValue(l1).add(getValue(l2));
	return setValue(sum);
    }
    
    public BigDecimal getValue(ListNode node){
	int i = 0;
	BigDecimal v1 = new BigDecimal(0);
	while(node.next != null){
	    v1 = v1.add(new BigDecimal(node.val).multiply(new BigDecimal(10).pow(i)));
	    node = node.next;
	    i++;
	}
	v1 = v1.add(new BigDecimal(node.val).multiply(new BigDecimal(10).pow(i)));
	return v1;
    }

    public ListNode setValue(BigDecimal sum){
        //取模运算
        ListNode node = new ListNode(sum.divideAndRemainder(new BigDecimal(10))[1].intValue());
	ListNode temp = node;
        sum = sum.divide(new BigDecimal(10)).setScale(0,BigDecimal.ROUND_DOWN);
        while (!sum.toString().equals("0")){
	    temp.next=new ListNode(new Long(sum.divideAndRemainder(new BigDecimal(10))[1].intValue()).intValue());
	    //类似int的/操作，因为BigDecimal除法会有小数
	    sum = sum.divide(new BigDecimal(10)).setScale(0,BigDecimal.ROUND_DOWN);
	    temp = temp.next;
	}
        return node;
    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	if(l1.val == 0 && l1.next == null && l2.val == 0 && l2.next == null){
	    return new ListNode(0);
	}
	ListNode sum = new ListNode(0);
	ListNode temp =sum;
	int carry = 0;
	while(l1 != null || l2 != null){
	    int val1 = l1 == null? 0: l1.val;
	    int val2 = l2 == null? 0: l2.val;
	    int s = val1 + val2 + carry;
	    //如果需要进位，则记录进位的值的大小
	    if(s >= 10){
		temp.val = s % 10 ;
		carry = s / 10;
	    }else{
		temp.val = s;
		carry = 0;
	    }
	    //只有有数据未遍历完，或者遍历完有进位产生时才会新建下一位
	    if((l1 != null && l1.next != null) || (l2 != null && l2.next != null)){
		temp.next = new ListNode(0);
		temp = temp.next;
	    } else {
	        if(carry > 0){
		    temp.next = new ListNode(carry); 
		}
	    }
	    if(l1 != null){
		l1 = l1.next;
	    }
	    if(l2 != null){
		l2 = l2.next;
	    }
	    
	}
	return sum;
    }
}

class SolutionMain{
    public static void main(String[] args) {
        Solution s = new Solution();
	Solution2 s2 = new Solution2();
        ListNode nodea = s.setValue(new BigDecimal(924354678));
        ListNode nodeb = s.setValue(new BigDecimal(9000));
	System.out.println(s2.addTwoNumbers(nodea,nodeb).toString());

	//System.out.println(new BigDecimal(9).divide(new BigDecimal(10)).setScale(0,BigDecimal.ROUND_DOWN));
	//System.out.println(s.getValue(s.setValue(new BigDecimal(9010))));
	//System.out.println(s.addTwoNumbers(nodea,nodeb).toString());
    }
}
