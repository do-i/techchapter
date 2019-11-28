package com.djd.fun.techchapter.demo23sudoku;

public class Location {

  private final int rowIndex;
  private final int colIndex;

  private Location(int rowIndex, int colIndex) {
    this.rowIndex = rowIndex;
    this.colIndex = colIndex;
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public int getColIndex() {
    return colIndex;
  }

  public static Location of(int rowIndex, int colIndex) {
    return new Location(rowIndex, colIndex);
  }
}
