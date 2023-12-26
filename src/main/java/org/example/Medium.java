package org.example;

import java.util.List;
import java.util.Map;

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
    if (nums.length < 1) return new int[]{ -1, -1 };

    int left = 0;
    int right = nums.length - 1;

    int index = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) index = mid;
      if (nums[mid] < target) left = mid + 1;
      else right = mid - 1;
    }

    if (index == -1) return new int[]{ -1, -1 };

    int[] range = new int[]{ index, index };

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


  // 167
  public static int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int r = numbers.length - 1;

    while (l <= r) {
      if (numbers[l] + numbers[r] == target) return new int[]{ ++l, ++r };

      if (numbers[l] + numbers[r] > target) r--;
      else l++;
    }

    return new int[0];
  }

  // 475
  public int findRadius(int[] houses, int[] heaters) {
    int max = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
    int[] warm = new int[max];

    for (int heater : heaters) {
      warm[heater - 1] = 1;
    }

    int maxSequence = 0;
    int temp = 0;
    for (int i = 0; i < max; i++) {
      if (warm[i] == 0) temp++;
      if (warm[i] != 0 || i == max - 1) {
        maxSequence = Math.max(maxSequence, temp);
        temp = 0;
      }
    }

    if (heaters.length % 2 == 1) return maxSequence;
    return maxSequence / heaters.length;
  }

  public static void main(String[] args) {
    int[] houses = new int[]{ 1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999 };
    int[] heaters = new int[]{ 499, 500, 501 };
  }
}
