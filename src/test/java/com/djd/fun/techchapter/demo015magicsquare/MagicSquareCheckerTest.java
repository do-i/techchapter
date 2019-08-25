package com.djd.fun.techchapter.demo015magicsquare;

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

  private static final int[][] SMALLEST_MAGIC_SQUARE = {{1}};
  private static final SquareMatrix SMALLEST_MAGIC_SQUARE_MATRIX = SquareMatrix.builder(SMALLEST_MAGIC_SQUARE).build();

  @Test
  public void magicSum_1x1() {
    assertThat(MagicSquareChecker.magicSum(1)).isEqualTo(1);
  }

  @Test
  public void magicSum_3x3() {
    assertThat(MagicSquareChecker.magicSum(3)).isEqualTo(15);
  }

  @Test
  public void magicSum_4x4() {
    assertThat(MagicSquareChecker.magicSum(4)).isEqualTo(34);
  }

  @Test
  public void magicSum_5x5() {
    assertThat(MagicSquareChecker.magicSum(5)).isEqualTo(65);
  }

  @Test
  public void magicSum_6x6() {
    assertThat(MagicSquareChecker.magicSum(6)).isEqualTo(111);
  }

  @Test
  public void magicSum_7x7() {
    assertThat(MagicSquareChecker.magicSum(7)).isEqualTo(175);
  }

  @Test
  public void magicSum_8x8() {
    assertThat(MagicSquareChecker.magicSum(8)).isEqualTo(260);
  }

  @Test
  public void magicSum_9x9() {
    assertThat(MagicSquareChecker.magicSum(9)).isEqualTo(369);
  }

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
  public void isDiagonalyMagicSum_notEqual() {
    assertFalse(MagicSquareChecker.isDiagonalyMagicSum(DIAGONAL_NOT_EQUAL_MATRIX));
  }

  @Test
  public void isDiagonalyMagicSum_magicSquare() {
    assertTrue(MagicSquareChecker.isDiagonalyMagicSum(MAGIC_SQUARE_MATRIX));
  }

  @Test
  public void isEveryRowMagicSum() {
    assertTrue(MagicSquareChecker.isEveryRowMagicSum(MAGIC_SQUARE_MATRIX));
  }

  @Test
  public void isEveryRowMagicSum_notEqual() {
    assertFalse(MagicSquareChecker.isEveryRowMagicSum(ROWS_NOT_EQUAL_MATRIX));
  }

  @Test
  public void isEveryColMagicSum() {
    assertTrue(MagicSquareChecker.isEveryColMagicSum(MAGIC_SQUARE_MATRIX));
  }

  @Test
  public void isEveryColMagicSum_notEqual() {
    assertFalse(MagicSquareChecker.isEveryColMagicSum(COLS_NOT_EQUAL_MATRIX));
  }

  @Test
  public void isMagicSquare() {
    assertTrue(MagicSquareChecker.isMagicSquare(MAGIC_SQUARE_MATRIX));
  }

  @Test
  public void isMagicSquare_1x1() {
    assertTrue(MagicSquareChecker.isMagicSquare(SMALLEST_MAGIC_SQUARE_MATRIX));
  }
}
