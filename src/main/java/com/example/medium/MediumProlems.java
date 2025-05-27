package com.example.medium;

import java.util.Arrays;

public class MediumProlems {

  // 151. Reverse Words in a String
  public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    int right = words.length - 1;
    int left = 0;

    while (left < right) {
      String temp = words[right];
      words[right] = words[left];
      words[left] = temp;

      right--;
      left++;
    }

    return String.join(" ", words);
  }

  // 238. Product of Array Except Self
  public int[] productExceptSelf(int[] nums) {
    int[] answer = new int[nums.length];
    Arrays.fill(answer, 1);

    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      answer[i] *= prefix;
      prefix *= nums[i];
    }

    int suffix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      answer[i] *= suffix;
      suffix *= nums[i];
    }

    return answer;
  }

  // 334. Increasing Triplet Subsequence
  public boolean increasingTriplet(int[] nums) {
    int lowest = Integer.MAX_VALUE;
    int middle = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];

      if (curr <= lowest) {
        lowest = curr;
      } else if (curr <= middle) {
        middle = curr;
      } else {
        return true;
      }
    }

    return false;
  }

  // 11. Container With Most Water
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int max = 0;

    while (left < right) {
      int width = right - left;
      int lHeight = height[left];
      int rHeight = height[right];
      int minHeight = Math.min(lHeight, rHeight);
      int area = minHeight * width;

      if (lHeight < rHeight) {
        left++;
      } else {
        right--;
      }

      if (area > max)
        max = area;
    }

    return max;
  }

  // 1679. Max Number of K-Sum Pairs
  public int maxOperations(int[] nums, int k) {
    int left = 0, right = nums.length - 1;
    int operations = 0;
    Arrays.sort(nums);

    while (left < right) {
      int sum = nums[left] + nums[right];

      if (sum == k) {
        operations++;
        right--;
        left++;
      } else if (sum < k) {
        left++;
      } else {
        right--;
      }
    }

    return operations;
  }
}