package com.djd.fun.techchapter.hanoi;

import com.google.common.annotations.VisibleForTesting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.djd.fun.techchapter.hanoi.States.Move.LEFT_TO_MIDDLE;
import static com.djd.fun.techchapter.hanoi.States.Move.LEFT_TO_RIGHT;
import static com.djd.fun.techchapter.hanoi.States.Move.MIDDLE_TO_LEFT;
import static com.djd.fun.techchapter.hanoi.States.Move.MIDDLE_TO_RIGHT;
import static com.djd.fun.techchapter.hanoi.States.Move.RIGHT_TO_LEFT;
import static com.djd.fun.techchapter.hanoi.States.Move.RIGHT_TO_MIDDLE;
import static com.djd.fun.techchapter.hanoi.States.isValidMove;

public abstract class Movement {
  private static final Logger log = LoggerFactory.getLogger(Movement.class);

  /**
   * This number to determine when to give up.
   * minimum moves to solve: 2^n − 1 where n is numOfDisks
   */
  private final int maxMoves;
  private final States states;
  protected final Hanoi hanoi;

  protected Movement(int numOfDisks) {
    this.maxMoves = (int)(Math.pow(2, numOfDisks) * 1.5);
    this.hanoi = new Hanoi(numOfDisks);
    this.states = new States();
    // Call this method after states is initialized.
    snapshotCurrentState();
  }

  protected void snapshotCurrentState() {
    states.addState(States.getCurrentState(hanoi));
  }

  public static Movement createMovement(int numOfDisks) {
    return (numOfDisks % 2) == 0
        ? new EvenDiskMovement(numOfDisks)
        : new OddDiskMovement(numOfDisks);
  }

  public abstract void move();

  public boolean isSuccess() {
    return hanoi.isDone();
  }

  public boolean shouldStop() {
    return isSuccess() || states.size() >= maxMoves;
  }

  public void debugPrint() {
//    states.debugPrint();
    log.info("Number of moves:{}", states.size());
  }

  @VisibleForTesting State getCurrentState() {
    return states.getLatestState();
  }

  private static class OddDiskMovement extends Movement {

    public OddDiskMovement(int numOfDisks) {
      super(numOfDisks);
    }

    /**
     * Performs the following set of moves if the number of disks is odd.
     * L -> R (R -> L), L -> M (M -> L), R -> M (M -> R)
     */
    @Override
    public void move() {
      hanoi.move(isValidMove(hanoi, LEFT_TO_RIGHT) ? LEFT_TO_RIGHT : RIGHT_TO_LEFT);
      snapshotCurrentState();
      hanoi.move(isValidMove(hanoi, LEFT_TO_MIDDLE) ? LEFT_TO_MIDDLE : MIDDLE_TO_LEFT);
      snapshotCurrentState();
      hanoi.move(isValidMove(hanoi, RIGHT_TO_MIDDLE) ? RIGHT_TO_MIDDLE : MIDDLE_TO_RIGHT);
      snapshotCurrentState();
    }
  }

  private static class EvenDiskMovement extends Movement {

    private EvenDiskMovement(int numOfDisks) {
      super(numOfDisks);
    }

    /**
     * Performs the following set of moves if the number of disks is even.
     * L -> M (M -> L), L -> R (R -> L), R -> M (M -> R)
     */
    @Override
    public void move() {
      hanoi.move(isValidMove(hanoi, LEFT_TO_MIDDLE) ? LEFT_TO_MIDDLE : MIDDLE_TO_LEFT);
      snapshotCurrentState();
      hanoi.move(isValidMove(hanoi, LEFT_TO_RIGHT) ? LEFT_TO_RIGHT : RIGHT_TO_LEFT);
      snapshotCurrentState();
      hanoi.move(isValidMove(hanoi, RIGHT_TO_MIDDLE) ? RIGHT_TO_MIDDLE : MIDDLE_TO_RIGHT);
      snapshotCurrentState();
    }
  }
}
