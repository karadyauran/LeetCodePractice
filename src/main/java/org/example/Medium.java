package org.example;

import org.example.additionals.ListNode;

import java.util.*;

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

  // 17
  public void buildMap(HashMap<Character, String> numbersMap) {
    numbersMap.put('2', "abc");
    numbersMap.put('3', "def");
    numbersMap.put('4', "ghi");
    numbersMap.put('5', "jkl");
    numbersMap.put('6', "mno");
    numbersMap.put('7', "pqrs");
    numbersMap.put('8', "tuv");
    numbersMap.put('9', "wxyz");
  }

  public void backtrack(int len, String digits, HashMap<Character, String> numbersMap, String temp, List<String> result, int idx) {
    if (temp.length() == len) {
      result.add(temp);
      return;
    }

    for (int i = 0; i < numbersMap.get(digits.charAt(idx)).length(); i++) {
      temp = temp + numbersMap.get(digits.charAt(idx)).charAt(i);
      backtrack(len, digits, numbersMap, temp, result, idx + 1);
      temp = temp.substring(0, temp.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    HashMap<Character, String> numbersMap = new HashMap<>();
    buildMap(numbersMap);

    if (digits.isEmpty()) return result;

    backtrack(digits.length(), digits, numbersMap, "", result, 0);
    return result;
  }

  // 82
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;

    int lastValue = -1;
    while (head != null) {
      int curr = head.val;
      int next = head.next != null ? head.next.val : -1;

      if (curr != next && curr != lastValue) {
        tail.next = new ListNode(curr);
        tail = tail.next;
      }

      lastValue = curr;

      head = head.next;
    }

    return dummy.next;
  }

  // 215
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    int[] distinct = Arrays.stream(nums).distinct().toArray();
    System.out.println(Arrays.toString(distinct));
    return distinct[distinct.length - k];
  }

  // 147
  public ListNode insertionSortList(ListNode head) {
    List<Integer> numbers = new ArrayList<>();
    while (head != null) {
      numbers.add(head.val);
      head = head.next;
    }

    Collections.sort(numbers);

    ListNode dummy = new ListNode();
    ListNode tail = dummy;

    for (int num : numbers) {
      tail.next = new ListNode(num);
      tail = tail.next;
    }

    return dummy;
  }

  // 2452
  public static long makeIntegerBeautiful(long n, int target) {
    if (n < target) return 0;

    long temp = n;
    long sum = calculateSum(n);
    long numberToAdd = 1;

    while (sum > target) {
      temp = temp / 10 + 1;
      numberToAdd *= 10;
      sum = calculateSum(temp);
    }

    return temp * numberToAdd - n;
  }

  private static long calculateSum(long number) {
    long sum = 0;

    while (number > 0) {
      long digit = number % 10;
      sum += digit;
      number /= 10;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(makeIntegerBeautiful(16, 6));
  }
}
