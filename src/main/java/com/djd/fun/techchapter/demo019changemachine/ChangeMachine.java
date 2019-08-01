package com.djd.fun.techchapter.demo019changemachine;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Given dollar amount and cost, calculate changes.
 */
public class ChangeMachine {

  /**
   * if cost > payment throw exception
   * if payment > cost, calculate changes.
   * 25, 10, 5, 1 cents.
   * Compute how many of each coins need to be returned.
   *
   * @param cost
   * @param payment
   */
  public static Changes pay(double cost, double payment) {
    if (cost <= 0.0) {
      throw new IllegalArgumentException("cost should be positive number");
    }
    if (payment <= 0.0) {
      throw new IllegalArgumentException("payment should be positive number");
    }
    if (payment < cost) {
      throw new IllegalArgumentException("not enough payment to cover the cost");
    }
    double change = payment - cost;
    if (change >= 1.0) {
      throw new IllegalArgumentException("payment is too much");
    }
    int remainingCents = (int)(change * 100);
    int numOf25c = remainingCents / 25;
    remainingCents = remainingCents % 25;
    int numOf10c = remainingCents / 10;
    remainingCents = remainingCents % 10;
    int numOf5c = remainingCents / 5;
    remainingCents = remainingCents % 5;

    return new Changes(numOf25c, numOf10c, numOf5c, remainingCents);
  }

  public static class Changes {
    private final int numOf25c;
    private final int numOf10c;
    private final int numOf5c;
    private final int numOf1c;

    public Changes(int numOf25c, int numOf10c, int numOf5c, int numOf1c) {
      this.numOf25c = numOf25c;
      this.numOf10c = numOf10c;
      this.numOf5c = numOf5c;
      this.numOf1c = numOf1c;
    }

    public int getNumOf25c() {
      return numOf25c;
    }

    public int getNumOf10c() {
      return numOf10c;
    }

    public int getNumOf5c() {
      return numOf5c;
    }

    public int getNumOf1c() {
      return numOf1c;
    }

    @Override public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Changes changes = (Changes)o;
      return numOf25c == changes.numOf25c &&
          numOf10c == changes.numOf10c &&
          numOf5c == changes.numOf5c &&
          numOf1c == changes.numOf1c;
    }

    @Override public int hashCode() {
      return Objects.hash(numOf25c, numOf10c, numOf5c, numOf1c);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Changes.class.getSimpleName() + "[", "]")
          .add("numOf25c=" + numOf25c)
          .add("numOf10c=" + numOf10c)
          .add("numOf5c=" + numOf5c)
          .add("numOf1c=" + numOf1c)
          .toString();
    }
  }
}
