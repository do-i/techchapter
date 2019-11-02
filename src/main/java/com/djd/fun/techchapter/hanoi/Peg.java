package com.djd.fun.techchapter.hanoi;

import com.google.common.collect.ImmutableList;
import java.util.Optional;
import java.util.Stack;

/** A representation of a peg in Tower of Hanoi. */
public class Peg {
  private final Stack<Disk> disks;

  public Peg() {
    this.disks = new Stack<>();
  }

  /**
   * Adds given disk to this peg if current peg is empty. If the peg is not empty, then check if the
   * top disk size is bigger than the incoming disk size.
   *
   * @param disk to be added on this peg
   * @return {@code true} if the disk is added to the peg. {@code false} otherwise
   */
  public boolean addDisk(Disk disk) {
    if (!isEmpty()) {
      if (disk.isNotSmallerThan(disks.peek())) {
        return false;
      }
    }
    return disks.add(disk);
  }

  /**
   * Removes top disk from this peg if exists.
   *
   * @return {@link Optional} of {@link Disk} if exists. {@link Optional#empty()} otherwise.
   */
  public Optional<Disk> removeDisk() {
    if (isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(disks.pop());
  }

  /** @return {@code true} if this peg has no disks. {@code false} otherwise. */
  public boolean isEmpty() {
    return disks.isEmpty();
  }

  public int size() {
    return disks.size();
  }

  /** empty the peg */
  public void clear() {
    disks.clear();
  }

  public ImmutableList<Disk> getDisks() {
    return ImmutableList.copyOf(disks);
  }

  @Override
  public String toString() {
    return disks.toString();
  }
}
