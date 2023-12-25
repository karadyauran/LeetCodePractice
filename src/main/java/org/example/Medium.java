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

  public static void main(String[] args) {

  }
}
