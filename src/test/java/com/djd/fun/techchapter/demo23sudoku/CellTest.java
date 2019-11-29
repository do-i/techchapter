package com.djd.fun.techchapter.demo23sudoku;

import static com.djd.fun.techchapter.demo23sudoku.GridTest.createGrid;
import static com.google.common.truth.Truth.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CellTest {

  private Grid grid;

  @Before
  public void setUp() {
    grid = createGrid();
  }

  @Test
  public void initializeCandidates() {
    Cell cell = grid.getCellAt(Location.of(1, 2));
    assertThat(cell.getCandidates()).containsExactly(2, 4, 7);
  }

  @Test(expected = IllegalStateException.class)
  public void initializeCandidates_moreThanOnce_error() {
    Cell cell = grid.getCellAt(Location.of(1, 2));
    cell.initializeCandidates();
    cell.initializeCandidates();
  }

  @Test
  public void getLocation() {
    Cell cell = grid.getCellAt(Location.of(1, 2));
    assertThat(cell.getLocation()).isEqualTo(Location.of(1, 2));
  }

  @Test
  public void getDigit() {
    Cell cell = grid.getCellAt(Location.of(3, 4));
    assertThat(cell.getDigit()).isEqualTo(6);
  }

  @Test
  public void isClueCell() {
    Cell cell = grid.getCellAt(Location.of(3, 4));
    assertThat(cell.isClueCell()).isTrue();
  }

  @Test
  public void isClueCell_no() {
    Cell cell = grid.getCellAt(Location.of(2, 0));
    assertThat(cell.isClueCell()).isFalse();
  }

  @Test
  public void isCellAt() {
    Cell cell = grid.getCellAt(Location.of(2, 0));
    assertThat(cell.isCellAt(Location.of(2, 0))).isTrue();
  }

  @Test
  public void isCellAt_no() {
    Cell cell = grid.getCellAt(Location.of(2, 0));
    assertThat(cell.isCellAt(Location.of(0, 2))).isFalse();
  }

  @Test(expected = IllegalStateException.class)
  public void resetCandidateIndex_clueCell_error() {
    Cell cell = grid.getCellAt(Location.of(0, 0));
    cell.resetCandidateIndex();
  }

  @Test
  public void resetCandidateIndex() {
    Cell cell = grid.getCellAt(Location.of(1,1));
    cell.updateDigit();
    assertThat(cell.getDigit()).isNotEqualTo(0);
    cell.resetCandidateIndex();
    assertThat(cell.getDigit()).isEqualTo(0);
  }

  @Test
  public void updateDigit() {
    Cell cell = grid.getCellAt(Location.of(1,1));
    assertThat(cell.getDigit()).isEqualTo(0);
    cell.updateDigit();
    assertThat(cell.getDigit()).isEqualTo(2);
    cell.updateDigit();
    assertThat(cell.getDigit()).isEqualTo(4);
    cell.updateDigit();
    assertThat(cell.getDigit()).isEqualTo(7);
    assertThat(cell.updateDigit()).isFalse();
    assertThat(cell.getDigit()).isEqualTo(7);
  }
}
