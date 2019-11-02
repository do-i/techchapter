package com.djd.fun.techchapter.demo016;

import com.google.common.annotations.VisibleForTesting;

/**
 * CtCI 6th ed. 16.7 Number Max: Write a method that finds the max of two numbers. You should not
 * use if-else or any other comparison operator.
 */
public class MaxInt {

  /**
   * Returns max of two integers
   *
   * @param a
   * @param b
   * @return max of either a or b
   */
  public static int max(int a, int b) {
    /* if a > b, then d is positive,
      if a < b, then d is negative.
    */
    int d = a - b;

    /* Java use 2's compliment in binary
      negative integers has most significant bit of 1
      positive integers has most significant bit of 0
    */
    int signBit = signBit(d);

    /* Use XOR to find oppsit signBit
      if signBit is 1, then get 0,
      if signBit is 0, then get 1.
    */
    int otherSignBit = flipSign(signBit);

    return a * otherSignBit + b * signBit;
  }

  /**
   * Returns 1 if number is negative, 0 otherwise.
   *
   * @param number
   * @return 1 if number is negative, 0 otherwise
   */
  @VisibleForTesting
  static int signBit(int number) {
    /* bit wise right shift fill with zeros  */
    return number >>> 31;
  }

  /**
   * If sign is 0, returns 1. If sign is 1, returns 0.
   *
   * @param sign
   * @return 1 if sign is 0. 0 if sign is 1
   * @throws IllegalArgumentException if sign is neither 0 or 1
   * @implNote Use XOR operator to flip binary bit
   */
  @VisibleForTesting
  static int flipSign(int sign) {
    if (sign == 0 || sign == 1) {
      return sign ^ 1;
    }
    throw new IllegalArgumentException("bad sign " + sign);
  }
}
