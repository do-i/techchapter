package com.djd.fun.techchapter.demo016;

/**
 * From CrackingTheCodingInterview.com 1.9 String Rotation
 *
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1.
 *
 * (e.g., s1: "catfish", s2: "fishcat")
 */
public class StringRotation {
  public static boolean isStringRotation(String s1, String s2) {
    return s1.length() == s2.length() && (s1 + s1).contains(s2);
  }
}
