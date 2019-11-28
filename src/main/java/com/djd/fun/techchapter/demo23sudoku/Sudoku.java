package com.djd.fun.techchapter.demo23sudoku;

public class Sudoku {

  public static int checkDigit(int value) {
    if (value >= 0 && value <= 9) {
      return value;
    }
    throw new IllegalArgumentException(String.format("Value {%d} must be between 0 and 9.", value));
  }

  public static boolean isValueUnique(Cell cell, Grid grid) {
    throw new UnsupportedOperationException("TODO");
  }

  private static boolean isDigitInRow(Cell cell, Grid grid) {
    throw new UnsupportedOperationException("TODO");
  }

  private static boolean isDigitInCol(Cell cell, Grid grid) {
    throw new UnsupportedOperationException("TODO");
  }

  private static boolean isDigitInBox(Cell cell, Grid grid) {
    Location location = cell.getLocation();
    int boxRowMin = computeBoxBoundMinIndex(location.getRowIndex());
    int boxColMin = computeBoxBoundMinIndex(location.getColIndex());
    for (int rowIdx = boxRowMin; rowIdx < boxRowMin+3; rowIdx++) {

    }
//    grid.getCellAt(l)
    throw new UnsupportedOperationException("TODO");
  }

  private static int computeBoxBoundMinIndex(int cellIndex) {
    return (cellIndex / 3) * 3;
  }
}
