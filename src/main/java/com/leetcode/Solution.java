package com.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.bean.TreeNode;

public class Solution {

    /**
     * 415. 字符串相加
     * 难度
     * 简单
     *
     * 469
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
     *
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
     *
     *
     *
     * 示例 1：
     *
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * 示例 2：
     *
     * 输入：num1 = "456", num2 = "77"
     * 输出："533"
     * 示例 3：
     *
     * 输入：num1 = "0", num2 = "0"
     * 输出："0"
     *
     *
     *
     *
     * 提示：
     *
     * 1 <= num1.length, num2.length <= 104
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * 通过次数158,379提交次数293,502
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder numStr = new StringBuilder();
        int numLen = Math.max(num1.length(), num2.length());
        int arrNum = 0;
        for (int i = 0; i < numLen; i++) {
            int currNum1 = i >= num1.length() ? 0 : num1.charAt(num1.length() - 1 - i) - '0';
            int currNum2 = i >= num2.length() ? 0 : num2.charAt(num2.length() - 1 - i) - '0';
            int currSum = currNum1 + currNum2 + arrNum;
            numStr.append(currSum % 10);
            arrNum = currSum / 10;
        }
        if (0 < arrNum) {
            numStr.append(1);
        }
        return numStr.reverse().toString();
    }

    /**
     * 145. 二叉树的后序遍历
     * 难度
     * 简单
     *
     * 714
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [3,2,1]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 通过次数326,769提交次数434,656
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        postorderTraversal(root, nodeList);
        return nodeList;
    }

    /**
     * 后序遍历二叉树
     *
     * @param root
     */
    private void postorderTraversal(TreeNode root, List<Integer> nodeList) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            postorderTraversal(root.left, nodeList);
        }
        if (null != root.right) {
            postorderTraversal(root.right, nodeList);
        }
        nodeList.add(root.val);
    }

    /**
     * 144. 二叉树的前序遍历
     * 难度
     * 简单
     *
     * 684
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     *
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 示例 5：
     *
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 通过次数447,878提交次数635,858
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        preorderTraversal(root, nodeList);
        return nodeList;
    }

    /**
     * 前序遍历二叉树
     *
     * @param root
     */
    private void preorderTraversal(TreeNode root, List<Integer> nodeList) {
        if (null == root) {
            return;
        }
        nodeList.add(root.val);
        if (null != root.left) {
            preorderTraversal(root.left, nodeList);
        }
        if (null != root.right) {
            preorderTraversal(root.right, nodeList);
        }
    }

    /**
     * 94. 二叉树的中序遍历
     * 难度
     * 简单
     *
     * 1179
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     *
     * 输入：root = [1,2]
     * 输出：[2,1]
     * 示例 5：
     *
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 通过次数612,818提交次数810,942
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        inorderTraversal(root, nodeList);
        return nodeList;
    }

    /**
     * 中序遍历二叉树
     *
     * @param root
     */
    private void inorderTraversal(TreeNode root, List<Integer> nodeList) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            inorderTraversal(root.left, nodeList);
        }
        nodeList.add(root.val);
        if (null != root.right) {
            inorderTraversal(root.right, nodeList);
        }
    }
}
