package com.djd.fun.techchapter.demo23sudoku;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableSet;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

  private Grid grid;

  @Before
  public void setUp() {
    grid = createGrid();
  }

  @Test
  public void getCellAt_0x0() {
    Cell cell = grid.getCellAt(Location.of(0, 0));
    assertThat(cell.getDigit()).isEqualTo(5);
    assertThat(cell.getLocation()).isEqualTo(Location.of(0, 0));
  }

  @Test
  public void getCellAt_8x7() {
    Cell cell = grid.getCellAt(Location.of(8, 7));
    assertThat(cell.getDigit()).isEqualTo(7);
    assertThat(cell.getLocation()).isEqualTo(Location.of(8, 7));
  }

  @Test
  public void getCellsInBox1() {
    assertThat(
            grid.getCellsInBox(Location.of(1, 1)).stream()
                .map(Cell::getDigit)
                .collect(ImmutableSet.toImmutableSet()))
        .containsExactly(0, 5, 6, 3, 9, 8);
  }

  @Test
  public void getCellsInBox8() {
    assertThat(
            grid.getCellsInBox(Location.of(8, 3)).stream()
                .map(Cell::getDigit)
                .collect(ImmutableSet.toImmutableSet()))
        .containsExactly(0, 4, 1, 9, 8);
  }

  @Test
  public void getCellsInRow() {
    assertThat(
            grid.getCellsInRow(Location.of(5, 0)).stream()
                .map(Cell::getDigit)
                .collect(ImmutableSet.toImmutableSet()))
        .containsExactly(0, 7, 2, 6);
  }

  @Test
  public void getCellsInCol() {
    assertThat(
            grid.getCellsInCol(Location.of(5, 0)).stream()
                .map(Cell::getDigit)
                .collect(ImmutableSet.toImmutableSet()))
        .containsExactly(0, 5, 6, 8, 4, 7);
  }

  @Test
  public void isInvalidCandidate_1x2_8yes() {
    assertThat(grid.isInvalidCandidate(Location.of(1, 2), 8)).isTrue();
  }

  @Test
  public void isInvalidDigitAt_1x2_7no() {
    assertThat(grid.isInvalidCandidate(Location.of(1, 2), 7)).isFalse();
  }

  @Test
  public void isValidCandidate_1x2_8no() {
    assertThat(grid.isValidCandidate(Location.of(1, 2), 8)).isFalse();
  }

  @Test
  public void isValidCandidate_1x2_7yes() {
    assertThat(grid.isValidCandidate(Location.of(1, 2), 7)).isTrue();
  }

  @Test
  public void getCellStream() {
    assertThat(grid.getCellStream().count()).isEqualTo(81);
  }

  @Test
  public void getNonClueCells() {
    List<Cell> cells = grid.getNonClueCells();
    assertThat(cells).hasSize(51);
    cells.forEach(cell -> assertThat(cell.getDigit()).isEqualTo(0));
  }

  public static Grid createGrid() {
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
    return new Grid(gridSeed);
  }
}
