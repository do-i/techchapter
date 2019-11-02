package com.djd.fun.techchapter.demo016;

import javax.annotation.Nullable;

public class StringCompress {

  /**
   * Compress string by counting consecutive char length "dddooog" -> "d3o3g1"
   *
   * @param input
   * @return compressed string or original if compression rate is bad
   */
  public static @Nullable String compress(@Nullable String input) {
    if (input == null || input.length() <= 2) {
      return input;
    }
    int count = 1;
    char prev = input.charAt(0);
    StringBuilder compressedString = new StringBuilder();
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == prev) {
        count++;
      } else {
        compressedString.append(prev);
        compressedString.append(count);
        count = 1;
        prev = input.charAt(i);
      }
    }
    compressedString.append(prev);
    compressedString.append(count);
    return compressedString.length() < input.length() ? compressedString.toString() : input;
  }
}
