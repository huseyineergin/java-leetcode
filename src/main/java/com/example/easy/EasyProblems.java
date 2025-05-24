package com.example.easy;

import java.util.ArrayList;
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
}
