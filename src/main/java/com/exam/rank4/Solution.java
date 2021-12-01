package com.exam.rank4;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    /**
     * 423. 从英文中重建数字
     * 难度
     * 中等
     *
     * 158
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "owoztneoer"
     * 输出："012"
     * 示例 2：
     *
     * 输入：s = "fviefuro"
     * 输出："45"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 105
     * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
     * s 保证是一个符合题目要求的字符串
     * 通过次数29,595提交次数48,411
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/solution/cong-ying-wen-zhong-zhong-jian-shu-zi-by-9g1r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/solution/cong-ying-wen-zhong-zhong-jian-shu-zi-by-9g1r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public String originalDigits(String s) {
//        字母	数字
//        * e	0 1 3 5 7 8 9
//        * f	4 5
//        * g	8
//        * h	3 8
//        * i	5 6 8 9
//        * n	1 7 9
//        * o	0 1 2 4
//        * r	0 3 4
//        * s	6 7
//        * t	2 3 8
//        * u	4
//        * v	5 7
//        * w	2
//        * x	6
//        * z	0
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            charMap.put(currChar, charMap.getOrDefault(currChar, 0) + 1);
        }
        int[] num = new int[10];
        num[0] = charMap.getOrDefault('z', 0);
        num[6] = charMap.getOrDefault('x', 0);
        num[7] = charMap.getOrDefault('s', 0) - num[6];
        num[5] = charMap.getOrDefault('v', 0) - num[7];
        num[2] = charMap.getOrDefault('w', 0);
        num[4] = charMap.getOrDefault('u', 0);
        num[8] = charMap.getOrDefault('g', 0);
        num[3] = charMap.getOrDefault('h', 0) - num[8];
        num[1] = charMap.getOrDefault('o', 0) - num[0] - num[2] - num[4];
        num[9] = charMap.getOrDefault('n', 0) - num[1] - num[7];
        num[9] /= 2;
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (0 == num[i]) {
                continue;
            }
            for (int j = 0; j < num[i]; j++) {
                numStr.append(i);
            }
        }
        return numStr.toString();
    }

    /**
     * 6. Z 字形变换
     * 难度
     * 中等
     *
     * 1370
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     * 通过次数324,880提交次数638,878
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int rowCount = Math.min(numRows, s.length());
        if (1 == rowCount) {
            return s;
        }
        StringBuilder[] strArr = new StringBuilder[rowCount];
        for (int i = 0; i < s.length(); i++) {
            int rowNum = getRowNum(numRows, i);
            if (null == strArr[rowNum - 1]) {
                strArr[rowNum - 1] = new StringBuilder();
            }
            strArr[rowNum - 1].append(s.charAt(i));
        }
        for (int i = 1; i < rowCount; i++) {
            strArr[0].append(strArr[i]);
        }
        return strArr[0].toString();
    }

    private int getRowNum(int numRows, int charIndex) {
        int modeSum = (numRows - 1) * 2;
        int modeNum = (charIndex + 1) % modeSum;
        if (0 == modeNum) {
            return 2;
        }
        if (modeNum > numRows) {
            return numRows * 2 - modeNum;
        }
        return modeNum;
    }

    /**
     * . 两数之和
     * 难度
     * 简单
     * <p>
     * 12682
     * <p>
     * 收藏
     * <p>
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 239. 滑动窗口最大值
     * 难度
     * 困难
     * <p>
     * 1263
     * <p>
     * 收藏
     * <p>
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     * <p>
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 示例 3：
     * <p>
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     * 示例 4：
     * <p>
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     * 示例 5：
     * <p>
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口队列
        Deque<Integer> numsDequeue = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!numsDequeue.isEmpty() && nums[i] >= nums[numsDequeue.peekLast()]) {
                numsDequeue.pollLast();
            }
            numsDequeue.offerLast(i);
        }
        // 数组长度
        int len = nums.length;
        // 滑动窗口最大值数组
        int[] ans = new int[len - k + 1];
        ans[0] = nums[numsDequeue.peekFirst()];
        // 滑动窗口移动
        for (int i = k; i < len; i++) {
            // 移除窗口中间较小元素
            while (!numsDequeue.isEmpty() && nums[i] >= nums[numsDequeue.peekLast()]) {
                numsDequeue.pollLast();
            }
            // 窗口添加元素
            numsDequeue.offerLast(i);
            // 移除窗口外元素
            while (numsDequeue.peekFirst() < i - k + 1) {
                numsDequeue.pollFirst();
            }
            // 记录当前窗口最大值
            ans[i - k + 1] = nums[numsDequeue.peekFirst()];
        }

        return ans;
    }

    /**
     * 70. 爬楼梯
     * 难度
     * 简单
     * <p>
     * 2022
     * <p>
     * 收藏
     * <p>
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n_1 = 1, n_2 = 2;
        int tempIndex = 3;
        while (tempIndex < n) {
            int tempN = n_2;
            n_2 += n_1;
            n_1 = tempN;
        }

        return n_1 + n_2;
    }

    /**
     * 67. 二进制求和
     * 难度
     * 简单
     * <p>
     * 704
     * <p>
     * 收藏
     * <p>
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * <p>
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     * 通过次数205,539提交次数379,557
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        long aNum = strToNum(a);
        long bNum = strToNum(b);
        while (bNum != 0) {
            long sum = aNum ^ bNum;
            bNum = (aNum & bNum) << 1;
            aNum = sum;
        }
        return numToStr(aNum);
    }

    private long strToNum(String numStr) {
        char[] numsChar = numStr.toCharArray();
        long num = 0;
        for (int i = 0; i < numsChar.length; i++) {
            num = num * 2 + numsChar[i];
        }
        return num;
    }

    private String numToStr(long num) {
        StringBuilder strSb = new StringBuilder();
        while (num != 0) {
            strSb.append(num & 1);
        }
        return strSb.reverse().toString();
    }
}
