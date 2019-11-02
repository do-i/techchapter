package com.djd.fun.techchapter.demo015magicsquare;

import com.google.common.annotations.VisibleForTesting;

/** */
public class MagicSquareChecker {

  /**
   * Determine whether the given matrix is a magic square or not.
   *
   * @param matrix
   * @return {@code true} if the given matrix is a magic square. {@code false} otherwise.
   */
  public static boolean isMagicSquare(SquareMatrix matrix) {
    if (matrix.size() == 0 || matrix.size() == 2) {
      return false;
    }
    return checkUniq(matrix)
        && isDiagonalyMagicSum(matrix)
        && isEveryRowMagicSum(matrix)
        && isEveryColMagicSum(matrix);
  }

  /**
   * Magic Sum is n(n^2+1)/2, where n is size of the matrix
   *
   * @param size
   * @return magic sum
   */
  @VisibleForTesting
  static int magicSum(int size) {
    return size * ((size * size) + 1) / 2;
  }

  @VisibleForTesting
  static boolean checkValueRange(SquareMatrix matrix) {
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

  @VisibleForTesting
  static boolean checkUniq(SquareMatrix matrix) {
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

  @VisibleForTesting
  static boolean isDiagonalyMagicSum(SquareMatrix matrix) {
    final int matrixSize = matrix.size();
    int backslashSum = 0;
    int forwardSlashSum = 0;
    for (int index = 0; index < matrixSize; index++) {
      backslashSum += matrix.valueAt(index, index);
      forwardSlashSum += matrix.valueAt(index, matrixSize - 1 - index);
    }
    return backslashSum == forwardSlashSum && forwardSlashSum == magicSum(matrixSize);
  }

  @VisibleForTesting
  static boolean isEveryRowMagicSum(SquareMatrix matrix) {
    final int matrixSize = matrix.size();
    final int magicSum = magicSum(matrixSize);
    for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
      int sumRow = 0;
      for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
        sumRow += matrix.valueAt(rowIndex, colIndex);
      }
      if (sumRow != magicSum) {
        return false;
      }
    }
    return true;
  }

  @VisibleForTesting
  static boolean isEveryColMagicSum(SquareMatrix matrix) {
    final int matrixSize = matrix.size();
    final int magicSum = magicSum(matrixSize);
    for (int colIndex = 0; colIndex < matrixSize; colIndex++) {
      int sumCol = 0;
      for (int rowIndex = 0; rowIndex < matrixSize; rowIndex++) {
        sumCol += matrix.valueAt(rowIndex, colIndex);
      }
      if (sumCol != magicSum) {
        return false;
      }
    }
    return true;
  }
}
