package org.example;

import java.util.Arrays;

public class Medium {
  // 2289
  public static int totalSteps(int[] nums) {
    int numsLength = nums.length, totalSteps = 0, pointer = -1;
    int[] dp = new int[numsLength];
    int[] stack = new int[numsLength];

    for (int i = numsLength - 1; i >= 0; --i) {
      while (pointer >= 0 && nums[i] > nums[stack[pointer]]) {
        dp[i] = Math.max(++dp[i], dp[stack[pointer--]]);
        totalSteps = Math.max(totalSteps, dp[i]);
      }
      stack[++pointer] = i;
    }

    return totalSteps;
  }

  // 34
  public static int[] searchRange(int[] nums, int target) {
    if (nums.length < 1) return new int[]{-1, -1};

    int left = 0;
    int right = nums.length - 1;

    int index = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) index = mid;
      if(nums[mid] < target) left = mid + 1;
      else right = mid - 1;
    }

    if (index == -1) return new int[]{-1, -1};

    int[] range = new int[]{index, index};

    int i = index;
    while (i != 0) {
      if (index - 1 > 0 && nums[i - 1] == target) {
        range[0]--;
        i--;
      } else {
        i = 0;
      }
    }

    i = index;
    while (i < nums.length - 1) {
      if (index + 1 < nums.length && nums[i + 1] == target) {
        range[1]++;
        i++;
      } else {
        i = nums.length;
      }
    }

    return range;
  }

  public static void main(String[] args) {

  }
}
