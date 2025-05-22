package com.example.easy;

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
}
