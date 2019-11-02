package com.djd.fun.techchapter.hanoi;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Comparators;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class State {

  private final ImmutableList<Disk> leftPeg;
  private final ImmutableList<Disk> middlePeg;
  private final ImmutableList<Disk> rightPeg;

  private State(Builder builder) {
    this.leftPeg = ImmutableList.copyOf(builder.leftPeg);
    this.middlePeg = ImmutableList.copyOf(builder.middlePeg);
    this.rightPeg = ImmutableList.copyOf(builder.rightPeg);
    checkOrdering(leftPeg);
    checkOrdering(middlePeg);
    checkOrdering(rightPeg);
  }

  /**
   * Check if disks are in descending order.
   *
   * @param disks
   */
  @VisibleForTesting
  static void checkOrdering(Collection<? extends Disk> disks) {
    if (!Comparators.isInStrictOrder(disks, Disk::compareTo)) {
      throw new IllegalArgumentException("disks are not in valid order");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof State)) return false;
    State state = (State) o;
    return Objects.equals(leftPeg, state.leftPeg)
        && Objects.equals(middlePeg, state.middlePeg)
        && Objects.equals(rightPeg, state.rightPeg);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("leftPeg", leftPeg)
        .add("middlePeg", middlePeg)
        .add("rightPeg", rightPeg)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftPeg, middlePeg, rightPeg);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(State state) {
    return new Builder().fromPrototype(state);
  }

  public static class Builder {
    private List<Disk> leftPeg = new ArrayList<>();
    private List<Disk> middlePeg = new ArrayList<>();
    private List<Disk> rightPeg = new ArrayList<>();

    public Builder fromPrototype(State state) {
      leftPeg(state.leftPeg);
      middlePeg(state.middlePeg);
      rightPeg(state.rightPeg);
      return this;
    }

    public Builder leftPeg(List<Disk> leftPeg) {
      this.leftPeg.addAll(leftPeg);
      return this;
    }

    public Builder middlePeg(List<Disk> middlePeg) {
      this.middlePeg.addAll(middlePeg);
      return this;
    }

    public Builder rightPeg(List<Disk> rightPeg) {
      this.rightPeg.addAll(rightPeg);
      return this;
    }

    public Builder removeLastFromLeft() {
      if (!leftPeg.isEmpty()) {
        leftPeg.remove(leftPeg.size() - 1);
      }
      return this;
    }

    public Builder removeLastFromMiddle() {
      if (!middlePeg.isEmpty()) {
        middlePeg.remove(middlePeg.size() - 1);
      }
      return this;
    }

    public Builder removeLastFromRight() {
      if (!rightPeg.isEmpty()) {
        rightPeg.remove(rightPeg.size() - 1);
      }
      return this;
    }

    public Builder leftPeg(Disk disk) {
      leftPeg.add(disk);
      return this;
    }

    public Builder middlePeg(Disk disk) {
      middlePeg.add(disk);
      return this;
    }

    public Builder rightPeg(Disk disk) {
      rightPeg.add(disk);
      return this;
    }

    public State build() {
      return new State(this);
    }
  }
}
