package com.djd.fun.techchapter.demo23sudoku;

public class Data {

  public static final int[][] ONE_STAR_SUDOKU = {
    {5, 1, 7, 0, 6, 0, 0, 3, 8},
    {0, 0, 0, 5, 0, 3, 0, 4, 0},
    {0, 0, 0, 7, 8, 9, 0, 1, 0},
    // ------------------------
    {3, 0, 1, 8, 0, 5, 0, 0, 4},
    {0, 2, 6, 0, 7, 0, 8, 5, 0},
    {9, 0, 0, 4, 0, 6, 1, 0, 3},
    // ------------------------
    {0, 9, 0, 1, 3, 7, 0, 0, 0},
    {0, 6, 0, 9, 0, 2, 0, 0, 0},
    {1, 3, 0, 0, 4, 0, 7, 9, 2}
  };
  public static final int[][] WORLD_HARDEST = {
    {8, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 0, 3, 6, 0, 0, 0, 0, 0},
    {0, 7, 0, 0, 9, 0, 2, 0, 0},
    // ------------------------
    {0, 5, 0, 0, 0, 7, 0, 0, 0},
    {0, 0, 0, 0, 4, 5, 7, 0, 0},
    {0, 0, 0, 1, 0, 0, 0, 3, 0},
    // ------------------------
    {0, 0, 1, 0, 0, 0, 0, 6, 8},
    {0, 0, 8, 5, 0, 0, 0, 1, 0},
    {0, 9, 0, 0, 0, 0, 4, 0, 0}
  };

  /** Took 32 seconds with 2,960,594 transitions. */
  public static final int[][] WORLD_HARDEST_SOLUTION = {
    {8, 1, 2, 7, 5, 3, 6, 4, 9},
    {9, 4, 3, 6, 8, 2, 1, 7, 5},
    {6, 7, 5, 4, 9, 1, 2, 8, 3},
    // ------------------------
    {1, 5, 4, 2, 3, 7, 8, 9, 6},
    {3, 6, 9, 8, 4, 5, 7, 2, 1},
    {2, 8, 7, 1, 6, 9, 5, 3, 4},
    // ------------------------
    {5, 2, 1, 9, 7, 4, 3, 6, 8},
    {4, 3, 8, 5, 2, 6, 9, 1, 7},
    {7, 9, 6, 3, 1, 8, 4, 5, 2}
  };

  public static final int[][] FIVE_STAR_SUDOKU = {
    {0, 1, 0, 0, 0, 0, 0, 0, 0},
    {7, 0, 0, 4, 0, 0, 0, 0, 2},
    {0, 5, 3, 0, 7, 0, 0, 0, 0},
    // ------------------------
    {4, 0, 0, 6, 0, 0, 0, 0, 0},
    {8, 7, 0, 0, 3, 0, 0, 9, 5},
    {0, 0, 0, 0, 0, 2, 0, 0, 1},
    // ------------------------
    {0, 0, 0, 0, 9, 0, 5, 7, 0},
    {6, 0, 0, 0, 0, 8, 0, 0, 9},
    {0, 0, 0, 0, 0, 0, 0, 3, 0}
  };

  public static final int[][] WIKI_DATA = {
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
  public static final int[][] WIKI_DATA_SOLOTION = {
    {5, 3, 4, 6, 7, 8, 9, 1, 2},
    {6, 7, 2, 1, 9, 5, 3, 4, 8},
    {1, 9, 8, 3, 4, 2, 5, 6, 7},
    // ------------------------
    {8, 5, 9, 7, 6, 1, 4, 2, 3},
    {4, 2, 6, 8, 5, 3, 7, 9, 1},
    {7, 1, 3, 9, 2, 4, 8, 5, 6},
    // ------------------------
    {9, 6, 1, 5, 3, 7, 2, 8, 4},
    {2, 8, 7, 4, 1, 9, 6, 3, 5},
    {3, 4, 5, 2, 8, 6, 1, 7, 9}
  };

  public static final int[][] DEBUG_DATA_WORKS = {
    {0, 0, 4, 0, 7, 8, 9, 1, 2},
    {0, 7, 2, 0, 9, 5, 3, 4, 8},
    {0, 0, 0, 3, 4, 2, 5, 6, 7},
    // ------------------------
    {0, 0, 9, 7, 6, 1, 4, 2, 3},
    {4, 2, 6, 8, 5, 3, 7, 9, 1},
    {7, 1, 3, 9, 2, 4, 8, 5, 6},
    // ------------------------
    {9, 6, 1, 5, 3, 7, 2, 8, 4},
    {2, 8, 7, 4, 1, 9, 6, 3, 5},
    {3, 4, 5, 2, 8, 6, 1, 7, 9}
  };

  // @(3,2)->0 breaks at step 8 ... it turned out candidateIndex failed to reset to -1
  public static final int[][] DEBUG_DATA_BREAKS = {
    {0, 0, 4, 0, 7, 8, 9, 1, 2},
    {0, 7, 2, 0, 9, 5, 3, 4, 8},
    {0, 0, 0, 3, 4, 2, 5, 6, 7},
    // ------------------------
    {0, 0, 0, 7, 6, 1, 4, 2, 3},
    {4, 2, 6, 8, 5, 3, 7, 9, 1},
    {7, 1, 3, 9, 2, 4, 8, 5, 6},
    // ------------------------
    {9, 6, 1, 5, 3, 7, 2, 8, 4},
    {2, 8, 7, 4, 1, 9, 6, 3, 5},
    {3, 4, 5, 2, 8, 6, 1, 7, 9}
  };
}
