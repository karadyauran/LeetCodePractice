package org.example;

import org.example.additionals.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

  // 13
  public int romanToInt(String s) {
    Map<Character, Integer> romanLetters = new HashMap<>();
    romanLetters.put('I', 1);
    romanLetters.put('V', 5);
    romanLetters.put('X', 10);
    romanLetters.put('L', 50);
    romanLetters.put('C', 100);
    romanLetters.put('D', 500);
    romanLetters.put('M', 1000);

    int result = 0;
    int prevValue = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      int currentValue = romanLetters.get(s.charAt(i));
      if (currentValue < prevValue) result -= currentValue;
      else result += currentValue;
      prevValue = currentValue;
    }

    return result;
  }

  // 14
  public String longestCommonPrefix(String[] str) {
    StringBuilder longestPrefix = new StringBuilder();
    Arrays.sort(str);

    String first = str[0];
    String last = str[str.length - 1];

    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != last.charAt(i)) return longestPrefix.toString();
      longestPrefix.append(first.charAt(i));
    }

    return longestPrefix.toString();
  }

  // 20
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(') stack.push(')');
      else if (c == '[') stack.push(']');
      else if (c == '{') stack.push('}');
      else if (stack.isEmpty() || stack.pop() != c) return false;
    }

    return stack.isEmpty();
  }

  // 21
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode();
    ListNode tail = head;

    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }

      tail = tail.next;
    }

    if (list1 != null) tail.next = list1;
    else tail.next = list2;

    return head.next;
  }

  // for tests
  public static void main(String[] args) {

  }
}
