import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test1 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode temPre = null, temp = head;
        while (null != temp) {
            int currVal = temp.val;
            boolean isDuplicate = false;
            while (null != temp.next && currVal == temp.next.val) {
                temp.next = temp.next.next;
                isDuplicate = true;
            }
            if (!isDuplicate) {
                temPre = temp;
                temp = temp.next;
                continue;
            }
            if (null != temPre) {
                temPre.next = temp.next;
            }
        }
        return head;
    }

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0, h = len - 2;
        while (l < h) {
            int mid = (l + h) / 2;
            int sum = numbers[mid] + numbers[mid + 1];
            if (sum < target) {
                l = mid + 1;
                continue;
            }
            if (sum > target) {
                h = mid - 1;
                continue;
            }
            return new int[]{mid + 1, mid + 2};
        }
        return new int[]{l + 1, l + 2};
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 1};
    }

    public int tribonacci(int n) {
        if (0 == n) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int t1 = 0, t2 = 1, t3 = 1;
        int index = 3;
        while (index++ <= n) {
            int temp = t3;
            t3 = t1 + t2 + t3;
            t1 = t2;
            t2 = temp;
        }
        return t3;
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f1 = 0, f2 = 1;
        int index = 2;
        while (index++ <= n) {
            int temp = f1;
            f1 = f2;
            f2 += temp;
        }
        return f2;
    }

    public int maxSubArray(int[] nums) {
        int maxSum, lastMaxSum;
        maxSum = lastMaxSum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            lastMaxSum = lastMaxSum > 0 ? lastMaxSum + nums[index] : nums[index];
            if (maxSum < lastMaxSum) {
                maxSum = lastMaxSum;
            }
        }
        return maxSum;
    }

    public boolean containsDuplicate(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return false;
        }
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int l = 0, h = len - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            int result = checkPeakElement(nums, mid);
            if (0 == result) {
                return mid;
            }
            if (-1 == result) {
                h = mid - 1;
                continue;
            }
            if (1 == result) {
                l = mid + 1;
            }
        }
        return l;
    }

    public int checkPeakElement(int[] nums, int index) {
        int len = nums.length;
        if (0 != index && nums[index] < nums[index - 1]) {
            return -1;
        }
        if (len - 1 != index && nums[index] < nums[index + 1]) {
            return 1;
        }
        return 0;
    }

    public int findMin(int[] nums) {
        int len = nums.length;
        if (1 == len || nums[0] < nums[len - 1]) {
            return nums[0];
        }
        int l = 0, h = len - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] < nums[h]) {
                if (mid == l || nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                } else {
                    h = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        int mLow = 0, mHigh = m - 1;
        while (mLow < mHigh) {
            int mMid = (mLow + mHigh) / 2;
            if (target < matrix[mMid][0]) {
                mHigh = mMid - 1;
                continue;
            }
            if (target > matrix[mMid][n - 1]) {
                mLow = mMid + 1;
                continue;
            }
            mLow = mMid;
            break;
        }

        int[] mMatrix = matrix[mLow];
        int nLow = 0, nHigh = n - 1;
        while (nLow < nHigh) {
            int nMid = (nLow + nHigh) / 2;
            if (mMatrix[nMid] < target) {
                nLow = nMid + 1;
                continue;
            }
            if (mMatrix[nMid] > target) {
                nHigh = nMid - 1;
                continue;
            }
            return true;
        }
        return mMatrix[nLow] == target;
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, h = len - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (nums[h] >= target) {
                    l = mid + 1;
                } else {
                    if (nums[mid] < nums[h]) {
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                        h -= 1;
                    }
                }
            } else {
                if (nums[l] <= target) {
                    h = mid - 1;
                } else {
                    if (nums[mid] > nums[h]) {
                        l = mid + 1;
                    } else {
                        h = mid - 1;
                        l += 1;
                    }
                }
            }
        }
        if (nums[l] == target) {
            return l;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return new int[]{-1, -1};
        }
        int lowIndex = searchLowIndex(nums, 0, nums.length - 1, target);
        int highIndex = searchHighIndex(nums, 0, nums.length - 1, target);
        return new int[]{lowIndex, highIndex};
    }

    private static int searchLowIndex(int[] nums, int l, int h, int target) {
        if (l > h || target < nums[l] || target > nums[h]) {
            return -1;
        }
        if (target == nums[l]) {
            return l;
        }
        int mid = (l + h) / 2;
        if (nums[mid] >= target) {
            return searchLowIndex(nums, l, mid, target);
        } else {
            return searchLowIndex(nums, mid + 1, h, target);
        }
    }

    // [5,7,7,8,8,10]
    //8
    private static int searchHighIndex(int[] nums, int l, int h, int target) {
        if (l > h || target < nums[l] || target > nums[h]) {
            return -1;
        }
        if (target == nums[h]) {
            return h;
        }
        int mid = (l + h + 1) / 2;
        if (nums[mid] <= target) {
            return searchHighIndex(nums, mid, h, target);
        } else {
            return searchHighIndex(nums, l, mid - 1, target);
        }
    }

}


