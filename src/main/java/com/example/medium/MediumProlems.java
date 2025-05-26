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
}
