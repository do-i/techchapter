package com.djd.fun.techchapter.demo024rotate;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given
 * two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”)
 */
public class RotationDetactor {

  public static boolean isRotation(String s1, String s2) {
    if (s1.length() == s2.length()) {
      String s3 = s1 + s1;
      return s3.contains(s2);
    }
    return false;
  }
}
