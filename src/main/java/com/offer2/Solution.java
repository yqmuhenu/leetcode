package com.offer2;

public class Solution {

    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * 难度
     * 简单
     *
     * 262
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     *
     * 输入：n = 5
     * 输出：5
     *
     *
     * 提示：
     *
     * 0 <= n <= 100
     * 通过次数281,929提交次数781,627
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int modeNum = 1000000007;
        int n0 = 0, n1 = 1;
        int tempNum = 2;
        while (tempNum++ < n) {
            int temp = n1;
            n1 += n0;
            n0 = temp;
            if (n1 >= modeNum) {
                n1 %= modeNum;
            }
        }
        return (n0 + n1) % modeNum;
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * 难度
     * 简单
     *
     * 617
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 找出数组中重复的数字。
     *
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     *
     * 限制：
     *
     * 2 <= n <= 100000
     *
     * 通过次数428,558提交次数631,833
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (currNum == i) {
                continue;
            }
            while (true) {
                int nextNum = nums[currNum];
                if (currNum == nextNum) {
                    return currNum;
                }
                nums[currNum] = currNum;
                if (nextNum == i) {
                    nums[i] = nextNum;
                    break;
                }
                currNum = nextNum;
            }
        }
        return 0;
    }

    /**
     * 剑指 Offer 10- II. 青蛙跳台阶问题
     * 难度
     * 简单
     *
     * 216
     *
     * 收藏
     *
     * 分享
     * 切换为英文
     * 接收动态
     * 反馈
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * 提示：
     *
     * 0 <= n <= 100
     * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (0 == n) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int modeNum = 1000000007;
        int n1 = 1, n2 = 2;
        int tempNum = 3;
        while (tempNum++ < n) {
            int temp = n2;
            n2 += n1;
            n1 = temp;
            if (n2 >= modeNum) {
                n2 %= modeNum;
            }
        }
        return (n1 + n2) % modeNum;
    }

    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * 难度
     * 简单
     *
     * 450
     *
     *
     *
     *
     *
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
     *
     * 示例 1：
     *
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
     *
     * 通过次数280,777提交次数570,261
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (null == numbers || 0 == numbers.length) {
            throw new RuntimeException("Invalid parameters!");
        }
        int l = 0, h = numbers.length - 1;
        int mid = l;
        while (numbers[l] >= numbers[h]) {
            if (h - l == 1) {
                mid = h;
                break;
            }
            mid = (l + h) / 2;
            if (numbers[l] == numbers[h] && numbers[l] == numbers[mid]) {
                return getMinNum(numbers, l, h);
            }
            if (numbers[mid] <= numbers[l]) {
                l = mid;
            } else if (numbers[mid] >= numbers[h]) {
                h = mid;
            }
        }
        return numbers[mid];
    }

    private int getMinNum(int[] numbers, int l, int h) {
        int minNum = numbers[l];
        for (int i = l + 1; i <= h; i++) {
            if (minNum > numbers[i]) {
                minNum = numbers[i];
            }
        }
        return minNum;
    }

    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 难度
     * 中等
     *
     * 458
     *
     *
     *
     *
     *
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *
     *
     * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
     *
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     *
     *
     * 提示：
     *
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * board 和 word 仅由大小写英文字母组成
     *
     *
     * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
     *
     * 通过次数183,145提交次数404,803
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (null == word || 0 == word.length()) {
            return false;
        }
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (exist(board, rows, cols, row, col, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int rows, int cols, int row, int col,
                          String word, int pathLen, boolean[][] visited) {
        if (pathLen == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row][col] && board[row][col] == word.charAt(pathLen)) {
            visited[row][col] = true;
            pathLen++;
            hasPath = exist(board, rows, cols, row + 1, col, word, pathLen, visited)
                    || exist(board, rows, cols, row, col + 1, word, pathLen, visited)
                    || exist(board, rows, cols, row - 1, col, word, pathLen, visited)
                    || exist(board, rows, cols, row, col - 1, word, pathLen, visited);
            if (!hasPath) {
                visited[row][col] = false;
                pathLen--;
            }
        }
        return hasPath;
    }

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * 难度
     * 中等
     *
     * 388
     *
     *
     *
     *
     *
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     * 提示：
     *
     * 1 <= n,m <= 100
     * 0 <= k <= 20
     * 通过次数189,224提交次数358,730
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return movingCount(m, n, 0, 0, k, visited);
    }

    private int movingCount(int rows, int cols, int row, int col,
                            int k, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && !visited[row][col] && canEnable(row, col, k)) {
            visited[row][col] = true;
            return 1 + movingCount(rows, cols, row + 1, col, k, visited)
                    + movingCount(rows, cols, row, col + 1, k, visited)
                    + movingCount(rows, cols, row - 1, col, k, visited)
                    + movingCount(rows, cols, row, col - 1, k, visited);
        }
        return 0;
    }

    private boolean canEnable(int row, int col, int k) {
        return getBitSum(row) + getBitSum(col) <= k;
    }

    private int getBitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /**
     * 剑指 Offer 14- I. 剪绳子
     * 难度
     * 中等
     *
     * 325
     *
     *
     *
     *
     *
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 示例 1：
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * 示例 2:
     *
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * 提示：
     *
     * 2 <= n <= 58
     * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
     *
     * 通过次数166,762提交次数292,632
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] products = new int[n + 1];
        products[2] = 2;
        products[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                max = Math.max(max, products[j] * products[i - j]);
                products[i] = max;
            }
        }
        return max;
    }

    public int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int num3Count = n / 3;
        if (num3Count * 3 == n - 1) {
            num3Count -= 1;
        }
        int num2Count = (n - num3Count * 3) / 2;
        return (int) (Math.pow(3, num3Count) * Math.pow(2, num2Count));
    }

    /**
     * 剑指 Offer 15. 二进制中1的个数
     * 难度
     * 简单
     *
     * 197
     *
     *
     *
     *
     *
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     *
     *
     *
     * 提示：
     *
     * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
     * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
     *
     *
     * 示例 1：
     *
     * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     *
     * 输入：n = 128 (控制台输入 00000000000000000000000010000000)
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * 示例 3：
     *
     * 输入：n = 4294967293 (控制台输入 11111111111111111111111111111101，部分语言中 n = -3）
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     *
     * 提示：
     *
     * 输入必须是长度为 32 的 二进制串 。
     *
     *
     * 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
     *
     * 通过次数209,289提交次数279,942
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (0 != (n & (1 << i))) {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 剑指 Offer 16. 数值的整数次方
     * 难度
     * 中等
     *
     * 221
     *
     *
     *
     *
     *
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     *
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     *
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *
     *
     * 提示：
     *
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     *
     *
     * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
     *
     * 通过次数131,794提交次数386,688
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (String.valueOf(x).equals("0.0")) {
            return 0.0;
        }
        double myPow = myPowCore(Math.abs(x), Math.abs(n));
        if (n < 0) {
            myPow = 1.0 / myPow;
        }
        if (x < 0 && (n & 1) != 0) {
            myPow = 0 - myPow;
        }
        return myPow;
    }

    private double myPowCore(double x, int n) {
        if (0 == n) {
            return 1.0;
        }
        if (1 == n) {
            return x;
        }
        double result = myPowCore(x, n / 2);
        result *= result;
        if ((n & 1) != 0) {
            result *= x;
        }
        return result;
    }
}
