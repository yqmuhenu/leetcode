package com.exam.rank4.exercise1;

import sun.dc.pr.PRError;

import java.util.*;

public class Exercise {

    /**
     * 1. 两数之和
     * 难度
     * 简单
     *
     * 12694
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     *
     * 通过次数2,710,055提交次数5,192,936
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[] {numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 6. Z 字形变换
     * 难度
     * 中等
     *
     * 1371
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
     * 通过次数325,290提交次数639,707
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
        StringBuilder[] charStrArr = new StringBuilder[rowCount];
        for (int i = 0; i < s.length(); i++) {
            int rowNum = getRowNum(numRows, i);
            if (null == charStrArr[rowNum - 1]) {
                charStrArr[rowNum - 1] = new StringBuilder();
            }
            charStrArr[rowNum - 1].append(s.charAt(i));
        }
        for (int i = 1; i < rowCount; i++) {
            charStrArr[0].append(charStrArr[i]);
        }
        return charStrArr[0].toString();
    }

    private int getRowNum(int numRows, int charIndex) {
        int modeSum = (numRows - 1) * 2;
        // TODO 注意 modeSum为0的情况
        int modeNum = (charIndex + 1) % modeSum;
        if (0 == modeNum) {
            return 2;
        }
        if (numRows < modeNum) {
            return numRows * 2 - modeNum;
        }
        return modeNum;
    }

    /**
     * 13. 罗马数字转整数
     * 难度
     * 简单
     *
     * 1582
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "III"
     * 输出: 3
     * 示例 2:
     *
     * 输入: s = "IV"
     * 输出: 4
     * 示例 3:
     *
     * 输入: s = "IX"
     * 输出: 9
     * 示例 4:
     *
     * 输入: s = "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     *
     * 输入: s = "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
     * 通过次数499,140提交次数791,385
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
//        字符          数值
//        * I             1
//        * V             5
//        * X             10
//        * L             50
//        * C             100
//        * D             500
//        * M             1000
        Map<Character, Integer> romanNumMap = new HashMap<>();
        romanNumMap.put('I', 1);
        romanNumMap.put('V', 5);
        romanNumMap.put('X', 10);
        romanNumMap.put('L', 50);
        romanNumMap.put('C', 100);

        romanNumMap.put('D', 500);
        romanNumMap.put('M', 1000);

        int lastNum = romanNumMap.get(s.charAt(0));
        int sum = lastNum;
        for (int i = 1; i < s.length(); i++) {
            int currNum = romanNumMap.get(s.charAt(i));
            if (currNum > lastNum) {
                sum -= lastNum * 2;
            }
            sum += currNum;
            lastNum = currNum;
        }
        return  sum;
    }

    /**
     * 22. 括号生成
     * 难度
     * 中等
     *
     * 2170
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     *
     * 提示：
     *
     * 1 <= n <= 8
     * 通过次数380,256提交次数492,062
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> pStrList = new ArrayList<>();
        generateParenthesis(pStrList, n, "(", 1);
        return pStrList;
    }

    private void generateParenthesis(List<String> pStrList, int n, String currPStr, int leftPNum) {
        if (leftPNum == n) {
            StringBuilder pStr = new StringBuilder(currPStr);
            for (int i = 0; i < n * 2 - currPStr.length(); i++) {
                pStr.append(")");
            }
            pStrList.add(pStr.toString());
            return;
        }
        generateParenthesis(pStrList, n, currPStr + "(", leftPNum + 1);
        if (leftPNum * 2 > currPStr.length()) {
            generateParenthesis(pStrList, n, currPStr + ")", leftPNum);
        }
    }

    /**
     * 39. 组合总和
     * 难度
     * 中等
     *
     * 1636
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
     *
     * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
     *
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     *
     *
     *
     * 示例 1：
     *
     * 输入: candidates = [2,3,6,7], target = 7
     * 输出: [[7],[2,2,3]]
     * 示例 2：
     *
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     *
     * 输入: candidates = [2], target = 1
     * 输出: []
     * 示例 4：
     *
     * 输入: candidates = [1], target = 1
     * 输出: [[1]]
     * 示例 5：
     *
     * 输入: candidates = [1], target = 2
     * 输出: [[1,1]]
     *
     *
     * 提示：
     *
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     * 通过次数364,390提交次数500,900
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // TODO 不要忘记排序
        Arrays.sort(candidates);
        List<List<Integer>> combinationSum = new ArrayList<>();
        addCombinationNum(candidates, target, null, combinationSum);
        return combinationSum;
    }

    private void addCombinationNum(int[]candidates, int target, List<Integer> currCombinationNum,
                                   List<List<Integer>> combinationSum) {
        if (0 == target) {
            List<Integer> newCombinationNum = new ArrayList<>();
            newCombinationNum.addAll(currCombinationNum);
            combinationSum.add(newCombinationNum);
            return;
        }
        for (int candidate : candidates) {
            if (null != currCombinationNum && candidate < currCombinationNum.get(currCombinationNum.size() - 1)) {
                continue;
            }
            if (candidate > target) {
                return;
            }
            List<Integer> newCombinationNum = new ArrayList<>();
            if (null != currCombinationNum) {
                newCombinationNum.addAll(currCombinationNum);
            }
            newCombinationNum.add(candidate);
            addCombinationNum(candidates, target - candidate, newCombinationNum, combinationSum);
        }
    }

    /**
     * 55. 跳跃游戏
     * 难度
     * 中等
     *
     * 1505
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     *
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     * 通过次数358,350提交次数826,855
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int rightMoveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightMoveIndex) {
                break;
            }
            rightMoveIndex = Math.max(rightMoveIndex, nums[i] + i);
            if (rightMoveIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 67. 二进制求和
     * 难度
     * 简单
     *
     * 705
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     *
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     *
     * 提示：
     *
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     * 通过次数206,280提交次数380,978
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int numLen = Math.max(a.length(), b.length());
        StringBuilder numStr = new StringBuilder();
        int numArr = 0;
        for (int i = 0; i < numLen; i++) {
            int numA = a.length() <= i ? 0 : a.charAt(a.length() - 1 - i) - '0';
            int numB = b.length() <= i ? 0 : b.charAt(b.length() - 1 - i) - '0';
            numStr.append((numA + numB + numArr) & 1);
            numArr = (numA + numB + numArr) >> 1;
        }
        if (0 != numArr) {
            numStr.append(1);
        }
        return numStr.reverse().toString();
    }

    /**
     * 70. 爬楼梯
     * 难度
     * 简单
     *
     * 2029
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * 示例 1：
     *
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     *
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * 通过次数623,651提交次数1,172,926
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1, n2 = 2;
        int tempNum = 3;
        while (tempNum++ < n) {
            int temp = n2;
            n2 += n1;
            n1 = temp;
        }
        return n1 + n2;
    }

    /**
     * 239. 滑动窗口最大值
     * 难度
     * 困难
     *
     * 1271
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 示例 3：
     *
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     * 示例 4：
     *
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     * 示例 5：
     *
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     * 通过次数209,139提交次数421,024
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            // TODO 不要忘记用while
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
