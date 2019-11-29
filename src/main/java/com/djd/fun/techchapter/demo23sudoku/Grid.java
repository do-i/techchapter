package com.djd.fun.techchapter.demo23sudoku;

import static java.util.function.Predicate.not;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/** Represents a mutable Sudoku Grid. grid is initialized 9x9 with zeros */
public class Grid {

  private static final int SIZE = 9;
  private final Cell[][] grid = new Cell[SIZE][SIZE];

  /** @param initialGrid 9x9 grid */
  public Grid(int[][] initialGrid) {
    // First place all digits in the grid.
    for (int r = 0; r < SIZE; r++) {
      for (int c = 0; c < SIZE; c++) {
        grid[r][c] = new Cell(Location.of(r, c), initialGrid[r][c], this);
      }
    }
    // Then, initialize each cell with candidates
    toCellStream(grid).forEach(Cell::initializeCandidates);
  }

  public Cell getCellAt(Location location) {
    return grid[location.getRowIndex()][location.getColIndex()];
  }

  public List<Cell> getNonClueCells() {
    return getCellStream()
        .filter(not(Cell::isClueCell))
        .sorted(Comparator.<Cell, Integer>comparing(cell -> cell.getCandidates().size()).reversed())
        .collect(ImmutableList.toImmutableList());
  }

  /** @return nine cells in a box for a give location */
  public List<Cell> getCellsInBox(Location location) {
    final Range<Integer> rowRange = computeBoxRange(location.getRowIndex());
    final Range<Integer> colRange = computeBoxRange(location.getColIndex());
    Predicate<Cell> isCellWithinBox =
        cell -> {
          Location inLocation = cell.getLocation();
          return rowRange.contains(inLocation.getRowIndex())
              && colRange.contains(inLocation.getColIndex());
        };
    return getCellStream().filter(isCellWithinBox).collect(ImmutableList.toImmutableList());
  }

  /** @return nine cells in a row for a given location */
  public List<Cell> getCellsInRow(Location location) {
    return getCellStream()
        .filter(cell -> cell.getLocation().getRowIndex() == location.getRowIndex())
        .collect(ImmutableList.toImmutableList());
  }

  /** @return nine cells in a row for a given location */
  public List<Cell> getCellsInCol(Location location) {
    return getCellStream()
        .filter(cell -> cell.getLocation().getColIndex() == location.getColIndex())
        .collect(ImmutableList.toImmutableList());
  }

  /** @return {@code true} if given digit exists in a row, col, and box at the given location. */
  public boolean isInvalidCandidate(Location location, int digit) {
    Predicate<Cell> digitExist = cell -> cell.getDigit() == digit;
    return getCellsInRow(location).stream().anyMatch(digitExist)
        || getCellsInCol(location).stream().anyMatch(digitExist)
        || getCellsInBox(location).stream().anyMatch(digitExist);
  }

  public boolean isValidCandidate(Location location, int digit) {
    return !isInvalidCandidate(location, digit);
  }

  private static Range<Integer> computeBoxRange(int cellIndex) {
    int lowBound = (cellIndex / 3) * 3;
    return Range.closedOpen(lowBound, lowBound + 3);
  }

  @VisibleForTesting
  Stream<Cell> getCellStream() {
    return toCellStream(grid);
  }

  private static Stream<Cell> toCellStream(Cell[][] grid) {
    return Stream.of(grid).flatMap(Stream::of);
  }

  private static int printCount = 0;

  public void print() {
    System.out.println("   0__1__2__3__4__5__6__7__8");
    int rowIdx = 0;
    for (Cell[] row : grid) {
      System.out.println(rowIdx++ + " " + Arrays.toString(row));
    }
    System.out.println(String.format("============= %d ==============", printCount++));
  }
}
