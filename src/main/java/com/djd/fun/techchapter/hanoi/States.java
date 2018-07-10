package com.djd.fun.techchapter.hanoi;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class States {

  private static final Logger log = LoggerFactory.getLogger(States.class);

  enum Move {
    LEFT_TO_MIDDLE,
    LEFT_TO_RIGHT,
    MIDDLE_TO_LEFT,
    MIDDLE_TO_RIGHT,
    RIGHT_TO_LEFT,
    RIGHT_TO_MIDDLE
  }

  private final LinkedList<State> states = new LinkedList<>();

  public void addState(State state) {
    states.add(state);
  }

  public boolean exists(State state) {
    return states.contains(state);
  }

  public int size() {
    return states.size();
  }

  public State getLatestState() {
    return states.getLast();
  }

  public void debugPrint() {
    log.info("States:{}", states);
  }

  public static State getCurrentState(Hanoi hanoi) {
    return State.builder()
        .leftPeg(hanoi.getDisksOnLeftPeg())
        .middlePeg(hanoi.getDisksOnMiddlePeg())
        .rightPeg(hanoi.getDisksOnRightPeg())
        .build();
  }

  public static State createState(Hanoi hanoi, Move move) {
    ImmutableList<Disk> left = hanoi.getDisksOnLeftPeg();
    ImmutableList<Disk> middle = hanoi.getDisksOnMiddlePeg();
    ImmutableList<Disk> right = hanoi.getDisksOnRightPeg();

    State.Builder stateBuilder = State.builder();
    stateBuilder.leftPeg(left);
    stateBuilder.middlePeg(middle);
    stateBuilder.rightPeg(right);

    if (isValidMove(hanoi, move)) {
      switch (move) {
        case LEFT_TO_RIGHT:
          stateBuilder.removeLastFromLeft();
          stateBuilder.rightPeg(Iterables.getLast(left));
          break;
        case LEFT_TO_MIDDLE:
          stateBuilder.removeLastFromLeft();
          stateBuilder.middlePeg(Iterables.getLast(left));
          break;
        case MIDDLE_TO_LEFT:
          stateBuilder.removeLastFromMiddle();
          stateBuilder.leftPeg(Iterables.getLast(middle));
          break;
        case MIDDLE_TO_RIGHT:
          stateBuilder.removeLastFromMiddle();
          stateBuilder.rightPeg(Iterables.getLast(middle));
          break;
        case RIGHT_TO_LEFT:
          stateBuilder.removeLastFromRight();
          stateBuilder.leftPeg(Iterables.getLast(right));
          break;
        case RIGHT_TO_MIDDLE:
          stateBuilder.removeLastFromRight();
          stateBuilder.middlePeg(Iterables.getLast(right));
          break;
        default:
          throw new IllegalStateException("There is not such case: " + move);
      }
    }
    return stateBuilder.build();
  }

  public static boolean isValidMove(Hanoi hanoi, Move move) {
    ImmutableList<Disk> left = hanoi.getDisksOnLeftPeg();
    ImmutableList<Disk> middle = hanoi.getDisksOnMiddlePeg();
    ImmutableList<Disk> right = hanoi.getDisksOnRightPeg();
    switch (move) {
      case LEFT_TO_RIGHT:
        return isValidMove(left, right);
      case LEFT_TO_MIDDLE:
        return isValidMove(left, middle);
      case MIDDLE_TO_LEFT:
        return isValidMove(middle, left);
      case MIDDLE_TO_RIGHT:
        return isValidMove(middle, right);
      case RIGHT_TO_LEFT:
        return isValidMove(right, left);
      case RIGHT_TO_MIDDLE:
        return isValidMove(right, middle);
      default:
        throw new IllegalStateException("There is not such case: " + move);
    }
  }

  @VisibleForTesting static boolean isValidMove(ImmutableList<Disk> from, ImmutableList<Disk> to) {
    if (from.isEmpty()) {
      return false;
    }
    if (to.isEmpty()) {
      return true;
    }
    return Iterables.getLast(from).isSmallerThan(Iterables.getLast(to));
  }
}
