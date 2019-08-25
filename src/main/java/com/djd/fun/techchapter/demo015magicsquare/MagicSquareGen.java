package com.djd.fun.techchapter.demo015magicsquare;

public class MagicSquareGen {

  public static SquareMatrix createSquareMatrix(int size) {
    if (size < 1 || size == 2) {
      throw new IllegalArgumentException("Invalid size.");
    }
    if (size == 1) {
      return SquareMatrix.builder(1).setValueAt(1, 0, 0).build();
    }

    switch (size) {
      case 3:
        return create3x3MagicSquare();
      default:
        throw new UnsupportedOperationException("Currently not supported for size " + size);

    }
  }

  private static SquareMatrix create3x3MagicSquare() {
    // brute force using permutation of O(9!) time complexity
    // use 1,2,3,4,5,6,7,8,9
    throw new UnsupportedOperationException("TODO");
  }

}
