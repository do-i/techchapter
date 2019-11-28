package com.djd.fun.techchapter.demo23sudoku;

import static com.google.common.base.Preconditions.checkPositionIndex;

import java.util.Objects;

/** Sudoku location is 9x9 */
public class Location {

  private final int rowIndex;
  private final int colIndex;

  private Location(int rowIndex, int colIndex) {
    this.rowIndex = checkPositionIndex(rowIndex, 8);
    this.colIndex = checkPositionIndex(colIndex, 8);
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public int getColIndex() {
    return colIndex;
  }

  public static int checkIndex(int value) {
    return checkPositionIndex(value, 9);
  }

  public static Location of(int rowIndex, int colIndex) {
    return new Location(rowIndex, colIndex);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return rowIndex == location.rowIndex && colIndex == location.colIndex;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rowIndex, colIndex);
  }

  @Override
  public String toString() {
    return String.format("@(%d,%d)", rowIndex, colIndex);
  }
}
