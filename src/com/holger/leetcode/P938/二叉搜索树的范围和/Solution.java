package com.holger.leetcode.P938.二叉搜索树的范围和;


import com.holger.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author Holger
 * @date 2019/7/12
 */
public class Solution {
    /**
     * 利用栈的先进后出的特性暂存未遍历的节点
     * 递归的原理也是代码的堆栈执行的特点
     * @param root 根节点
     * @param L    左边的值的范围
     * @param R    右边的值的范围
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            // 先右后左，保证左子树先遍历
            if(node.val < L){
                stack.push(node.right);
            }else if(node.val > R){
                stack.push(node.left);
            }else{
                sum += node.val;
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sum;
    }

    /**
     * 因为根据二叉树的特性有==> left < parent < right
     * 此判断会根绝特性自动过滤掉不需要遍历的子节点,节约时间
     * 当前节点为 null 时返回 0
     * 当前节点 X < L 时则返回右子树之和
     * 当前节点 X > R 时则返回左子树之和
     * 当前节点 X >= L 且 X <= R 时则返回：当前节点值 + 左子树之和 + 右子树之和
     * @param root root节点
     * @param L 左边节点的范围
     * @param R 右边节点的范围
     * @return
     */
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
