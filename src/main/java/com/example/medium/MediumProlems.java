package com.example.medium;

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
}
