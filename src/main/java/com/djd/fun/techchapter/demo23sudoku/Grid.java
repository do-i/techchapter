package com.djd.fun.techchapter.demo23sudoku;

/** Represents a mutable Sudoku Grid. grid is initialized 9x9 with zeros */
public class Grid {
  private static final int SIZE = 9;
  private final Cell[][] grid = new Cell[SIZE][SIZE];

  public Grid() {}

  /** @param initialGrid 9x9 grid */
  public Grid(int[][] initialGrid) {
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        grid[r][c] = new Cell(Location.of(r, c), initialGrid[r][c], this);
      }
    }
  }

  public Cell getCellAt(Location location) {
    return grid[location.getRowIndex()][location.getColIndex()];
  }

}
