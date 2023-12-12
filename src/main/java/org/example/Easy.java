package org.example;

import java.util.HashMap;

public class Easy {
  // 1
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int digit = target - nums[i];
      if (map.containsKey(digit)) return new int[]{map.get(digit), i};
      map.put(nums[i], i);
    }
    return new int[0];
  }

  // 9
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int reversed = 0;
    int temp = x;

    while (temp != 0) {
      int digit = temp % 10;
      reversed = reversed * 10 + digit;
      temp /= 10;
    }

    return reversed == x;
  }

  // for tests
  public static void main(String[] args) {

  }
}
