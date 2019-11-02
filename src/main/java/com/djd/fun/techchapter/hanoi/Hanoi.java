package com.djd.fun.techchapter.hanoi;

import com.djd.fun.util.MorePreconditions;
import com.google.common.collect.ImmutableList;
import java.util.Optional;

/** A representation of Tower of Hanoi. */
public class Hanoi {

  private final Peg left;
  private final Peg middle;
  private final Peg right;

  /** Initializes with 3 disks. */
  public Hanoi() {
    this(3);
  }

  /**
   * Initializes with the given number of disks.
   *
   * @param numOfDisks
   */
  public Hanoi(int numOfDisks) {
    MorePreconditions.checkPositiveIntegers(numOfDisks);
    this.left = new Peg();
    this.middle = new Peg();
    this.right = new Peg();
    initialize(numOfDisks);
  }

  public void initialize(int numOfDisks) {
    for (int i = numOfDisks; i > 0; i--) {
      this.left.addDisk(new Disk(i));
    }
  }

  public void reset(int numOfDisks) {
    left.clear();
    middle.clear();
    right.clear();
    initialize(numOfDisks);
  }

  /** @return {@code true} if all disks are on right peg */
  public boolean isDone() {
    return left.isEmpty() && middle.isEmpty();
  }

  public boolean move(States.Move move) {
    switch (move) {
      case LEFT_TO_RIGHT:
        return moveLeftToRight();
      case LEFT_TO_MIDDLE:
        return moveLeftToMiddle();
      case MIDDLE_TO_LEFT:
        return moveMiddleToLeft();
      case MIDDLE_TO_RIGHT:
        return moveMiddleToRight();
      case RIGHT_TO_LEFT:
        return moveRightToLeft();
      case RIGHT_TO_MIDDLE:
        return moveRightToMiddle();
      default:
        throw new IllegalStateException("There is not such case: " + move);
    }
  }

  private boolean moveLeftToMiddle() {
    Optional<Disk> disk = left.removeDisk();
    return disk.isPresent() && middle.addDisk(disk.get());
  }

  private boolean moveLeftToRight() {
    Optional<Disk> disk = left.removeDisk();
    return disk.isPresent() && right.addDisk(disk.get());
  }

  private boolean moveMiddleToLeft() {
    Optional<Disk> disk = middle.removeDisk();
    return disk.isPresent() && left.addDisk(disk.get());
  }

  private boolean moveMiddleToRight() {
    Optional<Disk> disk = middle.removeDisk();
    return disk.isPresent() && right.addDisk(disk.get());
  }

  private boolean moveRightToLeft() {
    Optional<Disk> disk = right.removeDisk();
    return disk.isPresent() && left.addDisk(disk.get());
  }

  private boolean moveRightToMiddle() {
    Optional<Disk> disk = right.removeDisk();
    return disk.isPresent() && middle.addDisk(disk.get());
  }

  public ImmutableList<Disk> getDisksOnLeftPeg() {
    return left.getDisks();
  }

  public ImmutableList<Disk> getDisksOnMiddlePeg() {
    return middle.getDisks();
  }

  public ImmutableList<Disk> getDisksOnRightPeg() {
    return right.getDisks();
  }

  @Override
  public String toString() {
    return String.format("L:%s, M:%s, R:%s", left, middle, right);
  }
}
