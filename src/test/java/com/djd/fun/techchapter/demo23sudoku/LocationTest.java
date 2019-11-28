package com.djd.fun.techchapter.demo23sudoku;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

public class LocationTest {

  @Test
  public void equalities() {
    new EqualsTester()
        .addEqualityGroup(Location.of(0, 0), Location.of(0, 0))
        .addEqualityGroup(Location.of(0, 1))
        .addEqualityGroup(Location.of(1, 0))
        .testEquals();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void boundary_tooSmallRow() {
    Location.of(-1, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void boundary_tooSmallCol() {
    Location.of(0, -1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void boundary_tooLargeRow() {
    Location.of(9, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void boundary_tooLargeCol() {
    Location.of(0, 9);
  }
}
