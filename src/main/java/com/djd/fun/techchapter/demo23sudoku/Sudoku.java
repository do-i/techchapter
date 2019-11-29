package com.djd.fun.techchapter.demo23sudoku;

import com.google.common.base.Stopwatch;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sudoku {

  private static final Logger log = LoggerFactory.getLogger(Sudoku.class);
  private final Grid grid;
  private final Stack<Cell> unsolvedCells = new Stack<>();
  private final Stack<Cell> solvedCells = new Stack<>();
  private final AtomicInteger transitionCount = new AtomicInteger();

  public Sudoku(int[][] gridSeed) {
    this.grid = new Grid(gridSeed);
    grid.getNonClueCells().forEach(unsolvedCells::push);
  }

  public void solve() {
    Stopwatch stopwatch = Stopwatch.createStarted();
    while (!unsolvedCells.empty()) {
      Cell cell = unsolvedCells.peek();
      if (cell.updateDigit()) {
        solvedCells.push(unsolvedCells.pop());
        transitionCount.incrementAndGet();
      } else {
        backTrack();
      }
    }
    stopwatch.stop();
    grid.print(transitionCount.get());
    log.info("Took {} to solve Sudoku.", stopwatch.toString());
  }

  /**
   * move cells from solved to unsolved until find a cell that can update digit to next candidate.
   * every cell in unsolved should be reset to 0.
   */
  private void backTrack() {
    grid.print(transitionCount.get());
    while (!solvedCells.empty()) {
      Cell cell = solvedCells.peek();
      if (cell.updateDigit()) {
        transitionCount.incrementAndGet();
        return;
      }
      transitionCount.incrementAndGet();
      cell.resetCandidateIndex();
      unsolvedCells.push(solvedCells.pop());
    }
    throw new IllegalStateException("SolvedCells should never be empty unless sudoku is solved.");
  }

  public void printCandidates() {
    grid.getNonClueCells()
        .forEach(cell -> log.info("{}: {}", cell.getLocation(), cell.getCandidates()));
  }
}
