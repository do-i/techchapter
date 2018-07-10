package com.djd.fun.techchapter.hanoi;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class EvenDiskMovementTest {
  private static final Disk DISK_1 = new Disk(1);
  private static final Disk DISK_2 = new Disk(2);
  private static final Disk DISK_3 = new Disk(3);
  private static final Disk DISK_4 = new Disk(4);
  private Movement movement;

  @Before
  public void setUp() {
    movement = Movement.createMovement(4);
  }

  @Test
  public void move() {
    movement.move();
    assertThat(movement.getCurrentState()).isEqualTo(State.builder()
        .leftPeg(DISK_4)
        .leftPeg(DISK_3)
        .rightPeg(DISK_2)
        .rightPeg(DISK_1)
        .build());
  }
}