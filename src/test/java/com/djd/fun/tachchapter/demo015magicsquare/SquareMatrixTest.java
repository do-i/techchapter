package com.djd.fun.tachchapter.demo015magicsquare;

import com.google.common.testing.EqualsTester;

import org.junit.Test;

/**
 */
public class SquareMatrixTest {

  @Test
  public void equalities() {
    new EqualsTester()
        .addEqualityGroup(SquareMatrix.builder(2).build(), SquareMatrix.builder(2).build())
        .addEqualityGroup(SquareMatrix.builder(2).setValueAt(8, 0, 0).build())
        .addEqualityGroup(SquareMatrix.builder(3).build())
        .testEquals();
  }

  @Test(expected = IllegalArgumentException.class)
  public void builder_zeroSize() {
    SquareMatrix.builder(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void builder_negativeSize() {
    SquareMatrix.builder(-1);
  }

  @Test
  public void builder_2dArray() {
    int[][] seedData = {{1, 2}, {3, 4}};
    SquareMatrix.builder(seedData).build();
  }
}
