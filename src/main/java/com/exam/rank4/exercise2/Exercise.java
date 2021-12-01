package com.exam.rank4.exercise2;

import java.util.*;

public class Exercise {

    /**
     * 1. 两数之和
     * 难度
     * 简单
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
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int rowCount = Math.min(s.length(), numRows);
        if (1 == rowCount) {
            return s;
        }
        StringBuilder[] rowStr = new StringBuilder[rowCount];
        for (int i = 0; i < s.length(); i++) {
            int rowNum = getRowNum(numRows, i);
            if (null == rowStr[rowNum - 1]) {
                rowStr[rowNum - 1] = new StringBuilder();
            }
            rowStr[rowNum - 1].append(s.charAt(i));
        }
        for (int i = 1; i < rowCount; i++) {
            rowStr[0].append(rowStr[i]);
        }
        return rowStr[0].toString();
    }

    private int getRowNum(int numRows, int charIndex) {
        int modeSum = (numRows - 1) * 2;
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
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);

        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int lastNum = romanMap.get(s.charAt(0));
        int sum = lastNum;
        for (int i = 1; i < s.length(); i++) {
            int currNum = romanMap.get(s.charAt(i));
            if (currNum > lastNum) {
                sum -= lastNum * 2;
            }
            sum += currNum;
            lastNum = currNum;
        }
        return sum;
    }

    /**
     * 22. 括号生成
     * 难度
     * 中等
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> pList = new ArrayList<>();
        generateParenthesis(pList, n, "(", 1);
        return pList;
    }

    private void generateParenthesis(List<String> pList, int n, String currPStr, int leftPNum) {
        if (leftPNum == n) {
            StringBuilder pStr = new StringBuilder(currPStr);
            for (int i = 0; i < n * 2 - currPStr.length(); i++) {
                pStr.append(")");
            }
            pList.add(pStr.toString());
            return;
        }
        generateParenthesis(pList, n, currPStr + "(", leftPNum + 1);
        if (leftPNum * 2 != currPStr.length()) {
            generateParenthesis(pList, n, currPStr + ")", leftPNum);
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
        Arrays.sort(candidates);
        List<List<Integer>> combinationSum = new ArrayList<>();
        addCombinationNum(candidates, target, null, combinationSum);
        return combinationSum;
    }

    private void addCombinationNum(int[] candidates, int target, List<Integer> currCombinationNum,
                                   List<List<Integer>> combinationSum) {
        if (0 == target) {
            List<Integer> newCombinationNum = new ArrayList<>();
            if (null != currCombinationNum) {
                newCombinationNum.addAll(currCombinationNum);
            }
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
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int rightMoveIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (rightMoveIndex < i) {
                break;
            }
            rightMoveIndex = Math.max(rightMoveIndex, i + nums[i]);
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
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int numLen = Math.max(a.length(), b.length());
        StringBuilder numStr = new StringBuilder();
        int numArr = 0;
        for (int i = 0; i < numLen; i++) {
            int numA = i >= a.length() ? 0 : a.charAt(a.length() - 1 - i) - '0';
            int numB = i >= b.length() ? 0 : b.charAt(b.length() - 1 - i) - '0';
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
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int tempNum = 3;
        while (tempNum++ < n) {
            int temp = n2;
            n2 += n1;
            n1= temp;
        }
        return n1 + n2;
    }

    /**
     * 239. 滑动窗口最大值
     * 难度
     * 困难
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
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

    /**
     * 数据流的中位数
     */
    class MedianFinder {
        private TreeMap<Integer, Integer> numMap;
        private int numCount;
        private int[] leftIndex, rightIndex;

        public MedianFinder() {
            numMap = new TreeMap<>();
            leftIndex = new int[2];
            rightIndex = new int[2];
        }

        public void addNum(int num) {
            if (numMap.isEmpty()) {
                numMap.put(num, 1);
                leftIndex[0] = rightIndex[0] = num;
                leftIndex[1] = rightIndex[1] = numCount = 1;
                return;
            }
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            if ((numCount & 1) == 0) {
                if (num > leftIndex[0] && num < rightIndex[0]) {
                    // 左指针右移，右指针左移
                    indexMoveRight(leftIndex);
                    indexMoveLeft(rightIndex);
                } else if (num >= rightIndex[0]) {
                    // 左指针右移
                    indexMoveRight(leftIndex);
                } else {
                    indexMoveLeft(rightIndex);
                    System.arraycopy(rightIndex, 0, leftIndex, 0, 2);
                }
            } else {
                if (num >= rightIndex[0]) {
                    indexMoveRight(rightIndex);
                } else {
                    indexMoveLeft(leftIndex);
                }
            }
            numCount++;
        }

        private void indexMoveLeft(int[] index) {
            if (index[1] > 1) {
                index[1]--;
                return;
            }
            index[0] = numMap.floorKey(index[0] - 1);
            index[1] = numMap.get(index[0]);
        }

        private void indexMoveRight(int[] index) {
            if (index[1] < numMap.get(index[0])) {
                index[1]++;
                return;
            }
            index[0] = numMap.ceilingKey(index[0] + 1);
            index[1] = 1;
        }

        public double findMedian() {
            return (leftIndex[0] + rightIndex[0]) / 2.0;
        }
    }
}
