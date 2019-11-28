package com.djd.fun.techchapter.demo23sudoku;

import static com.djd.fun.techchapter.demo23sudoku.Sudoku.checkDigit;

import java.util.List;

/** Represents mutable cell in Sudoku grid. */
public class Cell {

  private final Grid grid;

  private final Location location;

  private final boolean isClueCell;
  private List<Integer>
      candidates; // This reference is not immutable but element of this list is immutable.
  private int digit;
  public Cell(Location location, int initialDigit, Grid grid) {
    this.location = location;
    this.isClueCell = initialDigit == 0;
    this.digit = checkDigit(initialDigit);
    this.grid = grid;
  }

  /**
   * Initialize candidates. Candidates are a set of digit that does not exist in its row, col, box.
   */
  public void initializeCandidates() {}

  public Location getLocation() {
    return location;
  }

  public int getDigit() {
    return digit;
  }

  public boolean isClueCell() {
    return isClueCell;
  }
}
