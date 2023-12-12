package org.example;

import java.util.HashMap;

public class Easy {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int digit = target - nums[i];
      if (map.containsKey(digit)) return new int[]{map.get(digit), i};
      map.put(nums[i], i);
    }
    return new int[0];
  }

  // for tests
  public static void main(String[] args) {

  }
}
