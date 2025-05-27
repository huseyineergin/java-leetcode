package com.example.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EasyProblems {

  // 1768. Merge Strings Alternately
  public String mergeAlternately(String word1, String word2) {
    StringBuilder merged = new StringBuilder();
    int minLength = Math.min(word1.length(), word2.length());

    for (int i = 0; i < minLength; i++) {
      merged.append(word1.charAt(i)).append(word2.charAt(i));
    }

    if (word1.length() > minLength) {
      merged.append(word1.substring(minLength));
    } else if (word2.length() > minLength) {
      merged.append(word2.substring(minLength));
    }

    return merged.toString();
  }

  // 1071. Greatest Common Divisor of Strings
  public String gcdOfStrings(String str1, String str2) {
    int minLength = Math.min(str1.length(), str2.length());
    List<Integer> commonDivisors = new ArrayList<>();
    int str1Length = str1.length();
    int str2Length = str2.length();

    for (int i = 1; i <= minLength; i++) {
      if (str1Length % i == 0 && str2Length % i == 0)
        commonDivisors.add(i);
    }

    String divisor = "";

    for (int cd : commonDivisors.reversed()) {
      divisor = str1.substring(0, cd);

      for (int i = 0; i < str1Length / cd; i++) {
        if (str1.startsWith(divisor)) {
          str1 = str1.substring(divisor.length());
        } else {
          break;
        }
      }

      for (int i = 0; i < str2Length / cd; i++) {
        if (str2.startsWith(divisor)) {
          str2 = str2.substring(divisor.length());
        } else {
          break;
        }
      }

      if (str1.length() == 0 && str2.length() == 0)
        return divisor;

      break;
    }

    return "";
  }

  // 1431. Kids With the Greatest Number of Candies
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>(Collections.nCopies(candies.length, false));
    int maxCandies = Arrays.stream(candies).max().getAsInt();

    for (int i = 0; i < candies.length; i++) {
      if (candies[i] + extraCandies >= maxCandies)
        result.set(i, true);
    }

    return result;
  }

  // 605. Can Place Flowers
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int availablePots = 0;

    for (int i = 0; i < flowerbed.length; i++) {
      int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
      int prev = (i == 0) ? 0 : flowerbed[i - 1];

      if (flowerbed[i] == 0 && prev == 0 && next == 0) {
        flowerbed[i] = 1;
        availablePots++;
        i++;
      }
    }

    return n <= availablePots;
  }

  // 345. Reverse Vowels of a String
  public String reverseVowels(String s) {
    List<Character> vowels = new ArrayList<>();
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < sb.length(); i++) {
      char c = sb.charAt(i);
      if ("aeiouAEIOU".indexOf(c) != -1) {
        vowels.add(c);
      }
    }

    for (int i = 0; i < sb.length(); i++) {
      char c = sb.charAt(i);
      if ("aeiouAEIOU".indexOf(c) != -1) {
        sb.setCharAt(i, vowels.removeLast());
      }
    }

    return sb.toString();
  }

  // 283. Move Zeroes
  public void moveZeroes(int[] nums) {
    int a = 0, b = 0;

    while (a < nums.length && b < nums.length) {
      if (nums[a] == 0 && nums[b] == 0) {
        b++;
      } else {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
        b++;
        a++;
      }
    }
  }
}
