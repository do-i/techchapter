package com.djd.fun.techchapter.hanoi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {

  private static final Logger log = LoggerFactory.getLogger(Player.class);
  private final Movement movement;


  public Player() {
    this(3);
  }

  /**
   * @param numOfDisks number between 2 and 12
   */
  public Player(int numOfDisks) {
    if (numOfDisks < 2 || numOfDisks > 12) {
      throw new IllegalArgumentException("valid numOfDisks range: 2..12");
    }
    this.movement = Movement.createMovement(numOfDisks);
  }

  public void play() {
    while (!movement.shouldStop()) {
      movement.move();
    }
    if (movement.isSuccess()) {
      log.info("Game is Completed.");
    } else {
      log.info("Too many moves. Gave up!");
    }
    movement.debugPrint();
  }
}
