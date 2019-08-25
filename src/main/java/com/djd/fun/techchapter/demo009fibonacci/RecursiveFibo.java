package com.djd.fun.techchapter.demo009fibonacci;

import java.math.BigInteger;

/**
 * @author JGD
 * @since 10/4/16
 */
public class RecursiveFibo implements Fibonacci {
  /**
   * static method to find out N-th fibonacci number.
   * <p>
   * Note: Time complexity of recursive implementation is O(2^N)
   *
   * @param n valid range 0 and 16
   * @return Nth fibonacci number
   */
  @Override
  public int findAt(int n) {
    if (n < 0 || n > 46) {
      throw new IllegalArgumentException("Acceptable range: 0 <= N <= 46");
    }

    // case where n=0 or n=1
    if (n < 2) {
      return n;
    }
    return findAt(n - 1) + findAt(n - 2);
  }

  @Override
  public BigInteger findBigAt(BigInteger n) {
    if (n.compareTo(BigInteger.ZERO) < 0 || BigInteger.valueOf(46).compareTo(n) < 0) {
      throw new IllegalArgumentException("Acceptable range: 0 <= N <= 46");
    }

    // case where n=0 or n=1
    if (n.compareTo(BigInteger.ZERO) == 0 || n.compareTo(BigInteger.ONE) == 0) {
      return n;
    }
    BigInteger prev = findBigAt(n.subtract(BigInteger.ONE));
    BigInteger prev2 = findBigAt(n.subtract(BigInteger.valueOf(2)));
    return prev.add(prev2);
  }
}
