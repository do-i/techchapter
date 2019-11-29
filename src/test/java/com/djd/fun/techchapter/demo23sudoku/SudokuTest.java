package com.djd.fun.techchapter.demo23sudoku;

import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

  private Sudoku sudoku;

  @Before
  public void setUp() {
    sudoku = new Sudoku();
  }

  @Test
  public void solve() {
    sudoku.printCandidates();
    sudoku.solve();
  }
}
