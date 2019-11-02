package com.djd.fun.techchapter.demo015magicsquare;

import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/** Immutable class that represents a square matrix of integers. */
public class SquareMatrix {
  private final int[][] matrix;
  private final int size;

  private SquareMatrix(Builder builder) {
    this.matrix = builder.matrix.clone();
    this.size = matrix.length;
  }

  public int size() {
    return size;
  }

  public int valueAt(int row, int col) {
    checkIndexes(size, row, col);
    return matrix[row][col];
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof SquareMatrix)) {
      return false;
    }
    SquareMatrix that = (SquareMatrix) obj;
    return Arrays.deepEquals(matrix, that.matrix);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(matrix);
  }

  @Override
  public String toString() {
    return matrixToString();
  }

  @VisibleForTesting
  String matrixToString() {
    int maxValue = matrix.length * matrix.length;
    int digits = 1 + (int) Math.log10(maxValue);
    String format = "%" + digits + "d";
    StringBuilder sb = new StringBuilder();
    for (int[] row : matrix) {
      for (int col : row) {
        sb.append(String.format(format, col));
        sb.append(' ');
      }
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }

  public static Builder builder(int[][] matrix) {
    final int size = matrix.length;
    Builder builder = new Builder(size);
    for (int rowIndex = 0; rowIndex < size; rowIndex++) {
      int[] col = matrix[rowIndex];
      if (col == null || col.length != size) {
        throw new IllegalArgumentException(
            String.format("%dx%d Square matrix required.", size, size));
      }
      for (int colIndex = 0; colIndex < size; colIndex++) {
        builder.setValueAt(matrix[rowIndex][colIndex], rowIndex, colIndex);
      }
    }
    return builder;
  }

  public static Builder builder(int size) {
    return new Builder(size);
  }

  private static void checkIndexes(int size, int rowIndex, int colIndex) {
    if (rowIndex < 0 || rowIndex >= size) {
      throw new IndexOutOfBoundsException("Invalid rowIndex: " + rowIndex);
    }
    if (colIndex < 0 || colIndex >= size) {
      throw new IndexOutOfBoundsException("Invalid colIndex: " + colIndex);
    }
  }

  public static class Builder {
    private final int[][] matrix;
    private final int size;

    private Builder(int size) {

      if (size < 1) {
        throw new IllegalArgumentException("size should be > 0");
      }
      this.matrix = new int[size][size];
      this.size = size;
    }

    public Builder setValueAt(int value, int rowIndex, int colIndex) {
      checkIndexes(size, rowIndex, colIndex);
      if (matrix[rowIndex][colIndex] != 0) {
        // TODO warn value override
      }
      matrix[rowIndex][colIndex] = value;
      return this;
    }

    public SquareMatrix build() {
      return new SquareMatrix(this);
    }
  }
}
