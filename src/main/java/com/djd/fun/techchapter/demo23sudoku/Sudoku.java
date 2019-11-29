package com.djd.fun.techchapter.demo23sudoku;

import java.util.Stack;

public class Sudoku {

  private final Grid grid;
  private final Stack<Cell> unsolvedCells = new Stack();
  private final Stack<Cell> solvedCells = new Stack();

  public Sudoku() {
    int[][] gridSeed =
        new int[][] {
          {5, 3, 0, 0, 7, 0, 0, 0, 0},
          {6, 0, 0, 1, 9, 5, 0, 0, 0},
          {0, 9, 8, 0, 0, 0, 0, 6, 0},
          // ------------------------
          {8, 0, 0, 0, 6, 0, 0, 0, 3},
          {4, 0, 0, 8, 0, 3, 0, 0, 1},
          {7, 0, 0, 0, 2, 0, 0, 0, 6},
          // ------------------------
          {0, 6, 0, 0, 0, 0, 2, 8, 0},
          {0, 0, 0, 4, 1, 9, 0, 0, 5},
          {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    this.grid = new Grid(gridSeed);
    grid.getNonClueCells().forEach(unsolvedCells::push);
  }

  public void solve() {
    while (!unsolvedCells.empty()) {
      Cell cell = unsolvedCells.peek();
      if (cell.updateDigit()) {
        solvedCells.push(unsolvedCells.pop());
        grid.print();
      } else {
        backTrack();
      }
    }
  }

  /**
   * move cells from solved to unsolved until find a cell that can update digit to next candidate.
   * every cell in unsolved should be reset to 0.
   */
  private void backTrack() {
    while (!solvedCells.empty()) {
      Cell cell = solvedCells.peek();
      if (cell.updateDigit()) {
        return;
      }
      cell.resetCandidateIndex();
      unsolvedCells.push(solvedCells.pop());
    }
    grid.print();
    throw new IllegalStateException("SolvedCells should never be empty unless sudoku is solved.");
  }

  public void printCandidates() {
    grid.getNonClueCells()
        .forEach(
            cell ->
                System.out.println(
                    String.format("%s: %s", cell.getLocation(), cell.getCandidates())));
  }
}
