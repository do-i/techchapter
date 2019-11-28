package com.djd.fun.techchapter.demo23sudoku;

public class Main {

  public static void main(String[] args) {
    Sudoku sudoku = new Sudoku(Data.BOOK_DATA);
    sudoku.solve();
    sudoku.printCandidates();
  }
}
