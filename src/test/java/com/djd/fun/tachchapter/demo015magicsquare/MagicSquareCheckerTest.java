package com.djd.fun.tachchapter.demo015magicsquare;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 */
public class MagicSquareCheckerTest {

  private static final int[][] UNIQ_GOOD_RANGE = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  private static final SquareMatrix UNIQ_GOOD_RANGE_MATRIX = SquareMatrix.builder(UNIQ_GOOD_RANGE).build();

  private static final int[][] UNIQ_BAD_RANGE = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
  private static final SquareMatrix UNIQ_BAD_RANGE_MATRIX = SquareMatrix.builder(UNIQ_BAD_RANGE).build();

  private static final int[][] NOT_UNIQ_GOOD_RANGE = {{1, 2, 3}, {4, 5, 6}, {7, 8, 8}};
  private static final SquareMatrix NOT_UNIQ_GOOD_RANGE_MATRIX = SquareMatrix.builder(NOT_UNIQ_GOOD_RANGE).build();

  private static final int[][] DIAGONAL_NOT_EQUAL = {{7, 2, 6}, {9, 5, 1}, {4, 3, 8}};
  private static final SquareMatrix DIAGONAL_NOT_EQUAL_MATRIX = SquareMatrix.builder(DIAGONAL_NOT_EQUAL).build();

  private static final int[][] ROWS_NOT_EQUAL = {{4, 7, 6}, {9, 5, 1}, {2, 3, 8}};
  private static final SquareMatrix ROWS_NOT_EQUAL_MATRIX = SquareMatrix.builder(ROWS_NOT_EQUAL).build();

  private static final int[][] COLS_NOT_EQUAL = {{2, 7, 6}, {9, 5, 1}, {3, 4, 8}};
  private static final SquareMatrix COLS_NOT_EQUAL_MATRIX = SquareMatrix.builder(COLS_NOT_EQUAL).build();

  private static final int[][] MAGIC_SQUARE = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
  private static final SquareMatrix MAGIC_SQUARE_MATRIX = SquareMatrix.builder(MAGIC_SQUARE).build();

  @Test
  public void checkValueRange_uniqGoodRange() {
    assertTrue(MagicSquareChecker.checkValueRange(UNIQ_GOOD_RANGE_MATRIX));
  }

  @Test
  public void checkValueRange_uniqBadRange() {
    assertFalse(MagicSquareChecker.checkValueRange(UNIQ_BAD_RANGE_MATRIX));
  }

  @Test
  public void checkValueRange_notUniqGoodRange() {
    assertTrue(MagicSquareChecker.checkValueRange(NOT_UNIQ_GOOD_RANGE_MATRIX));
  }

  @Test
  public void checkUniq_uniqGoodRange() {
    assertTrue(MagicSquareChecker.checkUniq(UNIQ_GOOD_RANGE_MATRIX));
  }

  @Test
  public void checkUniq_uniqBadRange() {
    assertFalse(MagicSquareChecker.checkUniq(UNIQ_BAD_RANGE_MATRIX));
  }

  @Test
  public void checkUniq_notUniqGoodRange() {
    assertFalse(MagicSquareChecker.checkUniq(NOT_UNIQ_GOOD_RANGE_MATRIX));
  }

  @Test
  public void sumDiagonals_notEqual() {
    assertThat(MagicSquareChecker.sumDiagonals(DIAGONAL_NOT_EQUAL_MATRIX)).isEqualTo(-1);
  }

  @Test
  public void sumDiagonals_magicSquare() {
    assertThat(MagicSquareChecker.sumDiagonals(MAGIC_SQUARE_MATRIX)).isEqualTo(15);
  }

  @Test
  public void sumRows() {
    assertThat(MagicSquareChecker.sumDiagonals(MAGIC_SQUARE_MATRIX)).isEqualTo(15);
  }

  @Test
  public void sumRows_notEqual() {
    assertThat(MagicSquareChecker.sumDiagonals(ROWS_NOT_EQUAL_MATRIX)).isEqualTo(-1);
  }

  @Test
  public void sumCols() {
    assertThat(MagicSquareChecker.sumCols(MAGIC_SQUARE_MATRIX)).isEqualTo(15);
  }

  @Test
  public void sumCols_notEqual() {
    assertThat(MagicSquareChecker.sumCols(COLS_NOT_EQUAL_MATRIX)).isEqualTo(-1);
  }

  @Test
  public void isMagicSquare() {
    assertTrue(MagicSquareChecker.isMagicSquare(MAGIC_SQUARE_MATRIX));
  }
}
