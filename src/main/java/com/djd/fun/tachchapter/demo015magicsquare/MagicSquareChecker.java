package com.djd.fun.tachchapter.demo015magicsquare;

import com.google.common.annotations.VisibleForTesting;

/**
 */
public class MagicSquareChecker {

  /**
   * Determine whether the given matrix is a magic square or not.
   *
   * @param matrix
   * @return {@code true} if the given matrix is a magic square. {@code false} otherwise.
   */
  public static boolean isMagicSquare(SquareMatrix matrix) {
    if (checkUniq(matrix)) {
      int sumDiagonals = sumDiagonals(matrix);
      if (sumDiagonals == -1) {
        return false;
      }
      int sumRows = sumRows(matrix);
      if (sumRows == -1) {
        return false;
      }
      int sumCols = sumCols(matrix);
      if (sumCols == -1) {
        return false;
      }
      return sumDiagonals == sumRows && sumRows == sumCols;
    }
    return false;
  }

  @VisibleForTesting static boolean checkValueRange(SquareMatrix matrix) {
    int matrixSize = matrix.size();
    int maxValue = matrixSize * matrixSize;
    for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
      for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
        int value = matrix.valueAt(rowIndex, colIndex);
        if (value < 1 || value > maxValue) {
          return false;
        }
      }
    }
    return true;
  }

  @VisibleForTesting static boolean checkUniq(SquareMatrix matrix) {
    if (!checkValueRange(matrix)) {
      return false;
    }
    int matrixSize = matrix.size();
    int maxValue = matrixSize * matrixSize;
    boolean[] flag = new boolean[maxValue];
    for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
      for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
        int value = matrix.valueAt(rowIndex, colIndex);
        int flagIndex = value - 1;
        if (flag[flagIndex]) {
          // duplicate found
          return false;
        } else {
          flag[flagIndex] = true;
        }
      }
    }
    return true;
  }

  @VisibleForTesting static int sumDiagonals(SquareMatrix matrix) {
    int matrixSize = matrix.size();
    int backslashSum = 0;
    int forwardSlashSum = 0;
    for (int index = 0; index < matrixSize; index++) {
      backslashSum += matrix.valueAt(index, index);
      forwardSlashSum += matrix.valueAt(index, matrixSize - 1 - index);
    }
    return backslashSum == forwardSlashSum ? forwardSlashSum : -1;
  }

  @VisibleForTesting static int sumRows(SquareMatrix matrix) {
    int prevRow = 0;
    int matrixSize = matrix.size();
    for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
      int sumRow = 0;
      for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
        sumRow += matrix.valueAt(rowIndex, colIndex);
      }
      if (rowIndex == 0) {
        prevRow = sumRow;
      } else if (prevRow != sumRow) {
        return -1;
      }
    }
    return prevRow;
  }

  @VisibleForTesting static int sumCols(SquareMatrix matrix) {
    int prevCol = 0;
    int matrixSize = matrix.size();
    for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
      int sumCol = 0;
      for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
        sumCol += matrix.valueAt(rowIndex, colIndex);
      }
      if (colIndex == 0) {
        prevCol = sumCol;
      } else if (prevCol != sumCol) {
        return -1;
      }
    }
    return prevCol;
  }
}