package com.exam.rank4.exercise1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 295. 数据流的中位数
 * 难度
 * 困难
 *
 * 580
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 通过次数67,363提交次数129,012
 */
public class MedianFinder {

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
            leftIndex[1] = rightIndex[1] = 1;
            numCount++;
            return;
        }
        numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        if ((numCount & 1) == 0) {
            if (num > leftIndex[0] && num < rightIndex[0]) {
                // 右指针左移，左指针右移
                indexMoveLeft(rightIndex);
                indexMoveRight(leftIndex);
            } else if (num <= leftIndex[0]) {
                // 右指针左移，左指针等于右指针
                indexMoveLeft(rightIndex);
                System.arraycopy(rightIndex, 0, leftIndex, 0, 2);
            } else {
                // 左指针右移
                indexMoveRight(leftIndex);
            }
        }
        else {
            if (num >= rightIndex[0]) {
                // 右指针右移
                indexMoveRight(rightIndex);
            } else {
                // 左指针左移
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
