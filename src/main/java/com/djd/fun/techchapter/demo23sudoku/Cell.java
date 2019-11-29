package com.djd.fun.techchapter.demo23sudoku;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.StringJoiner;

/** Represents mutable cell in Sudoku grid. */
public class Cell {

  private final Grid grid;
  private final Location location;
  private final boolean isClueCell;
  /* This reference is not immutable but element of this list is immutable. */
  private List<Integer> candidates = List.of();
  private boolean isCandidatesInitialized;
  private int candidateIndex;
  private int digit;

  public Cell(Location location, int initialDigit, Grid grid) {
    this.location = location;
    this.isClueCell = initialDigit != 0;
    this.candidateIndex = -1;
    this.isCandidatesInitialized = isClueCell;
    this.digit = checkDigit(initialDigit);
    this.grid = grid;
  }

  /**
   * Initialize candidates. Candidates are a set of digit that does not exist in its row, col, box.
   */
  public void initializeCandidates() {
    if (isClueCell) {
      /* If this is a clue cell, candidates is empty and already initialized during instance creation. */
      return;
    }
    if (isCandidatesInitialized) {
      throw new IllegalStateException("Cell has already initialized.");
    }
    isCandidatesInitialized = true;
    ImmutableList.Builder<Integer> candidates = ImmutableList.builder();
    for (int digit = 1; digit <= 9; digit++) {
      if (grid.isValidCandidate(location, digit)) {
        candidates.add(digit);
      }
    }
    this.candidates = candidates.build();
  }

  @VisibleForTesting
  List<Integer> getCandidates() {
    checkCandidatesInitialized();
    return candidates;
  }

  public Location getLocation() {
    return location;
  }

  public int getDigit() {
    return digit;
  }

  public boolean isClueCell() {
    return isClueCell;
  }

  public boolean isCellAt(Location location) {
    return this.location.equals(location);
  }

  private boolean hasNextCandidate() {
    checkCandidatesInitialized();
    return candidates.size() > candidateIndex + 1;
  }

  private void checkCandidatesInitialized() {
    if (isCandidatesInitialized) {
      return;
    }
    throw new IllegalStateException("Cell must be initialized first.");
  }

  private static int checkDigit(int value) {
    if (value >= 0 && value <= 9) {
      return value;
    }
    throw new IllegalArgumentException(String.format("Value {%d} must be between 0 and 9.", value));
  }

  /*
  Mutators
   */

  public void resetCandidateIndex() {
    checkCandidatesInitialized();
    if (isClueCell) {
      throw new IllegalStateException("Clue Cell cannot be reset");
    }
    this.candidateIndex = -1;
    this.digit = 0;
  }

  /**
   * Sets {@link #digit} to next possible candidate which is valid on the current state of the grid.
   *
   * @return {@code true} if valid candidate is found and digit is updated. {@code false} otherwise.
   */
  public boolean updateDigit() {
    checkCandidatesInitialized();
    if (isClueCell) {
      throw new IllegalStateException("Clue Cell cannot be updated");
    }
    while (hasNextCandidate()) {
      int cadidateDigit = candidates.get(++candidateIndex);
      if (grid.isValidCandidate(location, cadidateDigit)) {
        digit = cadidateDigit;
        return true;
      }
    }
    // BugFix: Without this candidateIndex would not reset to -1 even digit is zero.
    resetCandidateIndex();
    return false;
  }

  @Override
  public String toString() {
    return String.valueOf(digit);
  }
}
